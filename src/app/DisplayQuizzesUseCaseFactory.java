package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.delete.DeleteQuizController;
import interface_adapter.quiz.delete.DeleteQuizPresenter;
import interface_adapter.quiz.delete.DeleteQuizViewModel;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesPresenter;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import use_case.quiz.delete.DeleteQuizInputBoundary;
import use_case.quiz.delete.DeleteQuizInteractor;
import use_case.quiz.delete.DeleteQuizOutputBoundary;
import use_case.quiz.display.DisplayQuizzesInputBoundary;
import use_case.quiz.display.DisplayQuizzesInteractor;
import use_case.quiz.display.DisplayQuizzesOutputBoundary;
import use_case.quiz.QuizDataAccessInterface;
import view.DisplayQuizzesView;

public class DisplayQuizzesUseCaseFactory {
    private DisplayQuizzesUseCaseFactory () {}

    public static DisplayQuizzesView create(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            DeleteQuizViewModel deleteQuizViewModel) {

        DisplayQuizzesController quizzesController= createDisplayQuizzesUseCase(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        DeleteQuizController deleteQuizController = createDeleteQuizUseCase(viewManagerModel, deleteQuizViewModel, quizDataAccessObject);
        return new DisplayQuizzesView(displayQuizzesViewModel, quizzesController, deleteQuizController);
    }

    private static DisplayQuizzesController createDisplayQuizzesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject){
        DisplayQuizzesOutputBoundary displayQuizzesOutputBoundary = new DisplayQuizzesPresenter(displayQuizzesViewModel, viewManagerModel);

        DisplayQuizzesInputBoundary displayQuizzesInteractor = new DisplayQuizzesInteractor(quizDataAccessObject, displayQuizzesOutputBoundary);

        return new DisplayQuizzesController(displayQuizzesInteractor);
    }

    private static DeleteQuizController createDeleteQuizUseCase(
            ViewManagerModel viewManagerModel,
            DeleteQuizViewModel deleteQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject
    ){
        DeleteQuizOutputBoundary deleteQuizOutputBoundary = new DeleteQuizPresenter(deleteQuizViewModel, viewManagerModel);

        DeleteQuizInputBoundary deleteQuizInteractor = new DeleteQuizInteractor(quizDataAccessObject, deleteQuizOutputBoundary);

        return new DeleteQuizController(deleteQuizInteractor);
    }
}
