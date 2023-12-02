package use_case.saveNote;

import interface_adapter.note.NoteState;
import interface_adapter.note.NoteViewModel;
import interface_adapter.note.save.SaveNotePresenter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import interface_adapter.ViewManagerModel;
import use_case.note.save.SaveNoteOutputData;

public class SaveSaveNotePresenterTest {

    @Mock
    private NoteViewModel mockNoteViewModel;

    @Mock
    private ViewManagerModel mockViewManagerModel;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testPrepareSuccessView() {
        // Create an instance of SaveSaveNotePresenter with the mocked dependencies
        SaveNotePresenter saveSaveNotePresenter = new SaveNotePresenter(mockNoteViewModel, mockViewManagerModel);

        // Create a mocked SaveNoteOutputData for a successful scenario
        SaveNoteOutputData mockSaveNoteOutputData = mock(SaveNoteOutputData.class);
        when(mockSaveNoteOutputData.getInputText()).thenReturn("Sample note content");
        when(mockSaveNoteOutputData.getTitle()).thenReturn("Sample Title");

        NoteState mockNoteState = mock(NoteState.class);
        when(mockNoteViewModel.getState()).thenReturn(mockNoteState);

        // Call the prepareSuccessView method with the mocked output data
        saveSaveNotePresenter.prepareSuccessView(mockSaveNoteOutputData);

        // Verify that the noteViewModel and viewManagerModel methods were called appropriately
        verify(mockNoteViewModel).getState();
        verify(mockNoteViewModel.getState()).setNote("Sample note content");
        verify(mockNoteViewModel.getState()).setTitle("Sample Title");
    }

    @Test
    public void testPrepareFailView() {
        // Create an instance of SaveSaveNotePresenter with the mocked dependencies
        SaveNotePresenter saveSaveNotePresenter = new SaveNotePresenter(mockNoteViewModel, mockViewManagerModel);

        NoteState mockNoteState = mock(NoteState.class);
        when(mockNoteViewModel.getState()).thenReturn(mockNoteState);

        // Call the prepareFailView method with a mock error message
        saveSaveNotePresenter.prepareFailView("Error: Note not saved.");

        // Verify that the noteViewModel, viewManagerModel, and NoteState methods were called appropriately
        verify(mockNoteViewModel).getState();
        verify(mockNoteViewModel.getState()).setEmptyNoteError("Error: Note not saved.");
        verify(mockNoteViewModel).firePropertyChanged();
    }
}
