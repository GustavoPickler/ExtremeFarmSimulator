import java.util.Random;

public class Utils {
    static int geraCoordenadaXAleatoria(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}
