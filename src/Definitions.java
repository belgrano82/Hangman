import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Definitions {
    String word;
    String wordRandom;
    Scanner scanner = new Scanner(new File("C:\\Users\\belgrano\\IdeaProjects\\Project 1_Hangman\\src\\russian_nouns_with_definition.txt"));
    Random randomWord = new Random();
    List<String> words = new ArrayList<>();
    Scanner scannerForLetter = new Scanner(System.in);
    char letter;

    public Definitions() throws FileNotFoundException {
        while (scanner.hasNextLine()) {

            words.add(scanner.nextLine());
        }
    }

    public String findDefenition(String charsRandomWord) {

        for (String line : words) {
            String[] defenition = line.split(":");
            if (defenition[0].equals(charsRandomWord)) {
return line;
            }

        }
        return null;
    }


}
