package Unit;

import org.junit.Assert;
import org.junit.Test;
import services.WordValidationService;

public class WordValidationServiceTest {

    private WordValidationService wordValidationService;

    public WordValidationServiceTest() {
        wordValidationService = new WordValidationService();
    }

    @Test
    public void stringWithLengthOfFiveShouldReturnTrue() {
        String string = "aaaaa";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertTrue(result);
    }

    @Test
    public void stringWithLengthOfSevenShouldReturnTrue() {
        String string = "aaaaaaa";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertTrue(result);
    }

    @Test
    public void stringWithLengthOfFourShouldReturnFalse() {
        String string = "aaaa";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertFalse(result);
    }

    @Test
    public void stringWithLengthOfEightShouldReturnFalse() {
        String string = "aaaaaaaa";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertFalse(result);
    }

    @Test
    public void stringThatContainsNumberShouldReturnFalse() {
        String string = "aaaa1";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertFalse(result);
    }

    @Test
    public void stringThatContainsSpecialCharacterShouldReturnFalse() {
        String string = "aaaa,";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertFalse(result);
    }

    @Test
    public void stringThatContainsCapitalLetterShouldReturnFalse() {
        String string = "aaaaA";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertFalse(result);
    }

    @Test
    public void stringThatContainsValidStringShouldReturnFalse() {
        String string = "AaaaaaA";
        boolean result = wordValidationService.validateWord(string);
        Assert.assertFalse(result);
    }
}
