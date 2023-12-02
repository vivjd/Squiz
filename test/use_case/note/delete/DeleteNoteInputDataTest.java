package use_case.note.delete;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteNoteInputDataTest {
    @Test
    public void testDeleteNoteInputDataConstruction(){
        ObjectId noteId = new ObjectId("656583e8d05ae3b112ed77c1");

        DeleteNoteInputData deleteNoteInputData = new DeleteNoteInputData(noteId);

        assertNotNull(deleteNoteInputData);
        assertEquals(deleteNoteInputData.getObjectId(), noteId);
    }
}
