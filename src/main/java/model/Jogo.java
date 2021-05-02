package model;

public class Jogo {
    final private int QUANTIDADE_PASSOS_ANDANDO = 1;
    final private int QUANTIDADE_PASSOS_CORRENDO = 2;

    public int correEsq(Fazendeiro fazendeiro) {
        fazendeiro.setPosicao(new Coordenada(fazendeiro.getPosicao().getX() - QUANTIDADE_PASSOS_CORRENDO));
        return fazendeiro.getEnergia() - 5;
    }

    public int correDir(Fazendeiro fazendeiro) {
        fazendeiro.setPosicao(new Coordenada(fazendeiro.getPosicao().getX() + QUANTIDADE_PASSOS_CORRENDO));
        return fazendeiro.getEnergia() - 10;
    }

    public int moveEsq(Fazendeiro fazendeiro) {
        fazendeiro.setPosicao(new Coordenada(fazendeiro.getPosicao().getX() - QUANTIDADE_PASSOS_ANDANDO));
        return fazendeiro.getEnergia() - 5;
    }

    public int moveDir(Fazendeiro fazendeiro) {
        fazendeiro.setPosicao(new Coordenada(fazendeiro.getPosicao().getX() + QUANTIDADE_PASSOS_ANDANDO));
        return fazendeiro.getEnergia() - 10;
    }

    public void atirar() {
        System.out.println("POOW!");
    }

}
