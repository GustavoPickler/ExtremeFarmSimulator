import model.*;

import java.util.Scanner;

public class MainJogo {
    public static void main(String[] args) {
        GameEngine.Fase fase = new GameEngine.Fase();
        final int PONTUACAO_INICIAL = 0;
        final int ENERGIA_INICIAL = 500;
        final int NUMERO_DE_FASES = 3;

        int pontuacaoMeta = 1000;
        int numeroMisseis = getNumeroMisseis(fase);
        iniciaInstrucoes();
        GameEngine gameEngine = new GameEngine();
        Pontuacao pontuacao = new Pontuacao(PONTUACAO_INICIAL, gameEngine);

        for (int i = 0; i < NUMERO_DE_FASES; i++) {
            Jogo jogo = new Jogo();

            Coordenada coordenadaFazendeiro = new Coordenada(0, 0);
            Missil missil = new Missil(10, 100, numeroMisseis);
            Fazendeiro fazendeiro = new Fazendeiro(ENERGIA_INICIAL, coordenadaFazendeiro, gameEngine, missil);

            Coordenada coordenadaNave = new Coordenada(Utils.geraCoordenadaXAleatoria(-5, 5), 100);
            Nave nave = new Nave(coordenadaNave, gameEngine);

            Coordenada coordenadaVaca = new Coordenada(Utils.geraCoordenadaXAleatoria(-5, 5), 0);
            Vaca vaca = new Vaca(coordenadaVaca, gameEngine);

            while (todasVacasNaoForamAbduzidas(fase) && municaoNaoAcabou(fazendeiro) && naoAlcancouAMetaDePontuacao(pontuacaoMeta, pontuacao)) {

                Scanner sc = new Scanner(System.in);

                if (naveEncontrouVaca(nave, vaca)) {
                    mensagemDeAbudacao();
                    reduzNumeroDeVacas(fase);
                    geraNovaVacaEmPosicaoAleatoria(vaca);
                }

                switch (sc.next()) {
                    case "esq" -> {
                        jogo.moveEsq(fazendeiro);
                        if (fazendeiroEncontrouANave(fazendeiro, nave)) {
                            mensagemAtirarNave();
                            break;
                        }
                        mensagemNaveMaisProxima(nave);
                        fazendeiro.move();
                    }
                    case "correresq" -> {
                        jogo.correEsq(fazendeiro);
                        if (fazendeiroEncontrouANave(fazendeiro, nave)) {
                            mensagemAtirarNave();
                        }
                        mensagemNaveMaisProxima(nave);
                        fazendeiro.correr();
                    }
                    case "dir" -> {
                        jogo.moveDir(fazendeiro);
                        if (fazendeiroEncontrouANave(fazendeiro, nave)) {
                            mensagemAtirarNave();
                        }
                        mensagemNaveMaisProxima(nave);
                        fazendeiro.move();
                    }
                    case "correrdir" -> {
                        jogo.correDir(fazendeiro);
                        if (fazendeiroEncontrouANave(fazendeiro, nave)) {
                            mensagemAtirarNave();
                        }
                        mensagemNaveMaisProxima(nave);
                        fazendeiro.correr();
                    }
                    case "atirar" -> {
                        jogo.atirar();
                        if (fazendeiroEncontrouANave(fazendeiro, nave)) {
                            mensagemDestruiuANave();
                            geraNovaNaveEmPosicaoAleatoria(nave);
                            reduzMunicaoMissil(missil, fazendeiro);
                            acrescentaPontuacao(pontuacao);
                            mensagemMostraPontuacaoAtual(pontuacaoMeta, pontuacao);
                            break;

                        }
                        mensagemNaveEscapou();
                        reduzMunicaoMissil(missil, fazendeiro);
                    }
                    default -> mensagemComandoDesconhecido();
                    case "help" -> iniciaInstrucoes();
                }
            }

            if (naoAlcancouAMetaDePontuacao(pontuacaoMeta, pontuacao)) {
                mensagemDeDerrota();
                return;
            }
            mensagemNovaFase(i);
            fase.proximaFase((i + 2));
            pontuacaoMeta = acrescentaNovaMetaDePontuacao(pontuacaoMeta);
        }
        return;
    }

    private static int getNumeroMisseis(GameEngine.Fase fase) {
        return fase.quantidadeVacas * 3;
    }

    public static void geraNovaNaveEmPosicaoAleatoria(Nave nave) {
        nave.setPosicao(new Coordenada(Utils.geraCoordenadaXAleatoria(-5, 5)));
    }

    public static void mensagemNovaFase(int i) {
        System.out.println("FASE " + (i + 2));
    }

    public static boolean todasVacasNaoForamAbduzidas(GameEngine.Fase fase) {
        return fase.quantidadeVacas != 0;
    }

    public static boolean municaoNaoAcabou(Fazendeiro fazendeiro) {
        return fazendeiro.getMissil().getMunicao() != 0;
    }

    public static boolean naoAlcancouAMetaDePontuacao(int pontuacaoMeta, Pontuacao pontuacao) {
        return pontuacao.getPontos() < pontuacaoMeta;
    }

    public static void mensagemDeDerrota() {
        System.out.println("VOCÊ PERDEU!");
        System.out.println("VITORIA DOS ALIENS");
    }

    public static int acrescentaNovaMetaDePontuacao(int pontuacaoMeta) {
        pontuacaoMeta = pontuacaoMeta + 1000;
        return pontuacaoMeta;
    }

    public static void geraNovaVacaEmPosicaoAleatoria(Vaca vaca) {
        vaca.setPosicao(new Coordenada(Utils.geraCoordenadaXAleatoria(-5, 5)));
    }

    public static void reduzNumeroDeVacas(GameEngine.Fase fase) {
        fase.quantidadeVacas = fase.quantidadeVacas - 1;
    }

    public static boolean naveEncontrouVaca(Nave nave, Vaca vaca) {
        return nave.getPosicao().getX() == vaca.getPosicao().getX();
    }

    public static void mensagemNaveEscapou() {
        System.out.println("A nave escapou!");
    }

    public static void acrescentaPontuacao(Pontuacao pontuacao) {
        pontuacao.setPontos(pontuacao.getPontos() + 200);
    }

    public static void reduzMunicaoMissil(Missil missil, Fazendeiro fazendeiro) {
        fazendeiro.setMissil(new Missil(missil.getMunicao() - 1));
    }

    public static void mensagemComandoDesconhecido() {
        System.out.println("Comando desconhecido, tente novamente, para dúvidas digite: help");
    }

    public static void mensagemMostraPontuacaoAtual(int pontuacaoMeta, Pontuacao pontuacao) {
        System.out.println("Sua pontuação atual é de " + pontuacao.getPontos() + " faltam " + (pontuacaoMeta - pontuacao.getPontos()) + " pontos para a próxima fase!");
    }

    public static void mensagemDestruiuANave() {
        System.out.println("BOOOM!!!");
        System.out.println();
        System.out.println("Você destruiu uma nave!!");
    }

    public static void mensagemNaveMaisProxima(Nave nave) {
        System.out.println("A nave mais proxima se encontra na coordenada: " + nave.getPosicao().getX());
    }

    public static void mensagemAtirarNave() {
        System.out.println("Você encontrou uma nave!! Atire!!!");
    }

    public static boolean fazendeiroEncontrouANave(Fazendeiro fazendeiro, Nave nave) {
        return fazendeiro.getPosicao().getX() == nave.getPosicao().getX();
    }

    public static void mensagemDeAbudacao() {
        System.out.println("~Abduzindo vaca~");
        System.out.println("MUUUUuuh");
    }

    public static void iniciaInstrucoes() {
        System.out.println("Bem vindo ao Extreme Farm Simulator!");
        System.out.println();
        System.out.println("Você se encontra na coordenada: 0");
        System.out.println();
        System.out.println("Para dar um passo a esquerda digite: esq");
        System.out.println("Para dar um passo a direita digite: dir");
        System.out.println("Para correr dois passos à esquerda digite: corre esq");
        System.out.println("Para correr dois passos à direita digite: corre dir");
        System.out.println("Para atirar digite: atirar");
        System.out.println();
        System.out.println("Boa sorte!");
    }
}
