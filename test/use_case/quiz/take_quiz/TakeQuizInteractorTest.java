package use_case.quiz.take_quiz;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;
import entity.Quiz;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import use_case.quiz.QuizDataAccessInterface;
import use_case.quiz.display_quiz.DisplayQuizOutputData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TakeQuizInteractorTest {

    @Mock
    private QuizDataAccessInterface quizDataAccessObject;
    @Mock
    private TakeQuizOutputBoundary takeQuizPresenter;
    @Mock
    private Quiz quiz;

    private TakeQuizInputBoundary takeQuizInteractor;

    @Captor
    ArgumentCaptor<TakeQuizOutputData> outputCaptor;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void testAllCorrectExecuteOpenEndedQuestion() {

        takeQuizInteractor = new TakeQuizInteractor(quizDataAccessObject, takeQuizPresenter);
        String quizTitle = "Sample Quiz";
        TakeQuizInputData input = new TakeQuizInputData(quizTitle, new ObjectId(), Arrays.asList("Answer1", "Answer2"));
        List<Question<?>> mockQuestions = Arrays.asList(
                new OpenEndedQuestion("Question1", "Answer1"),
                new OpenEndedQuestion("Question2", "Answer2")
        );


        when(quizDataAccessObject.getQuiz(quizTitle)).thenReturn(quiz);
        when(quiz.getQuestions()).thenReturn(mockQuestions);

        takeQuizInteractor.execute(input);

        verify(takeQuizPresenter).prepareSuccessView(ArgumentMatchers.any(TakeQuizOutputData.class));
        verify(takeQuizPresenter).prepareSuccessView(outputCaptor.capture());

        assertEquals(outputCaptor.getValue().getScore(), 2);
    }

    @Test
    public void testAllWrongExecuteOpenEndedQuestion() {

        takeQuizInteractor = new TakeQuizInteractor(quizDataAccessObject, takeQuizPresenter);
        String quizTitle = "Sample Quiz";
        TakeQuizInputData input = new TakeQuizInputData(quizTitle, new ObjectId(), Arrays.asList("WrongAnswer1", "WrongAnswer2"));
        List<Question<?>> mockQuestions = Arrays.asList(
                new OpenEndedQuestion("Question1", "Answer1"),
                new OpenEndedQuestion("Question2", "Answer2")
        );


        when(quizDataAccessObject.getQuiz(quizTitle)).thenReturn(quiz);
        when(quiz.getQuestions()).thenReturn(mockQuestions);

        takeQuizInteractor.execute(input);

        verify(takeQuizPresenter).prepareSuccessView(ArgumentMatchers.any(TakeQuizOutputData.class));
        verify(takeQuizPresenter).prepareSuccessView(outputCaptor.capture());

        assertEquals(outputCaptor.getValue().getScore(), 0);
    }
    @Test
    public void testOneAnswerCorrectExecuteOpenEndedQuestion() {

        takeQuizInteractor = new TakeQuizInteractor(quizDataAccessObject, takeQuizPresenter);
        String quizTitle = "Sample Quiz";
        TakeQuizInputData input = new TakeQuizInputData(quizTitle, new ObjectId(), Arrays.asList("Answer1", "WrongAnswer2"));
        List<Question<?>> mockQuestions = Arrays.asList(
                new OpenEndedQuestion("Question1", "Answer1"),
                new OpenEndedQuestion("Question2", "Answer2")
        );


        when(quizDataAccessObject.getQuiz(quizTitle)).thenReturn(quiz);
        when(quiz.getQuestions()).thenReturn(mockQuestions);

        takeQuizInteractor.execute(input);

        verify(takeQuizPresenter).prepareSuccessView(ArgumentMatchers.any(TakeQuizOutputData.class));
        verify(takeQuizPresenter).prepareSuccessView(outputCaptor.capture());

        assertEquals(outputCaptor.getValue().getScore(), 1);
    }

    @Test
    public void testExecuteMCQ() {

        takeQuizInteractor = new TakeQuizInteractor(quizDataAccessObject, takeQuizPresenter);
        String quizTitle = "Sample Quiz";
        TakeQuizInputData input = new TakeQuizInputData(quizTitle, new ObjectId(), Arrays.asList(1, 2));
        Map<Integer, String> answerOptions = new HashMap<>();
        answerOptions.put(1, "Answer1");
        answerOptions.put(2, "Answer2");
        answerOptions.put(3, "Answer3");
        answerOptions.put(4, "Answer4");
        List<Question<?>> mockQuestions = Arrays.asList(
                new MultipleChoiceQuestion("Question1", answerOptions, 1),
                new MultipleChoiceQuestion("Question2", answerOptions, 2)
        );


        when(quizDataAccessObject.getQuiz(quizTitle)).thenReturn(quiz);
        when(quiz.getQuestions()).thenReturn(mockQuestions);

        takeQuizInteractor.execute(input);

        verify(takeQuizPresenter).prepareSuccessView(ArgumentMatchers.any(TakeQuizOutputData.class));
    }
}