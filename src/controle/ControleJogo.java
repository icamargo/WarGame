package controle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import modelo.Jogador;
import modelo.Territorio;
import visao.InterfacePrincipal;
import static wargame.WarGame.todosTerritorios;
import static wargame.WarGame.jogador1;
import static wargame.WarGame.jogador2;
import static wargame.WarGame.territoriosAfrica;
import static wargame.WarGame.territoriosAmericaDoNorte;
import static wargame.WarGame.territoriosAmericaDoSul;
import static wargame.WarGame.territoriosAsia;
import static wargame.WarGame.territoriosEuropa;
import static wargame.WarGame.territoriosOceania;
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
        controleTerritorio.criaContinentes();
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
                                this.combateTerrestre(territorioEscolhido, jogador);
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
        System.out.println("\n"+jogador.getNome()+", essa é a fase de combate, nela você poderá atacar territórios inimigos para tentar conquistá-los.\nTecle enter para continuar...");
        leitura.nextLine();
        leitura.nextLine();
        
        controleTerritorio.exibeMapaTerritorios(jogador);
    }
    
    private void combateTerrestre(double territorioAtacante, Jogador jogadorAtacante){
        double territorioAtacado;
        int qtdExercitoAtaque;
        
        System.out.println("Digite a coordenada do territorio que deseja atacar: ");
        territorioAtacado = leitura.nextDouble();
        
        if(controleTerritorio.validaAtaque(territorioAtacante, territorioAtacado)){
            System.out.println("Digite a quantidade de exércitos terrestre que deseja utilizar no ataque (Máximo Permitido = 3):");
            qtdExercitoAtaque = leitura.nextInt();
            this.ataque("Terrestre", territorioAtacante, qtdExercitoAtaque, territorioAtacado, jogadorAtacante);
        }
        
        controleTerritorio.exibeMapaTerritorios(jogadorAtacante);
        
    }
    
    private void combateAereo(double territorioAtacante){
        //validar se territorio escolhido pode ser usado para ataque
        //validar territorio escolhido para ser atacado
        System.out.println("COMBATE AEREO!!");
    }
    
    private void ataque(String tipoAtaque, double territorioAtacante, int qtdExercitoAtaque, double territorioAtacado, Jogador jogadorAtacante){
        Territorio territorioAtaque = controleTerritorio.buscarTerritorio(territorioAtacante);
        boolean qtdAtaqueAceita = false;
        
        switch (tipoAtaque) {
            case "Terrestre":
                do {
                    if (qtdExercitoAtaque <= 3) {
                        if ((qtdExercitoAtaque) <= ((territorioAtaque.getExercitosTerrestre().size())-1)) {//-1 porque fica um exercito guardando o territorio
                            this.realizaAtaque("Terrestre", territorioAtaque, qtdExercitoAtaque, territorioAtacado, jogadorAtacante);
                            qtdAtaqueAceita = true;
                        } else {
                            System.out.println("Quantidade digitada inválida! Este territorio possui " + ((territorioAtaque.getExercitosTerrestre().size())-1) + " exércitos terrestres que podem ser usados para atacar!");
                            qtdExercitoAtaque = leitura.nextInt();
                            qtdAtaqueAceita = false;
                        }
                    } else {
                        System.out.println("Quantidade digitada inválida (Máximo Permitido = 3)!\nDigite novamente:");
                        qtdExercitoAtaque = leitura.nextInt();
                        qtdAtaqueAceita = false;
                    }

                } while (!(qtdAtaqueAceita));
                break;
            case "Aereo":
                break;
        }
    }
    
    private void realizaAtaque(String tipoAtaque, Territorio territorioAtacante, int qtdExercitoAtaque, double territorioAtacado, Jogador jogadorAtacante){
        Territorio territorioDefesa = controleTerritorio.buscarTerritorio(territorioAtacado);
        List<Integer> resultadoAtaque = new ArrayList<Integer>();
        List<Integer> resultadoDefesa = new ArrayList<Integer>();
        int qtdComparacoes=0;
        
        for(int i = 1; i<=qtdExercitoAtaque; i++){
            switch(tipoAtaque){
                case "Terrestre":
                    resultadoAtaque.add(territorioAtacante.getExercitosTerrestre().get((i-1)).combater());
                    break;
                case "Aereo":
                    break;
            }
        }
        switch(tipoAtaque){
            case "Terrestre":
                for(int i=1; i<=controleExercito.retornaQtdExercitoDefesa("Terrestre", territorioDefesa); i++){
                    resultadoDefesa.add(territorioDefesa.getExercitosTerrestre().get((i-1)).combater());
                }
                break;
            case "Aereo":
                break;
        }
        resultadoAtaque = this.ordenaListaResultado(resultadoAtaque);
        resultadoDefesa = this.ordenaListaResultado(resultadoDefesa);
        
        qtdComparacoes = Math.min(resultadoAtaque.size(), resultadoDefesa.size());
        
        for (int i = 0; i < qtdComparacoes; i++) {
            if (resultadoAtaque.get(i) > resultadoDefesa.get(i)) {
                //defensor perde um exercito
                switch(tipoAtaque){
                    case "Terrestre":
                        territorioDefesa.getExercitosTerrestre().remove(0);
                        System.out.println("Você derrotou um exército do território inimigo:\nResultado do combate: Seu Exército "+resultadoAtaque.get(i) + " X "+resultadoDefesa.get(i)+" Exército Adversário\nTecle enter para continuar...");
                        leitura.nextLine();
                        leitura.nextLine();
                        break;
                    case "Aereo":
                        break;
                }
            } else {
                //atacante perde um exercito
                switch(tipoAtaque){
                    case "Terrestre":
                        territorioAtacante.getExercitosTerrestre().remove(0);
                        System.out.println("Você perdeu um exército do seu território:\nResultado do combate: Seu Exército "+resultadoAtaque.get(i) + " X "+resultadoDefesa.get(i)+" Exército Adversário\nTecle enter para continuar...");
                        leitura.nextLine();
                        leitura.nextLine();
                        break;
                    case "Aereo":
                        break;
                }
                
            }
        }
        
        switch(tipoAtaque){
            case "Terrestre":
                if(territorioDefesa.getExercitosTerrestre().isEmpty()){
                    controleJogador.atualizaTerritorioConquistado(jogadorAtacante, territorioDefesa);
                    this.verificaVencedor();
                    controleExercito.moverExercitoTerritorioConsquistado(tipoAtaque, territorioAtacante, territorioDefesa, qtdExercitoAtaque);
                }
                break;
            case "Aereo":
                break;
        }
        
    }
    
    private List ordenaListaResultado(List listaResultados){//ordena em ordem descrescente
        Collections.sort(listaResultados);
        Collections.reverse(listaResultados);
        return listaResultados;
    }
    
    public boolean verificaVencedor(){
        boolean jogoAcabou = false;
        List<Territorio> listaAuxJogador1 = new ArrayList<Territorio>(); 
        List<Territorio> listaAuxJogador2 = new ArrayList<Territorio>();
        
        for (Territorio territorio : territoriosAmericaDoNorte) {
            //controleTerritorio.verificaOcupacaoContinente(jogador1, territorio, territoriosAmericaDoNorte);
            if (jogador1.getTerritorios().contains(territorio)) {
                listaAuxJogador1.add(territorio);
            }
            if (listaAuxJogador1.size() == territoriosAmericaDoNorte.size()) {
                jogador1.setPontuacao(jogador1.getPontuacao() + 1);
            }
            //controleTerritorio.verificaOcupacaoContinente(jogador2, territorio, territoriosAmericaDoNorte);
            if (jogador2.getTerritorios().contains(territorio)) {
                listaAuxJogador2.add(territorio);
            }
            if (listaAuxJogador2.size() == territoriosAmericaDoNorte.size()) {
                jogador2.setPontuacao(jogador2.getPontuacao() + 1);
            }
        }
        listaAuxJogador1 = new ArrayList<Territorio>();
        listaAuxJogador2 = new ArrayList<Territorio>();
        for(Territorio territorio : territoriosAmericaDoSul){
            //controleTerritorio.verificaOcupacaoContinente(jogador1, territorio, territoriosAmericaDoSul);
            if (jogador1.getTerritorios().contains(territorio)) {
                listaAuxJogador1.add(territorio);
            }
            if (listaAuxJogador1.size() == territoriosAmericaDoSul.size()) {
                jogador1.setPontuacao(jogador1.getPontuacao() + 1);
            }
            //controleTerritorio.verificaOcupacaoContinente(jogador2, territorio, territoriosAmericaDoSul);
            if (jogador2.getTerritorios().contains(territorio)) {
                listaAuxJogador2.add(territorio);
            }
            if (listaAuxJogador2.size() == territoriosAmericaDoSul.size()) {
                jogador2.setPontuacao(jogador2.getPontuacao() + 1);
            }
        }
        listaAuxJogador1 = new ArrayList<Territorio>();
        listaAuxJogador2 = new ArrayList<Territorio>();
        for(Territorio territorio : territoriosEuropa){
            //controleTerritorio.verificaOcupacaoContinente(jogador1, territorio, territoriosEuropa);
            if (jogador1.getTerritorios().contains(territorio)) {
                listaAuxJogador1.add(territorio);
            }
            if (listaAuxJogador1.size() == territoriosEuropa.size()) {
                jogador1.setPontuacao(jogador1.getPontuacao() + 1);
            }
            //controleTerritorio.verificaOcupacaoContinente(jogador2, territorio, territoriosEuropa);
            if (jogador2.getTerritorios().contains(territorio)) {
                listaAuxJogador2.add(territorio);
            }
            if (listaAuxJogador2.size() == territoriosEuropa.size()) {
                jogador2.setPontuacao(jogador2.getPontuacao() + 1);
            }
        }
        listaAuxJogador1 = new ArrayList<Territorio>();
        listaAuxJogador2 = new ArrayList<Territorio>();
        for(Territorio territorio : territoriosAfrica){
            //controleTerritorio.verificaOcupacaoContinente(jogador1, territorio, territoriosAfrica);
            if (jogador1.getTerritorios().contains(territorio)) {
                listaAuxJogador1.add(territorio);
            }
            if (listaAuxJogador1.size() == territoriosAfrica.size()) {
                jogador1.setPontuacao(jogador1.getPontuacao() + 1);
            }
            //controleTerritorio.verificaOcupacaoContinente(jogador2, territorio, territoriosAfrica);
            if (jogador2.getTerritorios().contains(territorio)) {
                listaAuxJogador2.add(territorio);
            }
            if (listaAuxJogador2.size() == territoriosAfrica.size()) {
                jogador2.setPontuacao(jogador2.getPontuacao() + 1);
            }
        }
        listaAuxJogador1 = new ArrayList<Territorio>();
        listaAuxJogador2 = new ArrayList<Territorio>();
        for(Territorio territorio : territoriosAsia){
            //controleTerritorio.verificaOcupacaoContinente(jogador1, territorio, territoriosAsia);
            if (jogador1.getTerritorios().contains(territorio)) {
                listaAuxJogador1.add(territorio);
            }
            if (listaAuxJogador1.size() == territoriosAsia.size()) {
                jogador1.setPontuacao(jogador1.getPontuacao() + 1);
            }
            //controleTerritorio.verificaOcupacaoContinente(jogador2, territorio, territoriosAsia);
            if (jogador2.getTerritorios().contains(territorio)) {
                listaAuxJogador2.add(territorio);
            }
            if (listaAuxJogador2.size() == territoriosAsia.size()) {
                jogador2.setPontuacao(jogador2.getPontuacao() + 1);
            }
        }
        listaAuxJogador1 = new ArrayList<Territorio>();
        listaAuxJogador2 = new ArrayList<Territorio>();
        for(Territorio territorio : territoriosOceania){
            //controleTerritorio.verificaOcupacaoContinente(jogador1, territorio, territoriosOceania);
            if (jogador1.getTerritorios().contains(territorio)) {
                listaAuxJogador1.add(territorio);
            }
            if (listaAuxJogador1.size() == territoriosOceania.size()) {
                jogador1.setPontuacao(jogador1.getPontuacao() + 1);
            }
            //controleTerritorio.verificaOcupacaoContinente(jogador2, territorio, territoriosOceania);
            if (jogador2.getTerritorios().contains(territorio)) {
                listaAuxJogador2.add(territorio);
            }
            if (listaAuxJogador2.size() == territoriosOceania.size()) {
                jogador2.setPontuacao(jogador2.getPontuacao() + 1);
            }
        }
        if(jogador1.getPontuacao() == 2){
            System.out.println("Parabéns "+jogador1.getNome()+" você venceu o jogo!");
            jogoAcabou = true;
            System.exit(0);
        }
        else if(jogador2.getPontuacao() == 2){
            System.out.println("Parabéns "+jogador2.getNome()+" você venceu o jogo!");
            jogoAcabou = true;
            System.exit(0);
        }
        return jogoAcabou;
    }
}