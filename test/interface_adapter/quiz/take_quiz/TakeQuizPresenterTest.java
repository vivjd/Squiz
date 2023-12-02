package interface_adapter.quiz.take_quiz;

import entity.Question;
import entity.Quiz;
import interface_adapter.ViewManagerModel;
import interface_adapter.question.AnswerQuestionState;
import interface_adapter.question.QuestionViewModel;
import org.junit.Before;
import org.junit.Test;
import use_case.quiz.take_quiz.TakeQuizOutputData;

import java.util.Collections;

import static org.mockito.Mockito.*;

public class TakeQuizPresenterTest {

    private TakeQuizViewModel takeQuizViewModel;
    private ViewManagerModel viewManagerModel;
    private QuestionViewModel questionViewModel;
    private TakeQuizPresenter takeQuizPresenter;

    @Before
    public void setUp() {
        takeQuizViewModel = mock(TakeQuizViewModel.class);

        TakeQuizState mockState = mock(TakeQuizState.class);
        when(takeQuizViewModel.getState()).thenReturn(mockState);

        when(mockState.getQuestions()).thenReturn(Collections.singletonList(mock(Question.class)));

        viewManagerModel = mock(ViewManagerModel.class);
        questionViewModel = mock(QuestionViewModel.class);
        takeQuizPresenter = new TakeQuizPresenter(takeQuizViewModel, viewManagerModel, questionViewModel);
    }

    @Test
    public void prepareExecuteSuccessView_ShouldUpdateQuestionViewModel() {
        TakeQuizOutputData takeQuizOutputData = mock(TakeQuizOutputData.class);

        takeQuizPresenter.prepareExecuteSuccessView(takeQuizOutputData);

        verify(questionViewModel).setState(any(AnswerQuestionState.class));
        verify(questionViewModel).firePropertyChanged();
    }

    @Test
    public void prepareStartSuccessView_ShouldUpdateTakeQuizViewModelAndSetActiveView() {
        TakeQuizOutputData takeQuizOutputData = mock(TakeQuizOutputData.class);
        Quiz quiz = mock(Quiz.class);
        when(takeQuizOutputData.getQuiz()).thenReturn(quiz);

        takeQuizPresenter.prepareStartSuccessView(takeQuizOutputData);

        verify(takeQuizViewModel).setState(any(TakeQuizState.class));
        verify(takeQuizViewModel).firePropertyChanged();
        verify(viewManagerModel).setActiveView(null);
        verify(viewManagerModel).firePropertyChanged();
    }


    @Test
    public void prepareNextSuccessView_ShouldUpdateQuestionViewModelOrSetActiveView() {
        TakeQuizOutputData takeQuizOutputData = mock(TakeQuizOutputData.class);

        takeQuizPresenter.prepareNextSuccessView(takeQuizOutputData);

        verify(questionViewModel, atMostOnce()).setState(any(AnswerQuestionState.class));
        verify(questionViewModel, atMostOnce()).firePropertyChanged();
        verify(viewManagerModel, atMostOnce()).setActiveView(anyString());
        verify(viewManagerModel, atMostOnce()).firePropertyChanged();
    }

    @Test
    public void prepareFailView_ShouldNotThrowException() {
        takeQuizPresenter.prepareFailView("error");

    }
}
