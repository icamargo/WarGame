package controle;

import java.util.Random;
import modelo.Jogador;
import modelo.Territorio;
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
    private Random aleatorio = new Random();

    public void inicializacaoJogo() {
        controleTerritorio.defineFronteiras();
        controleTerritorio.criaListaTerritorios();
    }
    
    public void distribuiTerritorios(){
        int retornoRandom;
        Jogador jogadorAux;
        
        for (Territorio territorio : todosTerritorios){
            if (!(controleJogador.comparaQtdTerritorios() > 1)) {
                retornoRandom = (aleatorio.nextInt(2));// 0 = Computador - 1 = Jogador
                switch (retornoRandom) {
                    case 0:
                        territorio.setCor(computador.getCor());
                        computador.getTerritorios().add(territorio);
                        break;
                    case 1:
                        territorio.setCor(jogador.getCor());
                        jogador.getTerritorios().add(territorio);
                        break;
                }
            }
            else{
                jogadorAux = controleJogador.menorQtdTerritorios();
                switch (jogadorAux.getId()) {
                    case 0:
                        territorio.setCor(computador.getCor());
                        computador.getTerritorios().add(territorio);
                        break;
                    case 1:
                        territorio.setCor(jogador.getCor());
                        jogador.getTerritorios().add(territorio);
                        break;
                }
            }
        }
    }
    
}