package use_case.quiz.generate;

import static org.mockito.Mockito.*;

import interface_adapter.quiz.generate.GenerateQuizController;
import org.junit.jupiter.api.Test;

public class GenerateQuizControllerTest {

    @Test
    void testExecute() throws Exception {
        GenerateQuizInputBoundary mockUseCase = mock(GenerateQuizInputBoundary.class);
        GenerateQuizController controller = new GenerateQuizController(mockUseCase);
        String note = "Sample note";
        String title = "Sample title";

        controller.execute(note, title);

        verify(mockUseCase, times(1)).execute(any()); // Assuming execute method takes any input
    }
}
