package interface_adapter.note.delete;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.note.delete.DeleteNoteInputBoundary;

import static org.mockito.Mockito.*;

public class DeleteNoteControllerTest {
    @Mock
    private DeleteNoteInputBoundary deleteNoteInteractor;

    private DeleteNoteController deleteNoteController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteNoteController = new DeleteNoteController(deleteNoteInteractor);
    }

    @Test
    public void testExecute() {
        ObjectId noteId = new ObjectId("656583e8d05ae3b112ed77c1");

        deleteNoteController.execute(noteId);

        verify(deleteNoteInteractor).execute(argThat(argument -> argument.getObjectId().equals(noteId)));
    }
}
