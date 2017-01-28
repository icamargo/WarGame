package controle;

import modelo.Aereo;
import modelo.Cor;
import modelo.Jogador;
import modelo.Terrestre;
import modelo.Territorio;
import static wargame.WarGame.computador;
import static wargame.WarGame.jogador;

/**
 *
 * @author Igor
 */
public class ControleJogador {
    
    public int comparaQtdTerritorios(){
        int diferenca = Math.abs(jogador.getTerritorios().size() - computador.getTerritorios().size());
        return diferenca;
    }
    
    public Jogador menorQtdTerritorios(){
        int menor = jogador.getTerritorios().size();
        if(menor < computador.getTerritorios().size()){
            return jogador;
        }
        else{
            return computador;
        }
            
    }
    public void informaCor(int escolhaJogador){//(1) Azul (2) Vermelho.
        if(escolhaJogador == 1){
            jogador.setCor(Cor.AZUL);
            computador.setCor(Cor.VERMELHO);
        }
        else{
            jogador.setCor(Cor.VERMELHO);
            computador.setCor(Cor.AZUL);
        }
    }
    
    public void atualizaJogador(int jogadorSorteado, Territorio territorio) {
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
