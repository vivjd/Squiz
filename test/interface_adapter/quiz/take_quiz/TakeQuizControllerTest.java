package interface_adapter.quiz.take_quiz;

import org.junit.Before;
import org.junit.Test;
import use_case.quiz.take_quiz.TakeQuizInputBoundary;
import use_case.quiz.take_quiz.TakeQuizInputData;

import static org.mockito.Mockito.*;

public class TakeQuizControllerTest {

    private TakeQuizInputBoundary takeQuizInteractor;
    private TakeQuizController takeQuizController;

    @Before
    public void setUp() {
        takeQuizInteractor = mock(TakeQuizInputBoundary.class);
        takeQuizController = new TakeQuizController(takeQuizInteractor);
    }

    @Test
    public void execute_ShouldCallInteractorExecute() {
        String quizTitle = "Test Quiz";

        takeQuizController.execute(quizTitle);

        verify(takeQuizInteractor).execute(any(TakeQuizInputData.class));
    }

    @Test
    public void start_ShouldCallInteractorStart() {
        String quizTitle = "Test Quiz";

        takeQuizController.start(quizTitle);

        verify(takeQuizInteractor).start(any(TakeQuizInputData.class));
    }

    @Test
    public void nextQuestion_ShouldCallInteractorNext() {
        takeQuizController.nextQuestion();

        verify(takeQuizInteractor).next();
    }
}
