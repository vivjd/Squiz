package use_case.quiz.take_quiz;

import entity.Quiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class TakeQuizOutputDataTest {

    @Test
    void constructorWithQuiz_ShouldSetQuiz() {
        Quiz quiz = new Quiz();

        TakeQuizOutputData outputData = new TakeQuizOutputData(quiz);

        assertEquals(quiz, outputData.getQuiz());
    }

    @Test
    void defaultConstructor_ShouldNotSetQuiz() {
        TakeQuizOutputData outputData = new TakeQuizOutputData();

        assertNull(outputData.getQuiz());
    }

    @Test
    void setQuiz_ShouldSetQuiz() {
        Quiz quiz = new Quiz();
        TakeQuizOutputData outputData = new TakeQuizOutputData();

        outputData.setQuiz(quiz);

        assertEquals(quiz, outputData.getQuiz());
    }
}
