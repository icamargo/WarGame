package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Igor
 */
public class Territorio {
    private String nome;
    private Cor cor;
    
    private List<Territorio> fronteiras;
    
    private List<Terrestre> exercitosTerrestre;
    private List<Aereo> exercitosAereo;
    
    private Continente continente;
    
    private double coordenada;//ij onde i=linha j=coluna Exemplo: 11 significa linha 1 coluna 1 - 21 significa linha 2 coluna 1
    
    public Territorio (){
    }
    
    public Territorio(String nome, Continente continente, double coordenada){
        this.nome = nome;
        this.continente = continente;
        this.exercitosAereo = new ArrayList<>();
        this.exercitosTerrestre = new ArrayList<>();
        this.coordenada = coordenada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Territorio> getFronteiras() {
        return fronteiras;
    }

    public void setFronteiras(List<Territorio> fronteiras) {
        this.fronteiras = fronteiras;
    }

    public List<Terrestre> getExercitosTerrestre() {
        return exercitosTerrestre;
    }

    public void setExercitosTerrestre(List<Terrestre> exercitosTerrestre) {
        this.exercitosTerrestre = exercitosTerrestre;
    }

    public List<Aereo> getExercitosAereo() {
        return exercitosAereo;
    }

    public void setExercitosAereo(List<Aereo> exercitosAereo) {
        this.exercitosAereo = exercitosAereo;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public double getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(double coordenada) {
        this.coordenada = coordenada;
    }
}
