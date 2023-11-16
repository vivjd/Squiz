package interface_adapter.quiz;

import interface_adapter.ViewManagerModel;
import use_case.quiz.DisplayQuizzesOutputBoundary;
import use_case.quiz.DisplayQuizzesOutputData;

public class DisplayQuizzesPresenter implements DisplayQuizzesOutputBoundary {
    private final DisplayQuizzesViewModel displayQuizzesViewModel;

    private ViewManagerModel viewManagerModel;

    public DisplayQuizzesPresenter(DisplayQuizzesViewModel displayQuizzesViewModel, ViewManagerModel viewManagerModel){
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DisplayQuizzesOutputData quiz) {
        DisplayQuizzesState quizState = displayQuizzesViewModel.getState();
        displayQuizzesViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DisplayQuizzesState quizState = displayQuizzesViewModel.getState();
        quizState.setEmptyQuizError(error);
        displayQuizzesViewModel.firePropertyChanged();
    }
}
