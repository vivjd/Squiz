package use_case.quiz.delete;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteQuizOutputDataTest {
    @Test
    void testGetQuizName() {
        String quizName = "Sample Quiz";
        int quizLength = 10;
        DeleteQuizOutputData deleteQuizOutputData = new DeleteQuizOutputData(quizName, quizLength);

        String resultQuizName = deleteQuizOutputData.getQuizName();

        assertEquals(quizName, resultQuizName);
    }

    @Test
    void testGetQuizLength() {
        String quizName = "Sample Quiz";
        int quizLength = 10;
        DeleteQuizOutputData deleteQuizOutputData = new DeleteQuizOutputData(quizName, quizLength);

        int resultQuizLength = deleteQuizOutputData.getQuizLength();

        assertEquals(quizLength, resultQuizLength);
    }
}
