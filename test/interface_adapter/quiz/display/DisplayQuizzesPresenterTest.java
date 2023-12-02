package interface_adapter.quiz.display;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.display_notes.DisplayNotesPresenter;
import interface_adapter.note.display_notes.DisplayNotesState;
import interface_adapter.note.display_notes.DisplayNotesViewModel;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.note.display_notes.DisplayNotesOutputData;

import static org.mockito.Mockito.*;

public class DisplayQuizzesPresenterTest {
    @Mock
    private DisplayNotesViewModel displayNotesViewModel;

    @Mock
    private ViewManagerModel viewManagerModel;

    private DisplayNotesPresenter displayNotesPresenter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        displayNotesPresenter = new DisplayNotesPresenter(displayNotesViewModel, viewManagerModel);
    }

    @Test
    public void testPrepareSuccessView() {
        // Mocking the output data
        String[][] mockNotes = {{"Note 1", "Content 1"}, {"Note 2", "Content 2"}};
        ObjectId[] mockIds = {new ObjectId("656583e8d05ae3b112ed77c1"), new ObjectId("656583e8d05ae3b112ed77c2")};
        DisplayNotesOutputData mockOutputData = new DisplayNotesOutputData(mockNotes, mockIds);

        // Mocking the DisplayNotesState
        DisplayNotesState mockNotesState = mock(DisplayNotesState.class);
        when(displayNotesViewModel.getState()).thenReturn(mockNotesState);

        // Execute the prepareSuccessView method
        displayNotesPresenter.prepareSuccessView(mockOutputData);

        // Verify that the DisplayNotesState is updated correctly
        verify(mockNotesState).setTable(mockNotes);
        verify(mockNotesState).setIds(mockIds);

        // Verify that the DisplayNotesViewModel is updated correctly
        verify(displayNotesViewModel).setState(mockNotesState);
        verify(displayNotesViewModel).firePropertyChanged();

        // Verify that the ViewManagerModel is updated with the correct active view
        verify(viewManagerModel).setActiveView(displayNotesViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    public void testPrepareFailView() {
        // Mocking the error message
        String errorMessage = "Error: No notes to display.";

        // Mocking the DisplayNotesState
        DisplayNotesState mockNotesState = mock(DisplayNotesState.class);
        when(displayNotesViewModel.getState()).thenReturn(mockNotesState);

        // Execute the prepareFailView method
        displayNotesPresenter.prepareFailView(errorMessage);

        // Verify that the DisplayNotesState is updated correctly
        verify(mockNotesState).setEmptyNotesError(errorMessage);

        // Verify that the DisplayNotesViewModel is updated correctly
        verify(displayNotesViewModel).firePropertyChanged();
    }
}
