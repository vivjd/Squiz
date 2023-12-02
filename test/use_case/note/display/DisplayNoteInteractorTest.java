package use_case.note.display;

import entity.Note;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.note.NoteDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class DisplayNoteInteractorTest {
    private NoteDataAccessInterface noteDataAccessObject;
    private DisplayNotesOutputBoundary notesPresenter;
    private DisplayNotesInteractor displayNotesInteractor;

    @BeforeEach
    public void setUp() {
        noteDataAccessObject = mock(NoteDataAccessInterface.class);
        notesPresenter = mock(DisplayNotesOutputBoundary.class);
        displayNotesInteractor = new DisplayNotesInteractor(noteDataAccessObject, notesPresenter);
    }

    @Test
    public void testExecuteWithNotes() {
        // Mocking the data access object to return a list of notes
        List<Note> mockNotes = new ArrayList<>();
        Note mockNote = new Note();
        mockNote.setTitle("Note 1");
        mockNote.setUserPrompt("This is the user's note.");
        mockNotes.add(mockNote);
        when(noteDataAccessObject.getAllNotes()).thenReturn(mockNotes);

        // Mocking the getAllNotesTable and getAllIds methods
        String[][] mockOutputTableData = {{"Note 1", "This is the user's note."}};
        ObjectId[] mockIds = {new ObjectId("656583e8d05ae3b112ed77d1")};
        when(noteDataAccessObject.getAllNotesTable()).thenReturn(mockOutputTableData);
        when(noteDataAccessObject.getAllIds()).thenReturn(mockIds);

        displayNotesInteractor.execute();
        verify(notesPresenter).prepareSuccessView(any(DisplayNotesOutputData.class));
    }

    @Test
    public void testExecuteWithNoNotes() {
        when(noteDataAccessObject.getAllNotes()).thenReturn(new ArrayList<>());

        displayNotesInteractor.execute();

        verify(notesPresenter).prepareFailView(eq("There are no saved notes to display. Please create a note first and save it."));
    }
}
