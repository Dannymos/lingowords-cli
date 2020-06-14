package Unit;

import model.Word;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import services.FileReadingService;
import services.WordValidationService;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FileReadingServiceTest {

    @Mock
    private WordValidationService wordValidationServiceMock = mock(WordValidationService.class);

    private FileReadingService fileReadingService;

    public FileReadingServiceTest() {
        this.fileReadingService = new FileReadingService(this.wordValidationServiceMock);
    }

    @Test
    public void shouldReturnNullWhenInvalidFilepathIsProvided() {
        ArrayList<Word> result = fileReadingService.readFile("aninvalidpath");
        Assert.assertNull(result);
    }

    @Test
    public void shouldReturnEmptyListWhenEmptyFileIsProvided() {
        ArrayList<Word> result = fileReadingService.readFile("src/test/java/resources/testFileWithoutWords.txt");
        Assert.assertEquals(result.size(), 0);
    }

    @Test
    public void shouldReturnListWhenFileWithValidWordsIsProvided() {
        when(wordValidationServiceMock.validateWord("aaaaa")).thenReturn(true);
        ArrayList<Word> result = fileReadingService.readFile("src/test/java/resources/testFileWithValidWord.txt");
        Assert.assertNotEquals(result.size(), 0);
    }

    @Test
    public void shouldReturnEmptyListWhenFileWithInvalidWordsIsProvided() {
        when(wordValidationServiceMock.validateWord("aaaa")).thenReturn(false);
        ArrayList<Word> result = fileReadingService.readFile("src/test/java/resources/testFileWithValidWord.txt");
        Assert.assertEquals(result.size(), 0);
    }
}
