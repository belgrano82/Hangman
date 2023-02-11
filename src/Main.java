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
                *    ����� ���������� � ���� \"��������\"!   *
                **********************************************
                 """);

        while (true) {
            System.out.println("\n���� ������ ������ ����� ����, ������� - 1, ���� ������ �����, ������� - 0");

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
                    System.out.println("������ �����:");
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
                            System.out.println("�� ��� ������������ ��� �����.");
                        }
                    }

                    System.out.println(charsInAsterisks);

                    System.out.println("������ " + "(" + mistakes + ") " + mismatchedLetters);

                    drawHangman.drawHangman(mistakes);

                    String guessWord = new String(charsInAsterisks);

                   if (mistakes == 6 || !guessWord.contains("*")) {
                       if (mistakes == 6) {
                           loses++;
                           System.out.println("�� ���������... " +
                                   "��� ���� �����: " + charsRandomWord.toUpperCase() + ".");
                       } else if (!guessWord.contains("*")) {
                           wins++;
                           System.out.println("�����! �� �������� ����� " + charsRandomWord.toUpperCase() + "!\n");

                       }
                       System.out.println("������: " + wins + " / " + "���������: " + loses + "\n");
                       System.out.println("������ ������ �������� �����? (��/���)");
                       if (Objects.equals(scanner.next(), "��")) {
                           System.out.println("��������:");
                           System.out.println(wordDefinition.findDefenition(charsRandomWord));
                           break;
                       } else if (Objects.equals(scanner.next(), "���")){
                           break;
                       }
                   }


                }
            } else if (chooseNumber == 0) {
                System.out.println("�� ����� ������ � ���� \"��������\"!");
                break;
            }

        }
    }
}
