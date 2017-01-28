package controle;

import java.util.Random;
import modelo.Aereo;
import modelo.Jogador;
import modelo.Terrestre;
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
                retornoRandom = (aleatorio.nextInt(2));
                this.atualizaJogador(retornoRandom, territorio);
            }
            else{
                jogadorAux = controleJogador.menorQtdTerritorios();
                this.atualizaJogador(jogadorAux.getId(), territorio);
            }
        }
    }
    
    private void atualizaJogador(int jogadorSorteado, Territorio territorio) {
        switch (jogadorSorteado) {// 0 = Computador - 1 = Jogador
            case 0:
                territorio.setCor(computador.getCor());
                territorio.getExercitosAereo().add(new Aereo());
                territorio.getExercitosTerrestre().add(new Terrestre());
                computador.getTerritorios().add(territorio);
                break;
            case 1:
                territorio.setCor(jogador.getCor());
                territorio.getExercitosAereo().add(new Aereo());
                territorio.getExercitosTerrestre().add(new Terrestre());
                jogador.getTerritorios().add(territorio);
                break;
        }
    }
    
}