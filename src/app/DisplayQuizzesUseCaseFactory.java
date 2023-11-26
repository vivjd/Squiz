package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.quiz.display_quizzes.DisplayQuizzesController;
import interface_adapter.quiz.display_quizzes.DisplayQuizzesPresenter;
import interface_adapter.quiz.display_quizzes.DisplayQuizzesViewModel;
import use_case.quiz.QuizDataAccessInterface;
import use_case.quiz.display_quizzes.DisplayQuizzesInputBoundary;
import use_case.quiz.display_quizzes.DisplayQuizzesInteractor;
import use_case.quiz.display_quizzes.DisplayQuizzesOutputBoundary;
import view.DisplayQuizzesView;

public class DisplayQuizzesUseCaseFactory {
    private DisplayQuizzesUseCaseFactory () {}

    public static DisplayQuizzesView create(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject) {

        DisplayQuizzesController quizzesController= createDisplayQuizzesUseCase(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        return new DisplayQuizzesView(displayQuizzesViewModel, quizzesController);
    }

    private static DisplayQuizzesController createDisplayQuizzesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject){
        DisplayQuizzesOutputBoundary displayQuizzesOutputBoundary = new DisplayQuizzesPresenter(displayQuizzesViewModel, viewManagerModel);

        DisplayQuizzesInputBoundary displayQuizzesInteractor = new DisplayQuizzesInteractor(quizDataAccessObject, displayQuizzesOutputBoundary);

        return new DisplayQuizzesController(displayQuizzesInteractor);
    }


}
