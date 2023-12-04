package use_case.quiz.generate;

import org.junit.jupiter.api.Test;
import use_case.quiz.generate.GenerateQuizInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateQuizInputDataTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String note = "Test note";
        String title = "Test Quiz";

        // Act
        GenerateQuizInputData inputData = new GenerateQuizInputData(note, title);

        // Assert
        assertEquals(note, inputData.getNote());
        assertEquals(title, inputData.getTitle());
    }

    @Test
    void testSetTitle() {
        // Arrange
        String note = "Test note";
        String title = "Test Quiz";
        GenerateQuizInputData inputData = new GenerateQuizInputData(note, title);

        // Act
        String newTitle = "Updated Quiz Title";
        inputData.setTitle(newTitle);

        // Assert
        assertEquals(newTitle, inputData.getTitle());
    }
}
