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
    private int exercitosTerrestreDisponiveis;
    private int exercitosAereoDisponiveis;
    private Cor cor;
    private int pontuacao;
    
    private List territorios;
    
    public Jogador(int id){
        this.id = id;
        this.territorios = new ArrayList <Territorio>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExercitosTerrestreDisponiveis() {
        return exercitosTerrestreDisponiveis;
    }

    public void setExercitosTerrestreDisponiveis(int exercitosTerrestreDisponiveis) {
        this.exercitosTerrestreDisponiveis = exercitosTerrestreDisponiveis;
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

    public int getExercitosAereoDisponiveis() {
        return exercitosAereoDisponiveis;
    }

    public void setExercitosAereoDisponiveis(int exercitosAereoDisponiveis) {
        this.exercitosAereoDisponiveis = exercitosAereoDisponiveis;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}
