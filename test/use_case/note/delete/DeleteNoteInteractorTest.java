package use_case.note.delete;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import use_case.note.NoteDataAccessInterface;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeleteNoteInteractorTest {

    private NoteDataAccessInterface noteDataAccessObject;
    private DeleteNoteOutputBoundary deleteNoteOutputBoundary;
    private DeleteNoteInteractor deleteNoteInteractor;

    @Before
    public void setUp() {
        noteDataAccessObject = mock(NoteDataAccessInterface.class);
        deleteNoteOutputBoundary = mock(DeleteNoteOutputBoundary.class);
        deleteNoteInteractor = new DeleteNoteInteractor(noteDataAccessObject, deleteNoteOutputBoundary);
    }

    @Test
    public void testExecuteSuccess() {

        ObjectId noteIdToDelete = new ObjectId("60236833af6a1d49478d2bef");
        DeleteNoteInputData deleteNoteInputData = new DeleteNoteInputData(noteIdToDelete);

        deleteNoteInteractor.execute(deleteNoteInputData);

        verify(noteDataAccessObject).deleteNote(noteIdToDelete);
        verifyNoInteractions(deleteNoteOutputBoundary);
    }

    @Test
    public void testExecuteThrowsRuntimeException() {
        ObjectId noteIdToDelete = new ObjectId("60236833af6a1d49478d2bef");
        DeleteNoteInputData deleteNoteInputData = new DeleteNoteInputData(noteIdToDelete);

        doThrow(new RuntimeException("Mocked Exception"))
                .when(noteDataAccessObject).deleteNote(noteIdToDelete);
        try {
            deleteNoteInteractor.execute(deleteNoteInputData);
            fail("Should throw a runtime Exception");
        } catch (RuntimeException e) {
            verify(noteDataAccessObject).deleteNote(noteIdToDelete);
            verifyNoInteractions(deleteNoteOutputBoundary);
        }
    }
}