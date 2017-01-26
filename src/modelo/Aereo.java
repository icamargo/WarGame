package modelo;

import java.util.Random;

/**
 *
 * @author Igor
 */
public class Aereo extends Exercito{
    
    @Override
    public int combater(){
        int retorno = 0;
        Random aleatorio = new Random();
        
        retorno = (aleatorio.nextInt(6)+1);
        
        return retorno;
    }
}
