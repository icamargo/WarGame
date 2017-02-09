package controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Aereo;
import modelo.Cor;
import modelo.Jogador;
import modelo.Terrestre;
import modelo.Territorio;
import static wargame.WarGame.jogador1;
import static wargame.WarGame.jogador2;

/**
 *
 * @author Igor
 */
public class ControleJogador {
    
    public void inicializaJogadores(){
        Scanner leitura = new Scanner(System.in);
        int corEscolhida;
        
        System.out.println("Jogador 1, por favor, digite seu nome:");
        jogador1.setNome(leitura.next());
        System.out.println("\nOk " +jogador1.getNome()+ ", agora escolha sua cor: \n(1) Azul.\n(2) Vermelho.");
        corEscolhida = leitura.nextInt();
        
        while(!((corEscolhida == 1) || (corEscolhida == 2))){
            System.out.println("Opção inválida, escolha novamente!");
            corEscolhida = leitura.nextInt();
        }
            
        this.informaCor(corEscolhida);
        System.out.println("\nOk "+jogador1.getNome()+", Seus exércitos serão da cor " + jogador1.getCor() + ".");
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        leitura.nextLine();
        
        System.out.println("Jogador 2, por favor digite seu nome: ");
        jogador2.setNome(leitura.next());
        System.out.println("\nOk " +jogador2.getNome()+ ", sua cor é " +jogador2.getCor()+ " e essa será a cor de seus exércitos.\n");
        System.out.println("Tecle enter para continuar...");
        leitura.nextLine();
        leitura.nextLine();
    }
    
    public int comparaQtdTerritorios(){
        int diferenca = Math.abs(jogador2.getTerritorios().size() - jogador1.getTerritorios().size());
        return diferenca;
    }
    
    public Jogador menorQtdTerritorios(){
        int menor = jogador2.getTerritorios().size();
        if(menor < jogador1.getTerritorios().size()){
            return jogador2;
        }
        else{
            return jogador1;
        }
            
    }
    
    public void informaCor(int escolhaJogador){//(1) Azul (2) Vermelho.
        if(escolhaJogador == 1){
            jogador1.setCor(Cor.AZUL);
            jogador2.setCor(Cor.VERMELHO);
        }
        else{
            jogador1.setCor(Cor.VERMELHO);
            jogador2.setCor(Cor.AZUL);
        }
    }
    
    public void atualizaJogador(int jogadorSorteado, Territorio territorio) {
        switch (jogadorSorteado) {// 1 = Jogador1 - 2 = Jogador 2
            case 1:
                territorio.setCor(jogador1.getCor());
                territorio.getExercitosAereo().add(new Aereo());
                territorio.getExercitosTerrestre().add(new Terrestre());
                jogador1.getTerritorios().add(territorio);
                break;
            case 2:
                territorio.setCor(jogador2.getCor());
                territorio.getExercitosAereo().add(new Aereo());
                territorio.getExercitosTerrestre().add(new Terrestre());
                jogador2.getTerritorios().add(territorio);
                break;
        }
    }
    
    public void listaTerritoriosJogador(Jogador jogador){
        List<Territorio> territoriosJogador = jogador.getTerritorios();
        
        System.out.println(jogador.getNome()+", você possui os seguintes territórios: \n");
        for (Territorio territorio : territoriosJogador){
            System.out.println(territorio.getNome()+", que possui " + territorio.getExercitosTerrestre().size()+" exércitos terrestre e "+ territorio.getExercitosAereo().size() + " exércitos aéreo.");
        }
        System.out.println();
    }
    
    public boolean verificaTerritorioJogador(Jogador jogador, double coordTerritorio){
        boolean pertence = true;
        List<Territorio> territoriosJogador = jogador.getTerritorios();
        
        for(Territorio territorio : territoriosJogador){
            if(territorio.getCoordenada() == coordTerritorio){
                pertence = true;
                break;
            }
            else {
                pertence = false;
            }
        }
        
        return pertence;
    }
    
    public boolean verificaExercitoDisponivel(Jogador jogador){
        if((jogador.getExercitosTerrestreDisponiveis() != 0) || (jogador.getExercitosAereoDisponiveis() != 0)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void listaTerritoriosAdversario(Jogador jogador){
        Jogador adversario = null;
        List<Territorio> territoriosAdversario = null;
        
        if(jogador.getId() == 1){//adversário é o jogador2
            adversario = jogador2;
        }
        else{//adversário é o jogador1
            adversario = jogador1;
        }
        territoriosAdversario = adversario.getTerritorios();
        
        System.out.println("Seu adversário, "+adversario.getNome()+", possui os seguintes territórios: \n");
        for (Territorio territorio : territoriosAdversario){
            System.out.println(territorio.getNome()+", que possui " + territorio.getExercitosTerrestre().size()+" exércitos terrestre e "+ territorio.getExercitosAereo().size() + " exércitos aéreo.");
        }
        System.out.println();
    }
}
