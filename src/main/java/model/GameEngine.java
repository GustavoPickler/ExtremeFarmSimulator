package model;

public class GameEngine {

    public void atualizaEstado() {

    }

    public void desenhaTela() {

    }

    public void atualizaTela() {

    }

    public static class Fase {
        public int fase;
        public int quantidadeVacas = 5;

        public void proximaFase(int numeroFase) {
            diminuiQtdVacaPassaFase2(numeroFase);
            diminuiQtdVacaPassaFase3(numeroFase);
        }

        private void diminuiQtdVacaPassaFase3(int numeroFase) {
            if (numeroFase == 3) {
                quantidadeVacas = 3;
            }
        }

        private void diminuiQtdVacaPassaFase2(int numeroFase) {
            if (numeroFase == 2) {
                quantidadeVacas = 2;
            }
        }
    }

    static class GeradorDeSprite {
        private final int FAZENDEIRO = 0;
        private final int VACA = 1;
        private final int NAVE = 2;
        private final int MISSIL = 3;

        public void newSprite(int tipo) {

        }
    }
}
