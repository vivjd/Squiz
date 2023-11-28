package app;

import interface_adapter.ViewManagerModel;

import interface_adapter.question.QuestionViewModel;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesPresenter;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizPresenter;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import use_case.quiz.display.DisplayQuizzesInputBoundary;
import use_case.quiz.display.DisplayQuizzesInteractor;
import use_case.quiz.display.DisplayQuizzesOutputBoundary;
import use_case.quiz.QuizDataAccessInterface;
import use_case.quiz.take_quiz.TakeQuizInputBoundary;
import use_case.quiz.take_quiz.TakeQuizInputData;
import use_case.quiz.take_quiz.TakeQuizInteractor;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;
import view.DisplayQuizzesView;

public class DisplayQuizzesUseCaseFactory {
    private DisplayQuizzesUseCaseFactory () {}

    public static DisplayQuizzesView create(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            TakeQuizViewModel takeQuizViewModel,
            QuestionViewModel questionViewModel) {

        DisplayQuizzesController quizzesController= createDisplayQuizzesUseCase(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        TakeQuizController takeQuizController = TakeQuizUseCaseFactory.createTakeQuizController(viewManagerModel, takeQuizViewModel, quizDataAccessObject, questionViewModel);
        return new DisplayQuizzesView(displayQuizzesViewModel, quizzesController, takeQuizController);
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
