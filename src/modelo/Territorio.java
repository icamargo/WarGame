package modelo;

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
}
