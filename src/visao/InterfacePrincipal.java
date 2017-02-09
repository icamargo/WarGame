package visao;

import java.util.Scanner;

/**
 *
 * @author Igor
 */
public class InterfacePrincipal {
    private Scanner leitura = new Scanner(System.in);
    
    public void titulo(){
        System.out.println("|----------------------------|");
        System.out.println("|==========WAR GAME==========|");
        System.out.println("|----------------------------|");
        System.out.println("\tBem Vindo ao War!\n");
    }
    
    public void mapa(){
        System.out.println("Mapa do Jogo: ");
        System.out.println(" _1___________|2_______________|3_______________|4_______________|5___________|6___________________|7___________|8____________|");
        System.out.println("1|Alasca      |Vancouver       |Groelândia      |Inglaterra      |Itália      |Suécia              |            |Vladivostok  |");
        System.out.println("2|            |Califórnia      |Otawa           |                |Alemanha    |Moscou              |Omsk        |Siberia      |");
        System.out.println("3|            |México          |Nova York       |Nigéria         |Egito       |Oriente Médio       |Índia       |China        |");
        System.out.println("4|Chile       |Colômbia        |                |Congo           |Sudão       |Sumatra             |Bornéu      |Japão        |");
        System.out.println("5|Argentina   |Brasil          |                |África do Sul   |Madagascar  |                    |Austrália   |Nova Guiné   |\n");
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
    }
        

}
