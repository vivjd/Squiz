package use_case.question;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AnswerQuestionInteractorTest {

    private QuestionDataAccessInterface questionDataAccessObject;
    private AnswerQuestionOutputBoundary questionPresenter;
    private AnswerQuestionInteractor answerQuestionInteractor;

    @BeforeEach
    void setUp() {
        questionDataAccessObject = mock(QuestionDataAccessInterface.class);
        questionPresenter = mock(AnswerQuestionOutputBoundary.class);
        answerQuestionInteractor = new AnswerQuestionInteractor(questionDataAccessObject, questionPresenter);
    }

    @Test
    void execute_ShouldPrepareSuccessViewWithFeedback() {
        String userAnswer = "User's answer";
        Question<?> question = mock(MultipleChoiceQuestion.class);
        AnswerQuestionInputData input = new AnswerQuestionInputData(userAnswer, question);

        when(answerQuestionInteractor.getMCQCorrectAnswer((MultipleChoiceQuestion) question)).thenReturn("Correct MCQ Answer");

        answerQuestionInteractor.execute(input);

        verify(questionPresenter).prepareSuccessView(any(AnswerQuestionOutputData.class));
    }

    @Test
    void answerFeedback_ShouldReturnCorrectFeedbackForMCQ() {
        MultipleChoiceQuestion mcq = new MultipleChoiceQuestion();
        mcq.setCorrectAnswerIndex("1");

        String feedback = answerQuestionInteractor.answerFeedback(mcq, "1");

        assertEquals("The correct answer was: 1", feedback);
    }

    @Test
    void answerFeedback_ShouldReturnCorrectFeedbackForOpenEndedQuestion() {
        OpenEndedQuestion openEndedQuestion = new OpenEndedQuestion();
        openEndedQuestion.setCorrectAnswer("Open Ended Correct Answer");

        String feedback = answerQuestionInteractor.answerFeedback(openEndedQuestion, "User's Answer");

        assertEquals("the correct answer was: Open Ended Correct Answer", feedback);
    }

    @Test
    void isInstanceOfMCQ_ShouldReturnTrueForMCQ() {
        Question question = mock(MultipleChoiceQuestion.class);

        boolean result = answerQuestionInteractor.isInstanceOfMCQ(question);

        assertTrue(result);
    }

    @Test
    void isInstanceOfMCQ_ShouldReturnFalseForOpenEndedQuestion() {
        Question question = mock(OpenEndedQuestion.class);

        boolean result = answerQuestionInteractor.isInstanceOfMCQ(question);

        assertFalse(result);
    }
}
