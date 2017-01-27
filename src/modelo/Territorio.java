package modelo;

import java.util.List;

/**
 *
 * @author Igor
 */
public class Territorio {
    private String nome;
    private String cor;
    
    private List<Territorio> fronteiras;
    
    private List<Terrestre> exercitosTerrestres;
    private List<Aereo> exercitoAereo;
    
    private Continente continente;
    
    public Territorio (){
    }
    
    public Territorio(String nome, Continente continente){
        this.nome = nome;
        this.continente = continente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public List<Territorio> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(List<Territorio> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public List<Terrestre> getExercitosTerrestres() {
        return exercitosTerrestres;
    }

    public void setExercitosTerrestres(List<Terrestre> exercitosTerrestres) {
        this.exercitosTerrestres = exercitosTerrestres;
    }

    public List<Aereo> getExercitoAereo() {
        return exercitoAereo;
    }

    public void setExercitoAereo(List<Aereo> exercitoAereo) {
        this.exercitoAereo = exercitoAereo;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }
}
