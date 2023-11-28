package interface_adapter.quiz.take_quiz;

import entity.Question;
import entity.Quiz;
import interface_adapter.ViewManagerModel;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;
import use_case.quiz.take_quiz.TakeQuizOutputData;

import java.util.List;

public class TakeQuizPresenter implements TakeQuizOutputBoundary {

    private final TakeQuizViewModel takeQuizViewModel;
    private final ViewManagerModel viewManagerModel;

    public TakeQuizPresenter(TakeQuizViewModel takeQuizViewModel, ViewManagerModel viewManagerModel) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareExecuteSuccessView(TakeQuizOutputData takeQuizOutputData) {
        System.out.println(takeQuizViewModel.getState().getQuestions());
    }

    @Override
    public void prepareStartSuccessView(TakeQuizOutputData takeQuizOutputData) {
        Quiz quiz = takeQuizOutputData.getQuiz();
        List<Question<?>> questions = quiz.getQuestions();
        TakeQuizState takeQuizState = takeQuizViewModel.getState();
        takeQuizState.setQuestions(questions);
        takeQuizViewModel.setState(takeQuizState);
        takeQuizViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(takeQuizViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {

    }
}
