import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainJogoTest {

    private MainJogo mainJogo;

    @Test
    public void deveGerarNaveEmPosicaoAleatoria() {

    }

    @Test
    public void deveGerarMensagemDeNovaFaseTest() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        final int numeroFase = 0;
        MainJogo.mensagemNovaFase(numeroFase);
        Assert.assertNotNull(outContent);
    }
}
