package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Territorio;
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
public class ControleJogo {

    public void inicializacaoJogo() {
        this.defineFronteiras();
    }

    private void defineFronteiras() {
        this.informaFronteira(alasca, 2, vancouver, vladivostok, null, null);
        this.informaFronteira(chile, 3, colombia, argentina, japao, null);
        this.informaFronteira(argentina, 3, chile, brasil, novaGuine, null);
        this.informaFronteira(vancouver, 3, alasca, california, groelandia, null);
        this.informaFronteira(california, 3, vancouver, mexico, otawa, null);
        this.informaFronteira(mexico, 3, california, novaYork, colombia, null);
        this.informaFronteira(colombia, 3, chile, brasil, mexico, null);
        this.informaFronteira(brasil, 2, argentina, colombia, null, null);
        this.informaFronteira(groelandia, 3, vancouver, otawa, inglaterra, null);
        this.informaFronteira(otawa, 3, groelandia, california, novaYork, null);
        this.informaFronteira(novaYork, 3, mexico, otawa, nigeria, null);
        this.informaFronteira(inglaterra, 2, groelandia, italia, null, null);
        this.informaFronteira(nigeria, 3, novaYork, congo, egito, null);
        this.informaFronteira(congo, 3, nigeria, africaDoSul, sudao, null);
        this.informaFronteira(africaDoSul, 2, congo, madagascar, null, null);
        this.informaFronteira(italia, 3, inglaterra, alemanha, suecia, null);
        this.informaFronteira(alemanha, 3, italia, moscou, egito, null);
        this.informaFronteira(egito, 4, alemanha, nigeria, orienteMedio, sudao);
        this.informaFronteira(sudao, 4, congo, egito, madagascar, sumatra);
        this.informaFronteira(madagascar, 2, africaDoSul, sudao, null, null);
        this.informaFronteira(suecia, 2, italia, moscou, null, null);
        this.informaFronteira(moscou, 4, alemanha, suecia, orienteMedio, omsk);
        this.informaFronteira(orienteMedio, 4, egito, moscou, sumatra, india);
        this.informaFronteira(sumatra, 3, sudao, orienteMedio, borneu, null);
        this.informaFronteira(omsk, 3, moscou, india, siberia, null);
        this.informaFronteira(india, 4, orienteMedio, omsk, borneu, china);
        this.informaFronteira(borneu, 4, sumatra, india, australia, japao);
        this.informaFronteira(australia, 2, borneu, novaGuine, null, null);
        this.informaFronteira(vladivostok, 2, alasca, siberia, null, null);
        this.informaFronteira(siberia, 3, omsk, vladivostok, china, null);
        this.informaFronteira(china, 3, india, siberia, japao, null);
        this.informaFronteira(japao, 4, borneu, china, novaGuine, chile);
        this.informaFronteira(novaGuine, 3, australia, japao, argentina, null);
    }
    
    private void informaFronteira(Territorio territorio, int qtdFronteiras, Territorio fronteira1, Territorio fronteira2, Territorio fronteira3, Territorio fronteira4){
        List<Territorio> fronteiras = new ArrayList<Territorio>();
        switch (qtdFronteiras){
            case 1:
                fronteiras.add(fronteira1);
                break;
            case 2:
                fronteiras.add(fronteira1);
                fronteiras.add(fronteira2);
                break;
            case 3:
                fronteiras.add(fronteira1);
                fronteiras.add(fronteira2);
                fronteiras.add(fronteira3);
                break;
            case 4:
                fronteiras.add(fronteira1);
                fronteiras.add(fronteira2);
                fronteiras.add(fronteira3);
                fronteiras.add(fronteira4);
                break;
        }
        territorio.setFronteiras(fronteiras);
    }
}
