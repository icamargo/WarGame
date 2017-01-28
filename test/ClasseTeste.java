
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
    
    private static ControleJogo controleJogo = new ControleJogo();
    
    public void  Teste(){
        controleJogo.inicializacaoJogo();
        controleJogo.distribuiTerritorios();
        
        System.out.println("Territorios de Jogador: ");
        this.printaTerritorios(jogador);
        System.out.println("Territorios de Computador: ");
        this.printaTerritorios(computador);
    }
    
        public void printaTerritorios(Jogador jogadorAux){
        List<Territorio> listaAux = jogadorAux.getTerritorios();
        
        for (Territorio territorio : listaAux){
            System.out.println(territorio.getNome());
        }
            
    }
        
        

}
