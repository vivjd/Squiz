package interface_adapter.quiz.display;

import interface_adapter.ViewManagerModel;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.quiz.display.DisplayQuizzesOutputData;

import static org.mockito.Mockito.*;

public class DisplayQuizzesPresenterTest {
    @Mock
    private DisplayQuizzesViewModel displayQuizzesViewModel;

    @Mock
    private ViewManagerModel viewManagerModel;

    private DisplayQuizzesPresenter displayQuizzesPresenter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        displayQuizzesPresenter = new DisplayQuizzesPresenter(displayQuizzesViewModel, viewManagerModel);
    }

    @Test
    public void testPrepareSuccessView() {
        // Mocking the output data
        String[][] mockQuizzes = {{"Quiz 1", "3", "2023/12/20"}, {"Quiz 2", "6", "2023/11/20"}};
        ObjectId[] mockIds = {new ObjectId("656583e8d05ae3b112ed77c1"), new ObjectId("656583e8d05ae3b112ed77c2")};
        DisplayQuizzesOutputData mockOutputData = new DisplayQuizzesOutputData(mockQuizzes, mockIds);

        // Mocking the DisplayQuizzesState
        DisplayQuizzesState mockQuizState = mock(DisplayQuizzesState.class);
        when(displayQuizzesViewModel.getState()).thenReturn(mockQuizState);

        // Execute the prepareSuccessView method
        displayQuizzesPresenter.prepareSuccessView(mockOutputData);

        // Verify that the DisplayQuizzesState is updated correctly
        verify(mockQuizState).setQuizzesTable(mockQuizzes);
        verify(mockQuizState).setIds(mockIds);

        // Verify that the DisplayQuizzesViewModel is updated correctly
        verify(displayQuizzesViewModel).setState(mockQuizState);
        verify(displayQuizzesViewModel).firePropertyChanged();

        // Verify that the ViewManagerModel is updated with the correct active view
        verify(viewManagerModel).setActiveView(displayQuizzesViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    public void testPrepareFailView() {
        // Mocking the error message
        String errorMessage = "Error: No quizzes to display.";

        // Mocking the DisplayQuizzesState
        DisplayQuizzesState mockQuizState = mock(DisplayQuizzesState.class);
        when(displayQuizzesViewModel.getState()).thenReturn(mockQuizState);

        // Execute the prepareFailView method
        displayQuizzesPresenter.prepareFailView(errorMessage);

        // Verify that the DisplayQuizzesState is updated correctly
        verify(mockQuizState).setEmptyQuizError(errorMessage);

        // Verify that the DisplayQuizzesViewModel is updated correctly
        verify(displayQuizzesViewModel).firePropertyChanged();
    }
}
