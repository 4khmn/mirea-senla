

package Task1;

import java.util.List;
import java.util.Random;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        List<String> arr = List.of("пакет", "инкапсуляция", "программирование", "монитор", "анализ", "сервер");
        Random random = new Random();
        String word = (String)arr.get(random.nextInt(5)).toLowerCase();
        Game game = new Game(word);
        game.start();
    }
}
