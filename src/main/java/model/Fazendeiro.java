package model;

public class Fazendeiro extends Personagem {

    private Missil missil;

    public Fazendeiro() {
    }

    public Fazendeiro(Missil missil) {
        this.missil = missil;
    }

    public Fazendeiro(int energia, Missil missil) {
        super(energia);
        this.missil = missil;
    }

    public Fazendeiro(int energia, Coordenada posicao, GameEngine gameEngine, Missil missil) {
        super(energia, posicao, gameEngine);
        this.missil = missil;
    }

    public Fazendeiro(int energia) {
        super(energia);
    }

    public Fazendeiro(int energia, Coordenada posicao, GameEngine gameEngine) {
        super(energia, posicao, gameEngine);
    }

    public void move() {
        mostraMensagemPersonagemAndando();
        mostraMensagemCoordenadaAtualPersonagem();
    }

    private void mostraMensagemCoordenadaAtualPersonagem() {
        System.out.println("Sua coordenada atual é: " + getPosicao().getX());
    }

    private void mostraMensagemPersonagemAndando() {
        System.out.println("~Andando~");
    }

    public void correr() {
        mostraMensagemPersonagemCorrendo();
        mostraMensagemCoordenadaAtualPersonagem();
    }

    private void mostraMensagemPersonagemCorrendo() {
        System.out.println("~Correndo~");
    }

    public Missil getMissil() {
        return missil;
    }

    public void setMissil(Missil missil) {
        this.missil = missil;
    }
}
