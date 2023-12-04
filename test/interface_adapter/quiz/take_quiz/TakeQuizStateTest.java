package interface_adapter.quiz.take_quiz;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TakeQuizStateTest {

    @Test
    void getCurrentQuestionIndex_ShouldReturnInitialIndex() {
        TakeQuizState takeQuizState = new TakeQuizState();

        int currentIndex = takeQuizState.getCurrentQuestionIndex();

        assertEquals(0, currentIndex);
    }

    @Test
    void setCurrentQuestionIndex_ShouldSetIndex() {
        TakeQuizState takeQuizState = new TakeQuizState();

        takeQuizState.setCurrentQuestionIndex(2);

        assertEquals(2, takeQuizState.getCurrentQuestionIndex());
    }

    @Test
    void getQuestions_ShouldReturnNullInitially() {
        TakeQuizState takeQuizState = new TakeQuizState();

        List<Question<?>> questions = takeQuizState.getQuestions();

        assertEquals(null, questions);
    }

    @Test
    void setQuestions_ShouldSetQuestions() {
        TakeQuizState takeQuizState = new TakeQuizState();
        List<Question<?>> newQuestions = Arrays.asList(new MultipleChoiceQuestion(), new OpenEndedQuestion());

        takeQuizState.setQuestions(newQuestions);

        assertEquals(newQuestions, takeQuizState.getQuestions());
    }


    @Test
    void getScore_ShouldReturnInitialScore() {
        TakeQuizState takeQuizState = new TakeQuizState();

        int score = takeQuizState.getScore();

        assertEquals(0, score);
    }

    @Test
    void setScore_ShouldSetScore() {
        TakeQuizState takeQuizState = new TakeQuizState();

        takeQuizState.setScore(15);

        assertEquals(15, takeQuizState.getScore());
    }

    @Test
    void resetAll_ShouldResetStateVariables() {
        TakeQuizState takeQuizState = new TakeQuizState();
        takeQuizState.setCurrentQuestionIndex(2);
        takeQuizState.setScore(20);
        takeQuizState.setQuestions(Arrays.asList(new MultipleChoiceQuestion(), new OpenEndedQuestion()));

        takeQuizState.resetAll();

        assertEquals(0, takeQuizState.getCurrentQuestionIndex());
        assertEquals(null, takeQuizState.getQuestions());
        assertEquals(0, takeQuizState.getScore());
    }
}
