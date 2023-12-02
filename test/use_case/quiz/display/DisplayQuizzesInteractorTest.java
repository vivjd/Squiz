package use_case.quiz.display;

import entity.Quiz;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.quiz.QuizDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class DisplayQuizzesInteractorTest {
    private QuizDataAccessInterface quizDataAccessObject;
    private DisplayQuizzesOutputBoundary quizPresenter;
    private DisplayQuizzesInteractor displayQuizzesInteractor;

    @BeforeEach
    public void setUp() {
        quizDataAccessObject = mock(QuizDataAccessInterface.class);
        quizPresenter = mock(DisplayQuizzesOutputBoundary.class);
        displayQuizzesInteractor = new DisplayQuizzesInteractor(quizDataAccessObject, quizPresenter);
    }

    @Test
    public void testExecuteWithQuizzes() {
        // Mocking the data access object to return a list of quizzes
        List<Quiz> mockQuizzes = new ArrayList<>();
        Quiz mockQuiz = new Quiz();
        mockQuiz.setTitle("Quiz 1");
        mockQuiz.setQuizLength(3);
        mockQuiz.setCreationTime("2023/12/20");
        mockQuizzes.add(mockQuiz);
        when(quizDataAccessObject.getAllQuizzes()).thenReturn(mockQuizzes);

        // Mocking the getAllQuizzesTable and getAllIds methods
        String[][] mockOutputTableData = {{"Quiz 1", "3", "2023/12/20"}};
        ObjectId[] mockIds = {new ObjectId("656583e8d05ae3b112ed77c1")};
        when(quizDataAccessObject.getAllQuizzesTable()).thenReturn(mockOutputTableData);
        when(quizDataAccessObject.getAllIds()).thenReturn(mockIds);

        displayQuizzesInteractor.execute();
        verify(quizPresenter).prepareSuccessView(any(DisplayQuizzesOutputData.class));
    }

    @Test
    public void testExecuteWithNoQuizzes() {
        when(quizDataAccessObject.getAllQuizzes()).thenReturn(new ArrayList<>());

        displayQuizzesInteractor.execute();

        verify(quizPresenter).prepareFailView(eq("There are no saved quizzes to display. Please create a quiz first."));
    }
}
