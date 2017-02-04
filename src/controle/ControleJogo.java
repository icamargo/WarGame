package controle;

import java.util.Random;
import java.util.Scanner;
import modelo.Jogador;
import modelo.Territorio;
import visao.InterfacePrincipal;
import static wargame.WarGame.computador;
import static wargame.WarGame.jogador;
import static wargame.WarGame.todosTerritorios;
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
    
    public void distribuiTerritorios(){
        int retornoRandom;
        Jogador jogadorAux;
        
        for (Territorio territorio : todosTerritorios){
            if (!(controleJogador.comparaQtdTerritorios() > 1)) {
                retornoRandom = (aleatorio.nextInt(2));
                controleJogador.atualizaJogador(retornoRandom, territorio);
            }
            else{
                jogadorAux = controleJogador.menorQtdTerritorios();
                controleJogador.atualizaJogador(jogadorAux.getId(), territorio);
            }
        }
    }
    
    public void fasePreparacao() {
        double territorioEscolhido;
        int exercitoEscolhido;
        boolean escolheuTerritorioCerto = false;
        char adicionarExercito = 'S';

        this.inicioFasePreparacao();

        if (controleJogador.verificaExercitoDisponivel(jogador)) {
            System.out.println("Deseja escolher um território e adicionar exército a ele?\n(S) Sim\n(N) Não");
            adicionarExercito = leitura.next().charAt(0);

            while (adicionarExercito == 'S') {
                while (!(escolheuTerritorioCerto)) {
                    System.out.println("Digite a coordenada i,j(onde i = linha e j = coluna) do território que deseja fortificar: (Por exemplo, para escolher o Alasca digite 1,1, Otawa 2,3)");
                    territorioEscolhido = leitura.nextDouble();

                    if (controleJogador.verificaTerritorioJogador(jogador, territorioEscolhido)) {
                        System.out.println("Escolha qual exército deseja fortificar:\n(1) Terrestre.\n(2) Aéreo.");
                        exercitoEscolhido = leitura.nextInt();

                        controleExercito.fortificaExercito(jogador, territorioEscolhido, exercitoEscolhido);
                        escolheuTerritorioCerto = true;
                    } else {
                        System.out.println("Território inválido escolhido (Coordenadas incorretas informadas ou territorio não pertence a você.)! Digite novamente!\n");
                        System.out.println("Tecle enter para continuar...");
                        leitura.nextLine();
                        leitura.nextLine();
                        escolheuTerritorioCerto = false;
                    }
                    controleJogador.listaTerritoriosJogador(jogador);

                    System.out.println("Você possui " + jogador.getExercitosTerrestreDisponiveis() + " exércitos terrestres e " + jogador.getExercitosAereoDisponiveis() + " exércitos aéreos disponíveis, por possuir " + jogador.getTerritorios().size() + " territórios.\n");

                    if (controleJogador.verificaExercitoDisponivel(jogador)) {
                        System.out.println("Você ainda possui exercitos disponíveis. Deseja continuar adicionando aos seus territórios?\n(S) Sim.\n(N) Não.");
                        adicionarExercito = leitura.next().charAt(0);
                        escolheuTerritorioCerto = false;
                    } else {
                        System.out.println("Você distribuiu todos seus exércitos");
                        adicionarExercito = 'N';
                    }
                }
            }
        }
    }
    
    private void inicioFasePreparacao(){
        controleExercito.atualizaExercitosDisponiveis(jogador);
        controleExercito.atualizaExercitosDisponiveis(computador);
        
        System.out.println(jogador.getNome() +" essa é a fase de preparação, nela você poderá fortificar seus territórios com os exércitos, aéreos e terrestres, que você tem disponíveis.");
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        
        System.out.println("Mapa do Jogo: ");
        interfacePrincipal.mapa();
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        
        controleJogador.listaTerritoriosJogador(jogador);
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        
        System.out.println("Você possui " +jogador.getExercitosTerrestreDisponiveis()+ " exércitos terrestres e "+jogador.getExercitosAereoDisponiveis()+" exércitos aéreos disponíveis, por possuir " +jogador.getTerritorios().size()+" territórios.");
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
    }
}