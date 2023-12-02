package use_case.quiz.take_quiz;

import entity.Quiz;
import org.junit.Before;
import org.junit.Test;
import use_case.quiz.QuizDataAccessInterface;

import static org.mockito.Mockito.*;


public class TakeQuizInteractorTest {

    private QuizDataAccessInterface quizDataAccessObject;
    private TakeQuizOutputBoundary takeQuizPresenter;
    private TakeQuizInteractor takeQuizInteractor;

    @Before
    public void setUp() {
        quizDataAccessObject = mock(QuizDataAccessInterface.class);
        takeQuizPresenter = mock(TakeQuizOutputBoundary.class);
        takeQuizInteractor = new TakeQuizInteractor(quizDataAccessObject, takeQuizPresenter);
    }

    @Test
    public void start_ShouldPrepareStartSuccessView() {
        String quizTitle = "Test Quiz";
        TakeQuizInputData takeQuizInputData = new TakeQuizInputData(quizTitle);
        Quiz quiz = new Quiz();
        when(quizDataAccessObject.getQuiz(quizTitle)).thenReturn(quiz);

        takeQuizInteractor.start(takeQuizInputData);

        verify(takeQuizPresenter).prepareStartSuccessView(any(TakeQuizOutputData.class));
    }

    @Test
    public void execute_ShouldPrepareExecuteSuccessView() {
        String quizTitle = "Test Quiz";
        TakeQuizInputData takeQuizInputData = new TakeQuizInputData(quizTitle);

        Quiz quiz = new Quiz();
        when(quizDataAccessObject.getQuiz(quizTitle)).thenReturn(quiz);

        takeQuizInteractor.execute(takeQuizInputData);

        verify(takeQuizPresenter).prepareExecuteSuccessView(any(TakeQuizOutputData.class));
    }

    @Test
    public void next_ShouldPrepareNextSuccessView() {
        takeQuizInteractor.next();

        verify(takeQuizPresenter).prepareNextSuccessView(any(TakeQuizOutputData.class));
    }
}
