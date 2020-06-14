import services.FileReadingService;
import services.WordValidationService;

import java.util.ArrayList;

public class Main {

    private FileReadingService fileReadingService;

    private static String filePath = "src/main/resources/test.txt";

    private static String languageSlug = "NL";

    public static void main(String[] args) {
        WordValidationService wordValidationService = new WordValidationService();
        FileReadingService fileReadingService = new FileReadingService(wordValidationService);
        try {
            System.out.println("Trying to read file: " + filePath);
            ArrayList<String> wordList = fileReadingService.readFile(filePath);
        } catch(Exception exception) {
            System.out.println("An error occured!");
            exception.printStackTrace();
        }
    }
}
