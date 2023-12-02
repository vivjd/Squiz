package interface_adapter.note.delete;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.display.DisplayNotesViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DeleteNotePresenterTest {
    @Mock
    private DisplayNotesViewModel mockDisplayNotesViewModel;

    @Mock
    private ViewManagerModel mockViewManagerModel;

    private DeleteNotePresenter deleteNotePresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteNotePresenter = new DeleteNotePresenter(mockDisplayNotesViewModel, mockViewManagerModel);
    }

    @Test
    void testPrepareSuccessView() {
        deleteNotePresenter.prepareSuccessView();

        verifyNoInteractions(mockDisplayNotesViewModel);
        verifyNoInteractions(mockViewManagerModel);
    }

    @Test
    void testPrepareFailView() {
        String errorMessage = "Error: Note deletion failed.";

        deleteNotePresenter.prepareFailView(errorMessage);

        verifyNoInteractions(mockViewManagerModel);
    }
}