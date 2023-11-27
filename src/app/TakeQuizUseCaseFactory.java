package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizPresenter;
import view.TakeQuizView;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import use_case.quiz.QuizDataAccessInterface;
import use_case.quiz.take_quiz.TakeQuizInputBoundary;
import use_case.quiz.take_quiz.TakeQuizInteractor;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;

public class TakeQuizUseCaseFactory {

    private TakeQuizUseCaseFactory() {};

    private static TakeQuizView create(
            ViewManagerModel viewManagerModel,
            TakeQuizViewModel takeQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject
    ) {
        TakeQuizController takeQuizController= createTakeQuizController(viewManagerModel, takeQuizViewModel, quizDataAccessObject);
        return new TakeQuizView(takeQuizViewModel, takeQuizController);
    }

    private static TakeQuizController createTakeQuizController(
            ViewManagerModel viewManagerModel,
            TakeQuizViewModel takeQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject
    ) {
        TakeQuizOutputBoundary takeQuizOutputBoundary = new TakeQuizPresenter(takeQuizViewModel, viewManagerModel);
        TakeQuizInputBoundary takeQuizInputBoundary = new TakeQuizInteractor(quizDataAccessObject, takeQuizOutputBoundary);

        return new TakeQuizController(takeQuizInputBoundary);
    }
}
