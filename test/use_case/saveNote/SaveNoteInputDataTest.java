package use_case.saveNote;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import use_case.note.save.SaveNoteInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SaveNoteInputDataTest {

    @Test
    void testGetTitle() {
        // Arrange
        String expectedTitle = "Test Title";
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData(expectedTitle, "Test Input Text");

        // Act
        String actualTitle = saveNoteInputData.getTitle();

        // Assert
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void testGetInputText() {
        // Arrange
        String expectedInputText = "Test Input Text";
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData("Test Title", expectedInputText);

        // Act
        String actualInputText = saveNoteInputData.getInputText();

        // Assert
        assertEquals(expectedInputText, actualInputText);
    }

    @Test
    void testSetTitle() {
        // Arrange
        String newTitle = "New Title";
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData("Old Title", "Test Input Text");

        // Act
        saveNoteInputData.setTitle(newTitle);

        // Assert
        assertEquals(newTitle, saveNoteInputData.getTitle());
    }

    @Test
    void testSetInputText() {
        // Arrange
        String newInputText = "New Input Text";
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData("Test Title", "Old Input Text");

        // Act
        saveNoteInputData.setInputText(newInputText);

        // Assert
        assertEquals(newInputText, saveNoteInputData.getInputText());
    }
}
