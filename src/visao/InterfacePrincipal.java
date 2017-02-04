package visao;

import static wargame.WarGame.africaDoSul;
import static wargame.WarGame.alasca;
import static wargame.WarGame.alemanha;
import static wargame.WarGame.argentina;
import static wargame.WarGame.australia;
import static wargame.WarGame.borneu;
import static wargame.WarGame.brasil;
import static wargame.WarGame.california;
import static wargame.WarGame.chile;
import static wargame.WarGame.china;
import static wargame.WarGame.colombia;
import static wargame.WarGame.congo;
import static wargame.WarGame.egito;
import static wargame.WarGame.groelandia;
import static wargame.WarGame.india;
import static wargame.WarGame.inglaterra;
import static wargame.WarGame.italia;
import static wargame.WarGame.japao;
import static wargame.WarGame.madagascar;
import static wargame.WarGame.mexico;
import static wargame.WarGame.moscou;
import static wargame.WarGame.nigeria;
import static wargame.WarGame.novaGuine;
import static wargame.WarGame.novaYork;
import static wargame.WarGame.omsk;
import static wargame.WarGame.orienteMedio;
import static wargame.WarGame.otawa;
import static wargame.WarGame.siberia;
import static wargame.WarGame.sudao;
import static wargame.WarGame.suecia;
import static wargame.WarGame.sumatra;
import static wargame.WarGame.vancouver;
import static wargame.WarGame.vladivostok;
/**
 *
 * @author Igor
 */
public class InterfacePrincipal {
    
    public void titulo(){
        System.out.println("|----------------------------|");
        System.out.println("|==========WAR GAME==========|");
        System.out.println("|----------------------------|");
        System.out.println("\tBem Vindo ao War!\n");
        System.out.println("Por favor, digite seu nome:");
    }
    
    public void mapa(){
        System.out.println(" _1___________|2_______________|3_______________|4_______________|5___________|6___________________|7___________|8____________|");
        System.out.println("1|Alasca      |Vancouver       |Groelândia      |Inglaterra      |Itália      |Suécia              |            |Vladivostok  |");
        System.out.println("2|            |Califórnia      |Otawa           |                |Alemanha    |Moscou              |Omsk        |Siberia      |");
        System.out.println("3|            |México          |Nova York       |Nigéria         |Egito       |Oriente Médio       |Índia       |China        |");
        System.out.println("4|Chile       |Colômbia        |                |Congo           |Sudão       |Sumatra             |Bornéu      |Japão        |");
        System.out.println("5|Argentina   |Brasil          |                |África do Sul   |Madagascar  |                    |Austrália   |Nova Guiné   |\n");
    }
        

}
