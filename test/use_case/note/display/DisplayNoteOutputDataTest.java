package use_case.note.display;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DisplayNoteOutputDataTest {
    @Test
    void testConstructorAndGetters() {
        String[][] mockNotes = {{"Note 1", "Content 1"}, {"Note 2", "Content 2"}};
        ObjectId[] mockIds = {new ObjectId("656583e8d05ae3b112ed77d1"), new ObjectId("656583e8d05ae3b112ed77d2")};

        DisplayNotesOutputData outputData = new DisplayNotesOutputData(mockNotes, mockIds);

        assertArrayEquals(mockNotes, outputData.getNotes());
        assertArrayEquals(mockIds, outputData.getIds());
    }
}
