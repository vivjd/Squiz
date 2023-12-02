package interface_adapter.note.display;

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

public class DisplayNotesPresenterTest {
    @Mock
    private DisplayNotesViewModel mockViewModel;

    @Mock
    private ViewManagerModel mockViewManagerModel;

    private DisplayNotesPresenter displayNotesPresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        displayNotesPresenter = new DisplayNotesPresenter(mockViewModel, mockViewManagerModel);
    }

    @Test
    void testPrepareSuccessView() {
        String[][] mockNotes = {{"Note 1", "Content 1"}, {"Note 2", "Content 2"}};
        ObjectId[] mockIds = {new ObjectId("656583e8d05ae3b112ed77c1"), new ObjectId("656583e8d05ae3b112ed77c2")};
        DisplayNotesOutputData mockOutputData = new DisplayNotesOutputData(mockNotes, mockIds);

        DisplayNotesState mockNotesState = mock(DisplayNotesState.class);
        when(mockViewModel.getState()).thenReturn(mockNotesState);

        displayNotesPresenter.prepareSuccessView(mockOutputData);

        verify(mockViewModel, times(2)).firePropertyChanged();  // State and view model
        verify(mockViewManagerModel, times(1)).firePropertyChanged();  // View manager model
        verify(mockViewModel.getState(), times(1)).setTable(mockNotes);
        verify(mockViewModel.getState(), times(1)).setIds(mockIds);
        verify(mockViewModel, times(1)).setState(any(DisplayNotesState.class));
        verify(mockViewManagerModel, times(1)).setActiveView(anyString());
    }

    @Test
    void testPrepareFailView() {
        String errorMessage = "Test error message";

        displayNotesPresenter.prepareFailView(errorMessage);

        verify(mockViewModel, times(1)).firePropertyChanged();
        verify(mockViewModel.getState(), times(1)).setEmptyNotesError(errorMessage);
        verify(mockViewModel, times(1)).setState(any(DisplayNotesState.class));
    }
}
