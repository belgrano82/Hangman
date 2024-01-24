import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Words {
    String word;
//    Scanner scanner = new Scanner(new File("C:\\Users\\belgrano\\IdeaProjects\\Project 1_Hangman\\src\\russian_nouns.txt"));
    Scanner scanner = new Scanner(new File("P:\\Projects\\Java\\src\\russian_nouns.txt"));
    Random randomWord = new Random();
    List<String> words = new ArrayList<>();
    Scanner scannerForLetter = new Scanner(System.in);


    public Words() throws FileNotFoundException {

        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            if (word.length() > 4) {
                words.add(word);
            }
        }
    }

    public String getWordRandom() {
        return words.get(randomWord.nextInt(words.size()));
    }

    public char[] wordInAsterisks(char[] chars) {

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '-') {
                chars[i] = '*';
            }
        }
        return chars;
    }

    public char getLetter() {
        return scannerForLetter.next().charAt(0);
    }

}
