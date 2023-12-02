package interface_adapter.quiz.display;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;

public class DisplayQuizzesViewTestModelTest {
    @Mock
    private DisplayQuizzesState mockState;

    @Mock
    private PropertyChangeListener mockListener;

    private DisplayQuizzesViewModel displayQuizzesViewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        displayQuizzesViewModel = new DisplayQuizzesViewModel();
    }

    @Test
    void testGetState() {
        // Ensure that the initial state is not null
        assert displayQuizzesViewModel.getState() != null;
    }

    @Test
    void testSetState() {
        DisplayQuizzesState newState = mock(DisplayQuizzesState.class);

        displayQuizzesViewModel.setState(newState);

        assert displayQuizzesViewModel.getState() == newState;
    }

    @Test
    void testFirePropertyChanged() {
        DisplayQuizzesState newState = mock(DisplayQuizzesState.class);

        displayQuizzesViewModel.addPropertyChangeListener(mockListener);

        displayQuizzesViewModel.firePropertyChanged();

        verify(mockListener, times(1)).propertyChange(any());
    }
}
