package interface_adapter.quiz.delete;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import use_case.quiz.delete.DeleteQuizOutputBoundary;
import use_case.quiz.delete.DeleteQuizOutputData;

import javax.swing.*;

public class DeleteQuizPresenter implements DeleteQuizOutputBoundary {
    private DeleteQuizViewModel deleteQuizViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteQuizPresenter(DeleteQuizViewModel deleteQuizViewModel, ViewManagerModel viewManagerModel) {
        this.deleteQuizViewModel = deleteQuizViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(DeleteQuizOutputData response) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
