package entity;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NoteTest {
    private Note sampleNote;

    @Before
    public void setUp() {
        sampleNote = new Note();
        sampleNote.setTitle("CSC207");
        sampleNote.setId(new ObjectId("60236833af6a1d49478d2bef"));
        sampleNote.setUserPrompt("We love Java!");
    }

    @Test
    public void getIdTest() {
        assertEquals(new ObjectId("60236833af6a1d49478d2bef").toHexString(), sampleNote.getId().toHexString());
    }

    @Test
    public void getTitleTest() {
        assertEquals("CSC207", sampleNote.getTitle());
    }

    @Test
    public void getUserPromptTest() {
        assertEquals("We love Java!", sampleNote.getUserPrompt());
    }

    @Test
    public void toJsonTest() {
//          Gson gson = new Gson();
//          assertEquals("")
    }
}
