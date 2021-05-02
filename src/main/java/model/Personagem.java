package model;

public class Personagem {
    private int energia;
    private Coordenada posicao;
    private GameEngine gameEngine;

    public Personagem() {
    }

    public Personagem(int energia) {
        this.energia = energia;
    }

    public Personagem(int energia, Coordenada posicao, GameEngine gameEngine) {
        this.energia = energia;
        this.posicao = posicao;
        this.gameEngine = gameEngine;
    }

    public Personagem(Coordenada posicao, GameEngine gameEngine) {
        this.posicao = posicao;
        this.gameEngine = gameEngine;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public Coordenada getPosicao() {
        return posicao;
    }

    public void setPosicao(Coordenada posicao) {
        this.posicao = posicao;
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
}
