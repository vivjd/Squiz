package interface_adapter.note.display;

import interface_adapter.note.display_notes.DisplayNotesState;
import interface_adapter.note.display_notes.DisplayNotesViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;

public class DisplayNotesViewModelTest {
    @Mock
    private DisplayNotesState mockState;

    @Mock
    private PropertyChangeListener mockListener;

    private DisplayNotesViewModel displayNotesViewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        displayNotesViewModel = new DisplayNotesViewModel();
    }

    @Test
    void testGetState() {
        assert displayNotesViewModel.getState() != null;
    }

    @Test
    void testSetState() {
        DisplayNotesState newState = mock(DisplayNotesState.class);

        displayNotesViewModel.setState(newState);

        assert displayNotesViewModel.getState() == newState;
    }

    @Test
    void testFirePropertyChanged() {
        DisplayNotesState newState = mock(DisplayNotesState.class);

        displayNotesViewModel.addPropertyChangeListener(mockListener);
        displayNotesViewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any());
    }
}
