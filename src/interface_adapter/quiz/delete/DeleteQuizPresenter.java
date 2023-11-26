package interface_adapter.quiz.delete;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import use_case.quiz.delete.DeleteQuizOutputBoundary;
import use_case.quiz.delete.DeleteQuizOutputData;

import javax.swing.*;

public class DeleteQuizPresenter implements DeleteQuizOutputBoundary {
    private DisplayQuizzesViewModel displayQuizzesViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteQuizPresenter(DisplayQuizzesViewModel displayQuizzesViewModel, ViewManagerModel viewManagerModel) {
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteQuizOutputData response) {
        JOptionPane.showMessageDialog(null, response.getQuizName());
    }

    @Override
    public void prepareFailView(String error) {

    }
}
