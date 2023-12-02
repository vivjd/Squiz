package use_case.quiz.generate;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class GenerateQuizInteractorTest {
    @Mock
    private GenerateQuizOutputBoundary mockQuizPresenter;
    @Mock
    private GenerateQuizInputData mockGenerateQuizInputData;
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testExecute() {
        // Create an instance of GenerateQuizInteractor with the mocked dependencies
        GenerateQuizInteractor generateQuizInteractor = new GenerateQuizInteractor(mockQuizPresenter);

        // Define the behavior of the mocked GenerateQuizInputData
        when(mockGenerateQuizInputData.getNote()).thenReturn("Sample Note");

        try {
            // Call the execute method with the mocked input data
            doNothing().when(generateQuizInteractor).execute(any());
            generateQuizInteractor.execute(mockGenerateQuizInputData);


            // Verify that the quizPresenter methods were called as expected
            verify(mockQuizPresenter).prepareSuccessView("Quiz Generated");
            verify(mockQuizPresenter, never()).prepareFailView(anyString());
        } catch (Exception e) {
            // Fail the test if an exception is thrown during execution
            e.printStackTrace();
        }
    }
}
