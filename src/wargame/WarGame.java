package wargame;

import teste.ClasseTeste;
import controle.ControleJogador;
import controle.ControleJogo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Continente;
import modelo.Cor;
import modelo.Jogador;
import modelo.Territorio;
import visao.InterfacePrincipal;

/**
 *
 * @author Igor
 */
public class WarGame {
    public static Territorio alasca = new Territorio("Alasca", Continente.AMERICA_DO_NORTE);
    public static Territorio chile = new Territorio("Chile", Continente.AMERICA_DO_SUL);
    public static Territorio argentina = new Territorio("Argentina", Continente.AMERICA_DO_SUL);
    public static Territorio vancouver = new Territorio("Vancouver", Continente.AMERICA_DO_NORTE);
    public static Territorio california = new Territorio("Califórnia", Continente.AMERICA_DO_NORTE);
    public static Territorio mexico = new Territorio("México", Continente.AMERICA_DO_NORTE);
    public static Territorio colombia = new Territorio("Colômbia", Continente.AMERICA_DO_SUL);
    public static Territorio brasil = new Territorio("Brasil", Continente.AMERICA_DO_SUL);
    public static Territorio groelandia = new Territorio("Groelândia", Continente.AMERICA_DO_NORTE);
    public static Territorio otawa = new Territorio("Otawa", Continente.AMERICA_DO_NORTE);
    public static Territorio novaYork = new Territorio("Nova York", Continente.AMERICA_DO_NORTE);
    public static Territorio inglaterra = new Territorio("Inglaterra", Continente.EUROPA);
    public static Territorio nigeria = new Territorio("Nigéria", Continente.AFRICA);
    public static Territorio congo = new Territorio("Congo", Continente.AFRICA);
    public static Territorio africaDoSul = new Territorio("África do Sul", Continente.AFRICA);
    public static Territorio italia = new Territorio("Itália", Continente.EUROPA);
    public static Territorio alemanha = new Territorio("Alemanha", Continente.EUROPA);
    public static Territorio egito = new Territorio("Egito", Continente.AFRICA);
    public static Territorio sudao = new Territorio("Sudão", Continente.AFRICA);
    public static Territorio madagascar = new Territorio("Madagascar", Continente.AFRICA);
    public static Territorio suecia = new Territorio("Suécia", Continente.EUROPA);
    public static Territorio moscou = new Territorio("Moscou", Continente.EUROPA);
    public static Territorio orienteMedio = new Territorio("Oriente Médio", Continente.ASIA);
    public static Territorio sumatra = new Territorio("Sumatra", Continente.OCEANIA);
    public static Territorio omsk = new Territorio("Omsk", Continente.ASIA);
    public static Territorio india = new Territorio("Índia", Continente.ASIA);
    public static Territorio borneu = new Territorio("Bornéu", Continente.OCEANIA);
    public static Territorio australia = new Territorio("Austrália", Continente.OCEANIA);
    public static Territorio vladivostok = new Territorio("Vladivostok", Continente.ASIA);
    public static Territorio siberia = new Territorio("Sibéria", Continente.ASIA);
    public static Territorio china = new Territorio("China", Continente.ASIA);
    public static Territorio japao = new Territorio("Japão", Continente.ASIA);
    public static Territorio novaGuine = new Territorio("Nova Guiné", Continente.OCEANIA);
    
    public static Jogador computador = new Jogador(0, "Computador");
    public static Jogador jogador = new Jogador(1);
    
    public static List<Territorio> todosTerritorios = new ArrayList<Territorio>();
    
    public static void main(String[] args) {
        ControleJogo controleJogo = new ControleJogo();
        ControleJogador controleJogador = new ControleJogador();
        InterfacePrincipal interfacePrincipal = new InterfacePrincipal();
        Scanner leitura = new Scanner(System.in);
        int corEscolhida;
        
        interfacePrincipal.titulo();
        jogador.setNome(leitura.next());
        System.out.println("Ok " +jogador.getNome()+ ", agora escolha sua cor: \n(1) Azul.\n(2) Vermelho.");
        corEscolhida = leitura.nextInt();
        
        while(!((corEscolhida == 1) || (corEscolhida == 2))){
            System.out.println("Opção inválida, escolha novamente!");
            corEscolhida = leitura.nextInt();
        }
            
        controleJogador.informaCor(corEscolhida);
        System.out.println("Ok "+jogador.getNome()+", Seus exércitos serão da cor " + jogador.getCor());
        
        controleJogo.inicializacaoJogo();
        controleJogo.distribuiTerritorios();
        
        ClasseTeste teste = new ClasseTeste();
        teste.Teste();
            
    }
    
}
