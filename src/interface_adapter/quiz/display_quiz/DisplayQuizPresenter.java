package interface_adapter.quiz.display_quiz;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.DisplayQuizzesState;
import interface_adapter.quiz.DisplayQuizzesViewModel;
import use_case.quiz.display_quiz.DisplayQuizOutputBoundary;
import use_case.quiz.display_quiz.DisplayQuizOutputData;

public class DisplayQuizPresenter implements DisplayQuizOutputBoundary {
    private final DisplayQuizzesViewModel quizViewModel;

    private ViewManagerModel viewManagerModel;

    public DisplayQuizPresenter(DisplayQuizzesViewModel quizViewModel, ViewManagerModel viewManagerModel){
        this.quizViewModel = quizViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DisplayQuizOutputData quiz) {
        DisplayQuizzesState quizState = quizViewModel.getState();
        quizViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DisplayQuizzesState quizState = quizViewModel.getState();
        quizState.setEmptyQuizError(error);
        quizViewModel.firePropertyChanged();
    }
}
