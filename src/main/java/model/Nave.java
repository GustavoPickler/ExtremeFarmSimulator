package model;

public class Nave extends Personagem {

    public Nave() {
    }

    public Nave(int energia) {
        super(energia);
    }

    public Nave(Coordenada posicao, GameEngine gameEngine) {
        super(posicao, gameEngine);
    }


    public void move() {
        System.out.println("~Voando~");
    }

}
