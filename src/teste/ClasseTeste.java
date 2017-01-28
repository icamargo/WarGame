package teste;


import controle.ControleJogo;
import java.util.List;
import modelo.Jogador;
import modelo.Territorio;
import static wargame.WarGame.computador;
import static wargame.WarGame.jogador;

/**
 *
 * @author Igor
 */
public class ClasseTeste {    
    public void  Teste(){        
        System.out.println("Territorios de " + jogador.getNome());
        this.printaTerritorios(jogador);
        System.out.println("Territorios de " + computador.getNome());
        this.printaTerritorios(computador);
    }
    
        private void printaTerritorios(Jogador jogadorAux){
        List<Territorio> listaAux = jogadorAux.getTerritorios();
        
        for (Territorio territorio : listaAux){
            System.out.println(territorio.getNome() +" - "+ territorio.getCor());
        }
            
    }
        
        

}
