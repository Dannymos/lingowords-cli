package Main;

import model.Word;
import services.FileReadingService;
import services.WordSubmissionService;
import services.WordValidationService;

import java.util.ArrayList;

public class Main {

    private static String filePath;

    public static void main(String[] args) {
        if(args.length == 0) {
            filePath = "src/main/resources/woordenlijst.txt";
        } else {
            filePath = args[0];
        }

        WordSubmissionService wordSubmissionService = new WordSubmissionService();
        WordValidationService wordValidationService = new WordValidationService();
        FileReadingService fileReadingService = new FileReadingService(wordValidationService);

        try {
            ArrayList<Word> wordList = fileReadingService.readFile(filePath);
            System.out.println("Submitting words...");
            for(Word word: wordList) {
                wordSubmissionService.submitWord(word);
            }
            System.out.println("Done!");
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}
