package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadingService {

    private WordValidationService wordValidationService;

    public FileReadingService(WordValidationService wordValidationService) {
        this.wordValidationService = wordValidationService;
    }

    public ArrayList<String> readFile(String filePath) {
        ArrayList<String> validWords = new ArrayList<>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String word = myReader.nextLine();
                System.out.println("Validating word: " + word);
                if(wordValidationService.validateWord(word)) {
                    System.out.println("Word: " + word + " was valid!");
                    validWords.add(word);
                } else {
                    System.out.println("Word: " + word + " was invalid!");
                }
            }
            myReader.close();

            return validWords;
        } catch (FileNotFoundException exception) {
            System.out.println("Could not find file!");

            return null;
        }
    }
}
