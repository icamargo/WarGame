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

    public void fortificaExercito(Jogador jogador, double coordTerritorio, int exercitoFortificar) {
        int maximoDisponivel, qtdFortificar;
        boolean qtdAceita = false;
        String tipoExercito;

        if (exercitoFortificar == 1) {
            maximoDisponivel = jogador.getExercitosTerrestreDisponiveis();
            tipoExercito = "terrestre";
        } else {
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
        }
    }
    
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
        jogadorAux.setExercitosTerrestreDisponiveis(jogadorAux.getExercitosTerrestreDisponiveis() + ((int)Math.floor((jogadorAux.getTerritorios().size())/2)));
        jogadorAux.setExercitosAereoDisponiveis(jogadorAux.getExercitosAereoDisponiveis() + ((int)Math.floor((jogadorAux.getTerritorios().size())/3)));
    }
    
    public int retornaQtdExercitoDefesa(String tipoExercito, Territorio territorioDefesa) {
        int qtdExercitoDefesa = 1;
        int diferenca = 0, qtdExercitoTerritorio = 0;

        switch (tipoExercito) {
            case "Terrestre":
                qtdExercitoTerritorio = territorioDefesa.getExercitosTerrestre().size();
                break;
            case "Aereo":
                qtdExercitoTerritorio = territorioDefesa.getExercitosAereo().size();
                break;
        }
        diferenca = (3 - (qtdExercitoTerritorio));
        if (diferenca >= 0) {
            qtdExercitoDefesa = qtdExercitoTerritorio;
        } else {
            qtdExercitoDefesa = (qtdExercitoTerritorio - (Math.abs(diferenca)));
        }

        return qtdExercitoDefesa;
    }
    
    public void moverExercitoTerritorioConsquistado(String tipoAtaque, Territorio territorioAtacante, Territorio territorioAtacado, int qtdExercitoAtaque) {
        int qtdExercitoMover=0;
        
        System.out.println("Você pode mover no máximo " + qtdExercitoAtaque + " exércitos para o novo território.\nDigite a quantidade que deseja mover:");
        qtdExercitoMover = leitura.nextInt();
        
        while(!(qtdExercitoMover <= qtdExercitoAtaque)){
            System.out.println("Quantidade inválida digitada! Digite novamente.");
            qtdExercitoMover = leitura.nextInt();
        }
        for(int i=0; i<qtdExercitoMover; i++){
            switch(tipoAtaque){
                case "Terrestre":
                    territorioAtacado.getExercitosTerrestre().add(new Terrestre());
                    territorioAtacante.getExercitosTerrestre().remove(0);
                    break;
                case "Aereo":
                    break;
            }
            
        }
        
    }

}
