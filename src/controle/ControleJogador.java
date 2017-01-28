package controle;

import modelo.Jogador;
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
        

}
