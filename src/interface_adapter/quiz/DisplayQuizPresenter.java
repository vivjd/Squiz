package interface_adapter.quiz;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.display_quiz.DisplayQuizState;
import use_case.quiz.DisplayQuizOutputBoundary;
import use_case.quiz.DisplayQuizOutputData;

public class DisplayQuizPresenter implements DisplayQuizOutputBoundary {
    private final QuizViewModel quizViewModel;

    private ViewManagerModel viewManagerModel;

    public DisplayQuizPresenter(QuizViewModel quizViewModel, ViewManagerModel viewManagerModel){
        this.quizViewModel = quizViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DisplayQuizOutputData quiz) {
        DisplayQuizState quizState = quizViewModel.getState();
        quizViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        DisplayQuizState quizState = quizViewModel.getState();
        quizState.setEmptyQuizError(error);
        quizViewModel.firePropertyChanged();
    }
}
