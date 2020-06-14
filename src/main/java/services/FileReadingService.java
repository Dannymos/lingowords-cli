package services;

import model.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadingService {

    private WordValidationService wordValidationService;

    public FileReadingService(WordValidationService wordValidationService) {
        this.wordValidationService = wordValidationService;
    }

    public ArrayList<Word> readFile(String filePath) {
        ArrayList<Word> validWords = new ArrayList<>();
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String text = myReader.nextLine();
                if(wordValidationService.validateWord(text)) {
                    Word word = new Word(text);
                    validWords.add(word);
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
