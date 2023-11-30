package interface_adapter.quiz.delete;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import use_case.quiz.delete.DeleteQuizOutputBoundary;
import use_case.quiz.delete.DeleteQuizOutputData;

public class DeleteQuizPresenter implements DeleteQuizOutputBoundary {
    private DisplayQuizzesViewModel displayQuizzesViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteQuizPresenter(DisplayQuizzesViewModel displayQuizzesViewModel, ViewManagerModel viewManagerModel) {
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteQuizOutputData response) {
        //TODO: do we need a presenter for DeleteQuiz (as well as DeleteNote)?
    }

    @Override
    public void prepareFailView(String error) {
    }
}
