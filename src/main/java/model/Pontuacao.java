package model;

public class Pontuacao {
    private int pontos;
    private GameEngine gameEngine;

    public Pontuacao(int pontos, GameEngine gameEngine) {
        this.pontos = pontos;
        this.gameEngine = gameEngine;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
}
