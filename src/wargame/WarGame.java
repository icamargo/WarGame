package wargame;

import java.util.Random;

/**
 *
 * @author Igor
 */
public class WarGame {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //instância um objeto da classe Random usando o construtor padrão
		Random gerador = new Random();
	    
		//imprime sequência de 10 números inteiros aleatórios
	    for (int i = 0; i < 10; i++) {
	    	System.out.println(gerador.nextInt(6) + 1);
	 	}
    }
    
}
