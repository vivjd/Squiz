package interface_adapter.quiz.display;

import org.junit.jupiter.api.Test;
import use_case.quiz.display.DisplayQuizzesInputBoundary;

import static org.mockito.Mockito.*;

public class DisplayQuizzesControllerTest {
    @Test
    public void testExecute() {
        DisplayQuizzesInputBoundary displayQuizUseCaseInteractor = mock(DisplayQuizzesInputBoundary.class);

        DisplayQuizzesController displayQuizzesController = new DisplayQuizzesController(displayQuizUseCaseInteractor);

        displayQuizzesController.execute();

        verify(displayQuizUseCaseInteractor).execute();
    }
}
