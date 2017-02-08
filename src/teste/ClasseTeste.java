package teste;


import controle.ControleJogo;
import java.util.List;
import modelo.Jogador;
import modelo.Territorio;
import static wargame.WarGame.jogador1;
import static wargame.WarGame.jogador2;

/**
 *
 * @author Igor
 */
public class ClasseTeste {    
    public void  Teste(){        
        System.out.println("Territorios de " + jogador2.getNome());
        this.printaTerritorios(jogador2);
        System.out.println("Territorios de " + jogador1.getNome());
        this.printaTerritorios(jogador1);
    }
    
        private void printaTerritorios(Jogador jogadorAux){
        List<Territorio> listaAux = jogadorAux.getTerritorios();
        
        for (Territorio territorio : listaAux){
            System.out.println(territorio.getNome() +" - "+ territorio.getCor());
        }
            
    }
        
        

}
