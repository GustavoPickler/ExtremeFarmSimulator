import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MainJogoTest {

    @Test
    public void deveGerarNaveEmPosicaoAleatoria() {

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
