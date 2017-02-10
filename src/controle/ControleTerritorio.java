package controle;

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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Jogador;
import modelo.Territorio;
import visao.InterfacePrincipal;
import static wargame.WarGame.todosTerritorios;

/**
 *
 * @author Igor
 */
public class ControleTerritorio {
    
    public void defineFronteiras() {
        this.informaFronteiras(alasca, 2, vancouver, vladivostok, null, null);
        this.informaFronteiras(chile, 3, colombia, argentina, japao, null);
        this.informaFronteiras(argentina, 3, chile, brasil, novaGuine, null);
        this.informaFronteiras(vancouver, 3, alasca, california, groelandia, null);
        this.informaFronteiras(california, 3, vancouver, mexico, otawa, null);
        this.informaFronteiras(mexico, 3, california, novaYork, colombia, null);
        this.informaFronteiras(colombia, 3, chile, brasil, mexico, null);
        this.informaFronteiras(brasil, 2, argentina, colombia, null, null);
        this.informaFronteiras(groelandia, 3, vancouver, otawa, inglaterra, null);
        this.informaFronteiras(otawa, 3, groelandia, california, novaYork, null);
        this.informaFronteiras(novaYork, 3, mexico, otawa, nigeria, null);
        this.informaFronteiras(inglaterra, 2, groelandia, italia, null, null);
        this.informaFronteiras(nigeria, 3, novaYork, congo, egito, null);
        this.informaFronteiras(congo, 3, nigeria, africaDoSul, sudao, null);
        this.informaFronteiras(africaDoSul, 2, congo, madagascar, null, null);
        this.informaFronteiras(italia, 3, inglaterra, alemanha, suecia, null);
        this.informaFronteiras(alemanha, 3, italia, moscou, egito, null);
        this.informaFronteiras(egito, 4, alemanha, nigeria, orienteMedio, sudao);
        this.informaFronteiras(sudao, 4, congo, egito, madagascar, sumatra);
        this.informaFronteiras(madagascar, 2, africaDoSul, sudao, null, null);
        this.informaFronteiras(suecia, 2, italia, moscou, null, null);
        this.informaFronteiras(moscou, 4, alemanha, suecia, orienteMedio, omsk);
        this.informaFronteiras(orienteMedio, 4, egito, moscou, sumatra, india);
        this.informaFronteiras(sumatra, 3, sudao, orienteMedio, borneu, null);
        this.informaFronteiras(omsk, 3, moscou, india, siberia, null);
        this.informaFronteiras(india, 4, orienteMedio, omsk, borneu, china);
        this.informaFronteiras(borneu, 4, sumatra, india, australia, japao);
        this.informaFronteiras(australia, 2, borneu, novaGuine, null, null);
        this.informaFronteiras(vladivostok, 2, alasca, siberia, null, null);
        this.informaFronteiras(siberia, 3, omsk, vladivostok, china, null);
        this.informaFronteiras(china, 3, india, siberia, japao, null);
        this.informaFronteiras(japao, 4, borneu, china, novaGuine, chile);
        this.informaFronteiras(novaGuine, 3, australia, japao, argentina, null);
    }
    
    private void informaFronteiras(Territorio territorio, int qtdFronteiras, Territorio fronteira1, Territorio fronteira2, Territorio fronteira3, Territorio fronteira4){
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
    
    public void criaListaTerritorios(){
        todosTerritorios.add(alasca);
        todosTerritorios.add(chile);
        todosTerritorios.add(argentina);
        todosTerritorios.add(vancouver);
        todosTerritorios.add(california);
        todosTerritorios.add(mexico);
        todosTerritorios.add(colombia);
        todosTerritorios.add(brasil);
        todosTerritorios.add(groelandia);
        todosTerritorios.add(otawa);
        todosTerritorios.add(novaYork);
        todosTerritorios.add(inglaterra);
        todosTerritorios.add(nigeria);
        todosTerritorios.add(congo);
        todosTerritorios.add(africaDoSul);
        todosTerritorios.add(italia);
        todosTerritorios.add(alemanha);
        todosTerritorios.add(egito);
        todosTerritorios.add(sudao);
        todosTerritorios.add(madagascar);
        todosTerritorios.add(suecia);
        todosTerritorios.add(moscou);
        todosTerritorios.add(orienteMedio);
        todosTerritorios.add(sumatra);
        todosTerritorios.add(omsk);
        todosTerritorios.add(india);
        todosTerritorios.add(borneu);
        todosTerritorios.add(australia);
        todosTerritorios.add(vladivostok);
        todosTerritorios.add(siberia);
        todosTerritorios.add(china);
        todosTerritorios.add(japao);
        todosTerritorios.add(novaGuine);
    }
    
    public boolean validaTerritorio(double coordTerritorio, int tipoCombate) {
        boolean aceito = false;

        for (Territorio territorio : todosTerritorios) {
            if (territorio.getCoordenada() == coordTerritorio) {
                switch (tipoCombate) {//(1) Terrestre (2)Aéreo
                    case 1:
                        if (territorio.getExercitosTerrestre().size() > 1) {
                            aceito = true;
                        } else {
                            aceito = false;
                        }
                        break;
                    case 2:
                        if (territorio.getExercitosAereo().size() > 1) {
                            aceito = true;
                        } else {
                            aceito = false;
                        }
                        break;
                }
            }
        }
        return aceito;
    }
    
    public boolean validaAtaque (double territorioAtacante, double territorioAtacado){
        boolean aceitaAtaque;
        Territorio territorioAtaque = this.buscarTerritorio(territorioAtacante);
        Territorio territorioDefesa = this.buscarTerritorio(territorioAtacado);
        
        
        if(this.validaFronteira(territorioAtacante, territorioAtacado)){
            if(territorioAtaque.getCor() != territorioDefesa.getCor()){
                aceitaAtaque = true;
            }
            else{
                System.out.println("Territórios informados pertencem ao mesmo jogador!");
                aceitaAtaque = false;//territorios pertencem ao mesmo jogador
            }
        }
        else{
            System.out.println("Territórios informados não fazem fronteira!");
            aceitaAtaque = false;//territorios nao fazem fronteira
        }
        return aceitaAtaque;
    }
    
    private boolean validaFronteira(double territorioAtacante, double territorioAtacado){
        Territorio territorioAtaque = this.buscarTerritorio(territorioAtacante);
        
        List<Territorio> fronteirasTerritorioAtacante = territorioAtaque.getFronteiras();
        boolean fronteiraValida = false;
        
        for(Territorio territorio : fronteirasTerritorioAtacante){
            if(territorio.getCoordenada() == territorioAtacado){
                fronteiraValida = true;
                break;
            }
            else{
                fronteiraValida = false;
            }
        }
        return fronteiraValida;
    }
    
    public Territorio buscarTerritorio(double coordTerritorio){
        Territorio territorioAux = null;
        
        for(Territorio territorio : todosTerritorios){
            if(territorio.getCoordenada() == coordTerritorio){
                territorioAux = territorio;
                break;
            }
        }
        return territorioAux;
    }
    
    public void exibeMapaTerritorios(Jogador jogador){
        InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
        ControleJogador controleJogador = new ControleJogador();
        Scanner leitura = new Scanner(System.in);
        
        interfacePrincipal.mapa();
        
        controleJogador.listaTerritoriosJogador(jogador);
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        
        controleJogador.listaTerritoriosAdversario(jogador);
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
    }
}
