package controle;

import java.util.List;
import java.util.Scanner;
import modelo.Aereo;
import modelo.Jogador;
import modelo.Terrestre;
import modelo.Territorio;

/**
 *
 * @author Igor
 */
public class ControleExercito {
    private Scanner leitura = new Scanner(System.in);

    public void fortificaExercito(Jogador jogador, double coordTerritorio, int exercitoFortificar){
        int maximoDisponivel, qtdFortificar;
        boolean qtdAceita = false;
        String tipoExercito ;

        if(exercitoFortificar == 1){
            maximoDisponivel = jogador.getExercitosTerrestreDisponiveis();
            tipoExercito = "terrestre";
        }
        else {
            maximoDisponivel = jogador.getExercitosAereoDisponiveis();
            tipoExercito = "aéreo";
        }
        
        while (!(qtdAceita)) {
            System.out.println("Digite a quantidade de exércitos " + tipoExercito + " que deseja adicionar a esse território (Máximo: " + maximoDisponivel + "):");
            qtdFortificar = leitura.nextInt();
            if (qtdFortificar <= maximoDisponivel) {
                this.aumentaExercitos(jogador, coordTerritorio, qtdFortificar, tipoExercito);
                qtdAceita = true;
            } else {
                System.out.println("Quantidade digitada inválida, digite novamente.");
                qtdAceita = false;
            }
}}
    
    
    private void aumentaExercitos(Jogador jogador, double coordTerritorio, int qtdFortificar, String tipoExercito) {
        List<Territorio> territoriosJogador = jogador.getTerritorios();

        for (Territorio territorio : territoriosJogador) {
            if (territorio.getCoordenada() == coordTerritorio) {
                for (int i = 0; i < qtdFortificar; i++) {
                    switch (tipoExercito) {
                        case "terrestre":
                            territorio.getExercitosTerrestre().add(new Terrestre());
                            break;
                        case "aéreo":
                            territorio.getExercitosAereo().add(new Aereo());
                            break;
                    }

                }
            }
        }
        switch (tipoExercito) {
            case "terrestre":
                jogador.setExercitosTerrestreDisponiveis((jogador.getExercitosTerrestreDisponiveis()) - qtdFortificar);
                break;
            case "aéreo":
                jogador.setExercitosAereoDisponiveis((jogador.getExercitosAereoDisponiveis()) - qtdFortificar);
                break;
        }

    }
    
    public void atualizaExercitosDisponiveis(Jogador jogadorAux){
        jogadorAux.setExercitosTerrestreDisponiveis((int)Math.floor((jogadorAux.getTerritorios().size())/2));
        jogadorAux.setExercitosAereoDisponiveis((int)Math.floor((jogadorAux.getTerritorios().size())/3));
    }

}
