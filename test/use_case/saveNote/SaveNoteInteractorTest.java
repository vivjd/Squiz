package use_case.saveNote;
import entity.Note;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import use_case.note.NoteDataAccessInterface;
import use_case.note.save.SaveNoteInputData;
import use_case.note.save.SaveNoteInteractor;
import use_case.note.save.SaveNoteOutputBoundary;
import use_case.note.save.SaveNoteOutputData;

public class SaveNoteInteractorTest {

    @Mock
    private NoteDataAccessInterface mockNoteDataAccessObject;

    @Mock
    private SaveNoteOutputBoundary mockNotePresenter;

    @Mock
    private SaveNoteInputData mockSaveNoteInputData;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecuteWithValidInput() {
        // Create an instance of SaveNoteInteractor with the mocked dependencies
        SaveNoteInteractor saveNoteInteractor = new SaveNoteInteractor(mockNoteDataAccessObject, mockNotePresenter);

        // Define the behavior of the mocked SaveNoteInputData
        when(mockSaveNoteInputData.getInputText()).thenReturn("Sample note content");
        when(mockSaveNoteInputData.getTitle()).thenReturn("Sample Title");

        // Call the execute method with the mocked input data
        saveNoteInteractor.execute(mockSaveNoteInputData);

        // Verify that the noteDataAccessObject saveNote method was called
        verify(mockNoteDataAccessObject).saveNote(any(Note.class));

        // Verify that the notePresenter prepareSuccessView method was called
        verify(mockNotePresenter).prepareSuccessView(any(SaveNoteOutputData.class));

        // Verify that the notePresenter prepareFailView method was not called
        verify(mockNotePresenter, never()).prepareFailView(anyString());
    }

    @Test
    public void testExecuteWithTitleMissing() {
        // Create an instance of SaveNoteInteractor with the mocked dependencies
        SaveNoteInteractor saveNoteInteractor = new SaveNoteInteractor(mockNoteDataAccessObject, mockNotePresenter);

        // Define the behavior of the mocked SaveNoteInputData
        when(mockSaveNoteInputData.getInputText()).thenReturn("Sample note content");
        when(mockSaveNoteInputData.getTitle()).thenReturn("");

        // Call the execute method with the mocked input data
        saveNoteInteractor.execute(mockSaveNoteInputData);

        // Verify that the noteDataAccessObject saveNote method was not called
        verify(mockNoteDataAccessObject, never()).saveNote(any(Note.class));

        // Verify that the notePresenter prepareSuccessView method was not called
        verify(mockNotePresenter, never()).prepareSuccessView(any(SaveNoteOutputData.class));

        // Verify that the notePresenter prepareFailView method was called
        verify(mockNotePresenter).prepareFailView("Please enter a title for your note.");
    }

    @Test
    public void testExecuteWithContentMissing() {
        // Create an instance of SaveNoteInteractor with the mocked dependencies
        SaveNoteInteractor saveNoteInteractor = new SaveNoteInteractor(mockNoteDataAccessObject, mockNotePresenter);

        // Define the behavior of the mocked SaveNoteInputData
        when(mockSaveNoteInputData.getInputText()).thenReturn("");
        when(mockSaveNoteInputData.getTitle()).thenReturn("Sample Title");

        // Call the execute method with the mocked input data
        saveNoteInteractor.execute(mockSaveNoteInputData);

        // Verify that the noteDataAccessObject saveNote method was not called
        verify(mockNoteDataAccessObject, never()).saveNote(any(Note.class));

        // Verify that the notePresenter prepareSuccessView method was not called
        verify(mockNotePresenter, never()).prepareSuccessView(any(SaveNoteOutputData.class));

        // Verify that the notePresenter prepareFailView method was called
        verify(mockNotePresenter).prepareFailView("Please enter a minimum of 40 words for your Sample Title note.");
    }
}
