package Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private final String WORD;
    private static final List<String> STAGES = new ArrayList<>();
    private int hp =6;
    private String currentStateOfWord;
    private List<Character> usedLetters = new ArrayList<>();

    static {
        STAGES.add("""
            +---+
            |   |
            |   O
            |  /|\\
            |  / \\
            |
            ======
            """);

        STAGES.add("""
            +---+
            |   |
            |   O
            |  /|\\
            |  /
            |
            ======
            """);

        STAGES.add("""
            +---+
            |   |
            |   O
            |  /|\\
            |
            |
            ======
            """);

        STAGES.add("""
            +---+
            |   |
            |   O
            |  /|
            |
            |
            ======
            """);

        STAGES.add("""
            +---+
            |   |
            |   O
            |   |
            |
            |
            ======
            """);

        STAGES.add("""
            +---+
            |   |
            |   O
            |
            |
            |
            ======
            """);


        STAGES.add("""
            +---+
            |   |
            |
            |
            |
            |
            ======
            """);
    }

    public Game(String word) {
        this.WORD = word;
        currentStateOfWord = "_".repeat(WORD.length());
    }

    public void start() throws InterruptedException {

        System.out.println("ПРАВИЛА: слово содежрит русские буквы. всего 6 жизней.");
        Scanner sc = new Scanner(System.in);

        while (hp != 0 && !WORD.equals(currentStateOfWord)) {
            System.out.println("Введите русскую букву!");

            String input = sc.next().toLowerCase();
            if (input.length()!=1){
                System.out.println("Ошибка! Нужно ввести только одну букву.");
                Thread.sleep(1000);
                continue;
            }
            char letter = input.charAt(0);


            if (!((letter >= 'А' && letter <= 'Я') || letter == 'Ё' ||
                    (letter >= 'а' && letter <= 'я') || letter == 'ё')) {
                System.out.println("Это не русская буква.");
                Thread.sleep(1000);
                continue;
            }
            if (usedLetters.contains(letter)){
                System.out.println("Эта буква уже была!");
                Thread.sleep(1000);
                continue;
            }
            if (!usedLetters.contains(letter)){
                usedLetters.add(letter);
            }
            if (WORD.indexOf(letter) != -1) {
                char[] currentChars = currentStateOfWord.toCharArray();
                char[] wordChars = WORD.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    if (wordChars[i] == letter) {
                        currentChars[i] = letter;
                    }
                }
                currentStateOfWord = new String(currentChars);
            } else {
                hp -= 1;
                if (hp == 0) {
                    System.out.println("ВЫ ПРОИГРАЛИ");
                    System.out.println("Слово - " + WORD);
                    return;
                }
            }

            if (currentStateOfWord.equals(WORD)) {
                System.out.println("ВЫ ВЫИГРАЛИ!");
                System.out.println("Слово - " + WORD);
                return;
            }

            System.out.println(currentStateOfWord + " Осталось жизней: " + hp);
            System.out.print("Использованные буквы: ");
            for(var v: usedLetters){
                System.out.print(v + " ");
            }
            System.out.println();
            System.out.println(STAGES.get(hp));
        }
    }
}
