package use_case.note.save;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaveNoteOutputDataTest {
    @Test
    void testGetTitle() {
        // Arrange
        SaveNoteOutputData outputData = new SaveNoteOutputData("Test Title", "Test Input Text", false);
        String title = outputData.getTitle();
        assertEquals("Test Title", title);
    }

    @Test
    void testGetInputText() {
        // Arrange
        SaveNoteOutputData outputData = new SaveNoteOutputData("Test Title", "Test Input Text", false);
        String inputText = outputData.getInputText();
        assertEquals("Test Input Text", inputText);
    }

    @Test
    void testSetInputText() {
        // Arrange
        SaveNoteOutputData outputData = new SaveNoteOutputData("Test Title", "Test Input Text", false);
        outputData.setInputText("Updated Input Text");
        assertEquals("Updated Input Text", outputData.getInputText());
    }
}
