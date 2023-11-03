package entity;
import com.google.gson.Gson;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test file for the Notes entity class.
 *
 */
class NoteTest {

    private Note sampleNote;

    @BeforeEach
    void init() {
        Note sampleNote = new Note();
        sampleNote.setTitle("CSC207");
        sampleNote.setId(new ObjectId("60236833af6a1d49478d2bef"));
        sampleNote.setUserPrompt("We love Java!");
    }

    @Test
    void getTitleTest(){
        assertEquals("CSC207", sampleNote.getTitle());
    }

    @Test
    void getUserPromptTest(){
        assertEquals("We love Java!", sampleNote.getUserPrompt());
    }

    @Test
    void getIdTest(){
        assertEquals(new ObjectId("60236833af6a1d49478d2bef").toHexString(), sampleNote.getId().toHexString());
    }

    //not sure about this one
    @Test
    void toJsonTest(){
//        Gson gson = new Gson();
//        assertEquals("")
    }

//    @AfterEach
//    void tearDown() {
//    }
}