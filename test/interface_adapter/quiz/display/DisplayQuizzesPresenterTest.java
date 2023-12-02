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
        String[][] mockQuizzes = {{"Quiz 1", "3", "2023/12/20"}, {"Quiz 2", "6", "2023/11/20"}};
        ObjectId[] mockIds = {new ObjectId("656583e8d05ae3b112ed77c1"), new ObjectId("656583e8d05ae3b112ed77c2")};
        DisplayQuizzesOutputData mockOutputData = new DisplayQuizzesOutputData(mockQuizzes, mockIds);

        DisplayQuizzesState mockQuizState = mock(DisplayQuizzesState.class);
        when(displayQuizzesViewModel.getState()).thenReturn(mockQuizState);

        displayQuizzesPresenter.prepareSuccessView(mockOutputData);

        verify(mockQuizState).setQuizzesTable(mockQuizzes);
        verify(mockQuizState).setIds(mockIds);

        verify(displayQuizzesViewModel).setState(mockQuizState);
        verify(displayQuizzesViewModel).firePropertyChanged();

        verify(viewManagerModel).setActiveView(displayQuizzesViewModel.getViewName());
        verify(viewManagerModel).firePropertyChanged();
    }

    @Test
    public void testPrepareFailView() {
        String errorMessage = "Error: No quizzes to display.";

        DisplayQuizzesState mockQuizState = mock(DisplayQuizzesState.class);
        when(displayQuizzesViewModel.getState()).thenReturn(mockQuizState);

        displayQuizzesPresenter.prepareFailView(errorMessage);

        verify(mockQuizState).setEmptyQuizError(errorMessage);

        verify(displayQuizzesViewModel).firePropertyChanged();
    }
}
