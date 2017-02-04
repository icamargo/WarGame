package controle;

import java.util.ArrayList;
import java.util.List;
import modelo.Aereo;
import modelo.Cor;
import modelo.Jogador;
import modelo.Terrestre;
import modelo.Territorio;
import static wargame.WarGame.computador;
import static wargame.WarGame.jogador;

/**
 *
 * @author Igor
 */
public class ControleJogador {
    
    public int comparaQtdTerritorios(){
        int diferenca = Math.abs(jogador.getTerritorios().size() - computador.getTerritorios().size());
        return diferenca;
    }
    
    public Jogador menorQtdTerritorios(){
        int menor = jogador.getTerritorios().size();
        if(menor < computador.getTerritorios().size()){
            return jogador;
        }
        else{
            return computador;
        }
            
    }
    
    public void informaCor(int escolhaJogador){//(1) Azul (2) Vermelho.
        if(escolhaJogador == 1){
            jogador.setCor(Cor.AZUL);
            computador.setCor(Cor.VERMELHO);
        }
        else{
            jogador.setCor(Cor.VERMELHO);
            computador.setCor(Cor.AZUL);
        }
    }
    
    public void atualizaJogador(int jogadorSorteado, Territorio territorio) {
        switch (jogadorSorteado) {// 0 = Computador - 1 = Jogador
            case 0:
                territorio.setCor(computador.getCor());
                territorio.getExercitosAereo().add(new Aereo());
                territorio.getExercitosTerrestre().add(new Terrestre());
                computador.getTerritorios().add(territorio);
                break;
            case 1:
                territorio.setCor(jogador.getCor());
                territorio.getExercitosAereo().add(new Aereo());
                territorio.getExercitosTerrestre().add(new Terrestre());
                jogador.getTerritorios().add(territorio);
                break;
        }
    }
    
    public void listaTerritoriosJogador(Jogador jogador){
        List<Territorio> territoriosJogador = jogador.getTerritorios();
        
        System.out.println(jogador.getNome()+", você possui os seguintes territórios: \n");
        for (Territorio territorio : territoriosJogador){
            System.out.println(territorio.getNome()+", que posui " + territorio.getExercitosTerrestre().size()+" exércitos terrestre e "+ territorio.getExercitosAereo().size() + " exércitos aéreo.");
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

    
}
