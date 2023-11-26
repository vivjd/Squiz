package interface_adapter.quiz.take_quiz;

import interface_adapter.ViewManagerModel;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;
import use_case.quiz.take_quiz.TakeQuizOutputData;

public class TakeQuizPresenter implements TakeQuizOutputBoundary {

    private final TakeQuizViewModel quizViewModel;
    private final ViewManagerModel viewManagerModel;

    public TakeQuizPresenter(TakeQuizViewModel quizViewModel, ViewManagerModel viewManagerModel) {
        this.quizViewModel = quizViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareSuccessView(TakeQuizOutputData takeQuizOutputData) {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
