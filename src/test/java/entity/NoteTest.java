package entity;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {
    private Note sampleNote;

    @BeforeEach
    void init() {
        sampleNote = new Note();
        sampleNote.setTitle("CSC207");
        sampleNote.setId(new ObjectId("60236833af6a1d49478d2bef"));
        sampleNote.setUserPrompt("We love Java!");
    }

    @Test
    void getIdTest() {
        assertEquals(new ObjectId("60236833af6a1d49478d2bef").toHexString(), sampleNote.getId().toHexString());
    }

    @Test
    void getTitleTest() {
        assertEquals("CSC207", sampleNote.getTitle());
    }

    @Test
    void getUserPromptTest() {
        assertEquals("We love Java!", sampleNote.getUserPrompt());
    }

    @Test
    void toJsonTest() {
//          Gson gson = new Gson();
//          assertEquals("")
    }
}