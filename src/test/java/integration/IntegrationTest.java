package integration;

import Main.Main;

import org.junit.Test;
import org.mockito.Mock;
import services.WordSubmissionService;

import static org.mockito.Mockito.mock;

public class IntegrationTest {

    @Mock
    private WordSubmissionService wordValidationServiceMock = mock(WordSubmissionService.class);

    @Test
    public void shouldReadAndSubmitTxtFile() {
        String[] args = new String[] {"src/test/java/resources/testFileWithValidWord.txt"};
        Main.main(args);
    }
}
