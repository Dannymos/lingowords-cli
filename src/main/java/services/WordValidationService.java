package services;

public class WordValidationService {

    public boolean validateWord(String word) {
        return word.matches("^[a-z]{5,7}$");
    }
}
