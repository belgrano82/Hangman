import java.io.FileNotFoundException;
import java.util.*;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        Words word = new Words();
        Definitions wordDefinition = new Definitions();
        DrawHangman drawHangman = new DrawHangman();
        Scanner scanner = new Scanner(System.in);


        int wins = 0;
        int loses = 0;

        System.out.println("""
                **********************************************
                *    Добро пожаловать в игру \"Виселица\"!   *
                **********************************************
                 """);

        while (true) {
            System.out.println("\nЕсли хотите начать новую игру, нажмите - 1, если хотите выйти, нажмите - 0");

            int chooseNumber = scanner.nextInt();

            String charsRandomWord = word.getWordRandom();
            char[] wordInChars = charsRandomWord.toCharArray();
            ArrayList<Character> letters = new ArrayList<>();
            ArrayList<Character> mismatchedLetters = new ArrayList<>();
            int mistakes = 0;

            if (chooseNumber == 1) {

                char[] charsInAsterisks = word.wordInAsterisks(wordInChars);

                System.out.println(charsInAsterisks);

                while (true) {
                    System.out.println("Ведите букву:");
                    char letter = word.getLetter();
                    int appearanceOfLetter = charsRandomWord.indexOf(letter);

                    letters.add(letter);
                    for (char letter1 : letters) {
                        for (int i = 0; i < charsRandomWord.length(); i++) {
                            if (charsRandomWord.toCharArray()[i] == letter1) {
                                charsInAsterisks[i] = letter1;
                            }
                        }
                    }

                    if (appearanceOfLetter == -1) {
                        if (!mismatchedLetters.contains(letter)) {
                            mismatchedLetters.add(letter);
                            mistakes++;
                        } else {
                            System.out.println("Вы уже использовали эту букву.");
                        }
                    }

                    System.out.println(charsInAsterisks);

                    System.out.println("Ошибки " + "(" + mistakes + ") " + mismatchedLetters);

                    drawHangman.drawHangman(mistakes);

                    String guessWord = new String(charsInAsterisks);

                   if (mistakes == 6 || !guessWord.contains("*")) {
                       if (mistakes == 6) {
                           loses++;
                           System.out.println("Вы проиграли... " +
                                   "Это было слово: " + charsRandomWord.toUpperCase() + ".");
                       } else if (!guessWord.contains("*")) {
                           wins++;
                           System.out.println("Уррра! Вы отгадали слово " + charsRandomWord.toUpperCase() + "!\n");

                       }
                       System.out.println("ПОБЕДЫ: " + wins + " / " + "ПОРАЖЕНИЯ: " + loses + "\n");
                       System.out.println("Хотите узнать значение слова? (да/нет)");
                       if (Objects.equals(scanner.next(), "да")) {
                           System.out.println("ЗНАЧЕНИЕ:");
                           System.out.println(wordDefinition.findDefenition(charsRandomWord));
                           break;
                       } else if (Objects.equals(scanner.next(), "нет")){
                           break;
                       }
                   }


                }
            } else if (chooseNumber == 0) {
                System.out.println("До новых встреч в игре \"Виселица\"!");
                break;
            }

        }
    }
}
