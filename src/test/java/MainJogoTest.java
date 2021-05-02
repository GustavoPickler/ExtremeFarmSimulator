import junit.framework.TestCase;
import model.Coordenada;
import model.Nave;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainJogoTest {

    @Test
    public void deveGerarNaveEmPosicaoAleatoria() {
        final int coordenadaX = 6;
        Nave nave = new Nave();
        nave.setPosicao(new Coordenada(coordenadaX));
        MainJogo.geraNovaNaveEmPosicaoAleatoria(nave);
        Assert.assertNotEquals(coordenadaX, nave.getPosicao().getX());
    }

    @Test
    public void deveGerarMensagemDeNovaFaseTest() {
        ByteArrayOutputStream conteudoSystemOutPrint = new ByteArrayOutputStream();
        System.setOut(new PrintStream(conteudoSystemOutPrint));
        final int numeroFase = 0;
        final String valorInesperado = "";
        MainJogo.mensagemNovaFase(numeroFase);
        Assert.assertNotEquals(valorInesperado, conteudoSystemOutPrint.toString());
    }
}
