package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class Jogador {
    private String nome;
    private int id;
    private int exercitosDisponiveis;
    private Cor cor;
    
    private List territorios;
    
    public Jogador(int id){
        this.id = id;
        this.territorios = new ArrayList <Territorio>();
    }
    public Jogador(int id, String nome){
        this.id = id;
        this.nome = nome;
        this.territorios = new ArrayList <Territorio>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExercitosDisponiveis() {
        return exercitosDisponiveis;
    }

    public void setExercitosDisponiveis(int exercitosDisponiveis) {
        this.exercitosDisponiveis = exercitosDisponiveis;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public List getTerritorios() {
        return territorios;
    }

    public void setTerritorios(List territorios) {
        this.territorios = territorios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
