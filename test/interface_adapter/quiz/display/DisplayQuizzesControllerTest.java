package interface_adapter.quiz.display;

import org.junit.jupiter.api.Test;
import use_case.quiz.display.DisplayQuizzesInputBoundary;

import static org.mockito.Mockito.*;

public class DisplayQuizzesControllerTest {
    @Test
    public void testExecute() {
        // Mock the DisplayQuizzesInputBoundary
        DisplayQuizzesInputBoundary displayQuizUseCaseInteractor = mock(DisplayQuizzesInputBoundary.class);

        // Create DisplayQuizzesController instance with the mocked DisplayQuizzesInputBoundary
        DisplayQuizzesController displayQuizzesController = new DisplayQuizzesController(displayQuizUseCaseInteractor);

        // Execute the controller
        displayQuizzesController.execute();

        // Verify that the execute method of DisplayQuizzesInputBoundary is called
        verify(displayQuizUseCaseInteractor).execute();
    }
}
