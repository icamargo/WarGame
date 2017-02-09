package wargame;

import teste.ClasseTeste;
import controle.ControleJogador;
import controle.ControleJogo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Continente;
import modelo.Jogador;
import modelo.Territorio;
import visao.InterfacePrincipal;

/**
 *
 * @author Igor
 */
public class WarGame {
    public static Territorio alasca = new Territorio("Alasca", Continente.AMERICA_DO_NORTE, 1.1);
    public static Territorio chile = new Territorio("Chile", Continente.AMERICA_DO_SUL, 4.1);
    public static Territorio argentina = new Territorio("Argentina", Continente.AMERICA_DO_SUL, 5.1);
    public static Territorio vancouver = new Territorio("Vancouver", Continente.AMERICA_DO_NORTE, 1.2);
    public static Territorio california = new Territorio("Califórnia", Continente.AMERICA_DO_NORTE, 2.2);
    public static Territorio mexico = new Territorio("México", Continente.AMERICA_DO_NORTE, 3.2);
    public static Territorio colombia = new Territorio("Colômbia", Continente.AMERICA_DO_SUL, 4.2);
    public static Territorio brasil = new Territorio("Brasil", Continente.AMERICA_DO_SUL, 5.2);
    public static Territorio groelandia = new Territorio("Groelândia", Continente.AMERICA_DO_NORTE, 1.3);
    public static Territorio otawa = new Territorio("Otawa", Continente.AMERICA_DO_NORTE, 2.3);
    public static Territorio novaYork = new Territorio("Nova York", Continente.AMERICA_DO_NORTE, 3.3);
    public static Territorio inglaterra = new Territorio("Inglaterra", Continente.EUROPA, 1.4);
    public static Territorio nigeria = new Territorio("Nigéria", Continente.AFRICA, 3.4);
    public static Territorio congo = new Territorio("Congo", Continente.AFRICA, 4.4);
    public static Territorio africaDoSul = new Territorio("África do Sul", Continente.AFRICA, 5.4);
    public static Territorio italia = new Territorio("Itália", Continente.EUROPA, 1.5);
    public static Territorio alemanha = new Territorio("Alemanha", Continente.EUROPA, 2.5);
    public static Territorio egito = new Territorio("Egito", Continente.AFRICA, 3.5);
    public static Territorio sudao = new Territorio("Sudão", Continente.AFRICA, 4.5);
    public static Territorio madagascar = new Territorio("Madagascar", Continente.AFRICA, 5.5);
    public static Territorio suecia = new Territorio("Suécia", Continente.EUROPA, 1.6);
    public static Territorio moscou = new Territorio("Moscou", Continente.EUROPA, 2.6);
    public static Territorio orienteMedio = new Territorio("Oriente Médio", Continente.ASIA, 3.6);
    public static Territorio sumatra = new Territorio("Sumatra", Continente.OCEANIA, 4.6);
    public static Territorio omsk = new Territorio("Omsk", Continente.ASIA, 2.7);
    public static Territorio india = new Territorio("Índia", Continente.ASIA, 3.7);
    public static Territorio borneu = new Territorio("Bornéu", Continente.OCEANIA, 4.7);
    public static Territorio australia = new Territorio("Austrália", Continente.OCEANIA, 5.7);
    public static Territorio vladivostok = new Territorio("Vladivostok", Continente.ASIA, 1.8);
    public static Territorio siberia = new Territorio("Sibéria", Continente.ASIA, 2.8);
    public static Territorio china = new Territorio("China", Continente.ASIA, 3.8);
    public static Territorio japao = new Territorio("Japão", Continente.ASIA, 4.8);
    public static Territorio novaGuine = new Territorio("Nova Guiné", Continente.OCEANIA, 5.8);
    
    public static Jogador jogador1 = new Jogador(1);
    public static Jogador jogador2 = new Jogador(2);
    
    public static List<Territorio> todosTerritorios = new ArrayList<Territorio>();
    
    public static void main(String[] args) {
        ControleJogo controleJogo = new ControleJogo();
        ControleJogador controleJogador = new ControleJogador();
        InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
        
        interfacePrincipal.titulo();
        controleJogador.inicializaJogadores();
        controleJogo.inicializacaoJogo();
        controleJogo.distribuiTerritorios();
        
        controleJogo.faseInicializacao();
        
        controleJogo.faseCombate(jogador1);
        controleJogo.faseCombate(jogador2);
    }
    
}
