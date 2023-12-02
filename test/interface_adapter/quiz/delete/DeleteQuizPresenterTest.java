package interface_adapter.quiz.delete;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.quiz.delete.DeleteQuizOutputData;

import static org.mockito.Mockito.verifyNoInteractions;

public class DeleteQuizPresenterTest {
    @Mock
    private DisplayQuizzesViewModel displayQuizzesViewModel;

    @Mock
    private ViewManagerModel viewManagerModel;

    private DeleteQuizPresenter deleteQuizPresenter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteQuizPresenter = new DeleteQuizPresenter(displayQuizzesViewModel, viewManagerModel);
    }

    @Test
    public void testPrepareSuccessView() {

        // Execute the prepareSuccessView method
        deleteQuizPresenter.prepareSuccessView(new DeleteQuizOutputData("Quiz 1", 3));

        // Verify that the DisplayQuizzesViewModel and ViewManagerModel are not interacted with
        verifyNoInteractions(displayQuizzesViewModel, viewManagerModel);
    }

    @Test
    public void testPrepareFailView() {
        // Mocking the error message
        String errorMessage = "Error: Quiz deletion failed.";

        // Execute the prepareFailView method
        deleteQuizPresenter.prepareFailView(errorMessage);

        // Verify that the DisplayQuizzesViewModel is not interacted with
        verifyNoInteractions(displayQuizzesViewModel);

        // Verify that the ViewManagerModel is not interacted with
        verifyNoInteractions(viewManagerModel);
    }
}
