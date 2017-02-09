package controle;

import java.util.Random;
import java.util.Scanner;
import modelo.Jogador;
import modelo.Territorio;
import visao.InterfacePrincipal;
import static wargame.WarGame.todosTerritorios;
import static wargame.WarGame.jogador1;
import static wargame.WarGame.jogador2;
/**
 *
 * @author Igor
 */
public class ControleJogo {
    private ControleTerritorio controleTerritorio = new ControleTerritorio();
    private ControleJogador controleJogador = new ControleJogador();
    private ControleExercito controleExercito = new ControleExercito();
    private InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
    private Random aleatorio = new Random();
    private Scanner leitura = new Scanner(System.in);

    public void inicializacaoJogo() {
        controleTerritorio.defineFronteiras();
        controleTerritorio.criaListaTerritorios();
    }
    
    public void faseInicializacao(){
        System.out.println("Ok jogadores, vamos começar o jogo!\nGanha o jogo quem conquistar totalmente dois continentes quaisquer.\nVamos lá!");
        System.out.println("Tecle enter para iniciar o jogo...");
        leitura.nextLine();
        
        System.out.println(jogador1.getNome()+ ", sua vez de jogar. Tecle enter para iniciar a jogada...");
        leitura.nextLine();
        this.fasePreparacao(jogador1);
        System.out.println("\n"+jogador2.getNome()+ ", sua vez de jogar. Tecle enter para iniciar a jogada...");
        leitura.nextLine();
        leitura.nextLine();
        this.fasePreparacao(jogador2);
    }
    
    public void distribuiTerritorios(){
        int retornoRandom;
        Jogador jogadorAux;
        
        for (Territorio territorio : todosTerritorios){
            if (!(controleJogador.comparaQtdTerritorios() > 1)) {
                retornoRandom = (aleatorio.nextInt(2)+1);
                controleJogador.atualizaJogador(retornoRandom, territorio);
            }
            else{
                jogadorAux = controleJogador.menorQtdTerritorios();
                controleJogador.atualizaJogador(jogadorAux.getId(), territorio);
            }
        }
    }
    
    public void fasePreparacao(Jogador jogador) {
        double territorioEscolhido;
        int exercitoEscolhido;
        char adicionarExercito = 'S';

        this.inicioFasePreparacao(jogador);

        if (controleJogador.verificaExercitoDisponivel(jogador)) {
            System.out.println("Deseja escolher um território e adicionar exército a ele?\n(S) Sim\n(N) Não");
            adicionarExercito = leitura.next().charAt(0);

            while (adicionarExercito == 'S') {
                System.out.println("Digite a coordenada i,j(onde i = linha e j = coluna) do território que deseja fortificar: (Por exemplo, para escolher o Alasca digite 1,1, Otawa 2,3)");
                territorioEscolhido = leitura.nextDouble();

                if (controleJogador.verificaTerritorioJogador(jogador, territorioEscolhido)) {
                    System.out.println("Escolha qual exército deseja fortificar:\n(1) Terrestre.\n(2) Aéreo.");
                    exercitoEscolhido = leitura.nextInt();

                    controleExercito.fortificaExercito(jogador, territorioEscolhido, exercitoEscolhido);
                    adicionarExercito = 'S';
                } else {
                    System.out.println("Território inválido escolhido (Coordenadas incorretas informadas ou territorio não pertence a você.)!\n");
                    System.out.println("Tecle enter para continuar...");
                    leitura.nextLine();
                    leitura.nextLine();
                    adicionarExercito = 'N';
                }
                controleJogador.listaTerritoriosJogador(jogador);

                System.out.println("Você possui " + jogador.getExercitosTerrestreDisponiveis() + " exércitos terrestres e " + jogador.getExercitosAereoDisponiveis() + " exércitos aéreos disponíveis, por possuir " + jogador.getTerritorios().size() + " territórios.\n");

                if (controleJogador.verificaExercitoDisponivel(jogador)) {
                    System.out.println("Você ainda possui exercitos disponíveis. Deseja continuar adicionando aos seus territórios?\n(S) Sim.\n(N) Não.");
                    adicionarExercito = leitura.next().charAt(0);
                } else {
                    System.out.println(jogador.getNome() + ", você distribuiu todos seus exércitos!\n");
                    adicionarExercito = 'N';
                }
            }
        }
    }
    
    private void inicioFasePreparacao(Jogador jogador){
        controleExercito.atualizaExercitosDisponiveis(jogador);
        
        System.out.println(jogador.getNome() +" essa é a fase de preparação, nela você poderá fortificar seus territórios com os exércitos, aéreos e terrestres, que você tem disponíveis.");
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        
        interfacePrincipal.mapa();
        
        controleJogador.listaTerritoriosJogador(jogador);
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        
        System.out.println("Você possui " +jogador.getExercitosTerrestreDisponiveis()+ " exércitos terrestres e "+jogador.getExercitosAereoDisponiveis()+" exércitos aéreos disponíveis, por possuir " +jogador.getTerritorios().size()+" territórios.");
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
    }
    
    public void faseCombate(Jogador jogador) {
        double territorioEscolhido;
        char atacarNovamente = 'S';
        int tipoCombate;//(1) Terrestre (2)Aéreo
        boolean territorioAceito = false;

        do {
            this.inicioFaseCombate(jogador);

            System.out.println("Escolha qual tipo de combate deseja realizar:\n(1) Terrestre.\n(2) Aéreo");
            tipoCombate = leitura.nextInt();

            while (!((tipoCombate == 1) || (tipoCombate == 2))) {
                System.out.println("Opção inválida, escolha novamente!");
                tipoCombate = leitura.nextInt();
            }

            System.out.println("Digite a coordenada i,j(onde i = linha e j = coluna) do território que deseja utilizar para atacar: (Por exemplo, para escolher o Alasca digite 1,1, Otawa 2,3)");
            territorioEscolhido = leitura.nextDouble();

            do {
                if (controleJogador.verificaTerritorioJogador(jogador, territorioEscolhido)) {
                    if (controleTerritorio.validaTerritorio(territorioEscolhido, tipoCombate)) {
                        switch (tipoCombate) {
                            case 1:
                                this.combateTerrestre(territorioEscolhido);
                                break;
                            case 2:
                                this.combateAereo(territorioEscolhido);
                                break;
                        }
                        territorioAceito = true;
                    } else {
                        System.out.println("Território escolhido não pode ser usado para ataque!\nEscolha um territorio que possua uma quantidade superior a 1 exército!\nDigite as coordenadas novamente:");
                        territorioEscolhido = leitura.nextDouble();
                        territorioAceito = false;
                    }
                } else {
                    System.out.println("Território inválido escolhido (Coordenadas incorretas informadas ou territorio não pertence a você.)! Digite novamente!");
                    territorioEscolhido = leitura.nextDouble();
                    territorioAceito = false;
                }

            } while (!(territorioAceito));

            System.out.println("Deseja realizar um novo ataque?\n(S) Sim.\n(N) Não.");
            atacarNovamente = leitura.next().charAt(0);
        } while (atacarNovamente == 'S');
    }
    
    private void inicioFaseCombate(Jogador jogador){
        System.out.println(jogador.getNome()+", essa é a fase de combate, nela você poderá atacar territórios inimigos para tentar conquistá-los.\nTecle enter para continuar...");
        leitura.nextLine();
        leitura.nextLine();
        
        interfacePrincipal.mapa();
        
        controleJogador.listaTerritoriosJogador(jogador);
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        
        controleJogador.listaTerritoriosAdversario(jogador);
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
    }
    
    private void combateTerrestre(double territorioAtacante){
        //validar se territorio escolhido pode ser usado para ataque
        //validar territorio escolhido para ser atacado
        double territorioAtacado;
        
        System.out.println("Digite a coordenada do territorio que deseja atacar: ");
        territorioAtacado = leitura.nextDouble();
        
        if(controleTerritorio.validaAtaque(territorioAtacante, territorioAtacado)){
            System.out.println("ACEITA ATAQUE!");
        }
        else{
            System.out.println("NÃO ACEITA ATAQUE!");
        }
        
    }
    
    private void combateAereo(double territorioAtacante){
        //validar se territorio escolhido pode ser usado para ataque
        //validar territorio escolhido para ser atacado
        System.out.println("COMBATE AEREO!!");
    }
}