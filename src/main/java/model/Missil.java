package model;

public class Missil {
    private int velocidade;
    private int dano;
    private int municao;

    public Missil(int municao) {
        this.municao = municao;
    }

    public Missil(int velocidade, int dano) {
        this.velocidade = velocidade;
        this.dano = dano;
    }

    public void move() {

    }

    public Missil(int velocidade, int dano, int municao) {
        this.velocidade = velocidade;
        this.dano = dano;
        this.municao = municao;
    }

    public int getMunicao() {
        return municao;
    }

    public void setMunicao(int municao) {
        this.municao = municao;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

}
