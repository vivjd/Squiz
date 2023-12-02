package use_case.quiz.generate;

import org.junit.jupiter.api.Test;
import use_case.quiz.generate.GenerateQuizOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateQuizOutputDataTest {

    @Test
    void testConstructor() {
        // Arrange
        String title = "Test Quiz";

        // Act
        GenerateQuizOutputData outputData = new GenerateQuizOutputData(title);

        // Assert
        String expectedMessage = "Quiz is generated. Title: " + title + " (QUIZ)";
        assertEquals(expectedMessage, outputData.getMsg());
    }
}
