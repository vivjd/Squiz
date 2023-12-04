package use_case.note.save;
import interface_adapter.note.save.SaveNoteController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

public class SaveNoteControllerTest {

    @Mock
    private SaveNoteInputBoundary mockNoteUseCaseInteractor;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute() {
        // Create an instance of SaveNoteController with the mocked interactor
        SaveNoteController saveNoteController = new SaveNoteController(mockNoteUseCaseInteractor);

        // Define the input parameters
        String title = "Sample Title";
        String inputText = "Sample note content";

        // Call the execute method with the mocked input parameters
        saveNoteController.execute(title, inputText);

        // Verify that the interactor execute method was called with the expected SaveNoteInputData
        verify(mockNoteUseCaseInteractor).execute(any(SaveNoteInputData.class));
    }
}
