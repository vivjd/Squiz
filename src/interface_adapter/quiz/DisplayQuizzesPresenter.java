package interface_adapter.quiz;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteViewModel;
import use_case.quiz.DisplayQuizzesOutputBoundary;
import use_case.quiz.DisplayQuizzesOutputData;

import javax.swing.*;
import java.util.Arrays;

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
        quizState.setQuizzesTable(quiz.getQuizzes());
        System.out.println(quizState.getQuizzesTable().length);

        this.displayQuizzesViewModel.setState(quizState);
        System.out.println(Arrays.deepToString(displayQuizzesViewModel.getState().getQuizzesTable()));
        displayQuizzesViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(displayQuizzesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

//        JOptionPane.showMessageDialog(null,quiz.getQuizzes());
    }

    @Override
    public void prepareFailView(String error) {
        DisplayQuizzesState quizState = displayQuizzesViewModel.getState();
        quizState.setEmptyQuizError(error);
        displayQuizzesViewModel.firePropertyChanged();
    }
}
