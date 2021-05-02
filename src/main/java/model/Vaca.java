package model;

public class Vaca extends Personagem {

    public Vaca() {
    }

    public Vaca(Coordenada posicao, GameEngine gameEngine) {
        super(posicao, gameEngine);
    }

    public void move() {

        mostraMensagemVacaAndando();
    }

    private void mostraMensagemVacaAndando() {
        System.out.println("~andando~ MUUUUUUUU");
    }


}
