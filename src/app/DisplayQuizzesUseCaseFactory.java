package app;

import interface_adapter.ViewManagerModel;

import interface_adapter.note.NoteViewModel;
import interface_adapter.note.back.BackController;
import interface_adapter.note.back.BackPresenter;

import interface_adapter.question.QuestionViewModel;
import interface_adapter.quiz.delete.DeleteQuizController;
import interface_adapter.quiz.delete.DeleteQuizPresenter;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesPresenter;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import use_case.quiz.QuizDataAccessInterface;
import use_case.quiz.delete.DeleteQuizInputBoundary;
import use_case.quiz.delete.DeleteQuizInteractor;
import use_case.quiz.delete.DeleteQuizOutputBoundary;
import use_case.quiz.display.DisplayQuizzesInputBoundary;
import use_case.quiz.display.DisplayQuizzesInteractor;
import use_case.quiz.display.DisplayQuizzesOutputBoundary;
import view.DisplayQuizzesView;

public class DisplayQuizzesUseCaseFactory {
    private DisplayQuizzesUseCaseFactory () {}

    public static DisplayQuizzesView create(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            TakeQuizViewModel takeQuizViewModel,
            QuestionViewModel questionViewModel,
            NoteViewModel noteViewModel)

 {
     DeleteQuizController deleteQuizController = createDeleteQuizUseCase(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        DisplayQuizzesController quizzesController= createDisplayQuizzesUseCase(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        TakeQuizController takeQuizController = TakeQuizUseCaseFactory.createTakeQuizController(viewManagerModel, takeQuizViewModel, quizDataAccessObject, questionViewModel);
        BackPresenter backPresenter = new BackPresenter(noteViewModel, viewManagerModel);
        BackController backController = new BackController(backPresenter);
        return new DisplayQuizzesView(displayQuizzesViewModel, quizzesController, takeQuizController, takeQuizViewModel, deleteQuizController,backController);

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
            DisplayQuizzesViewModel displayQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject
    ){
        DeleteQuizOutputBoundary deleteQuizOutputBoundary = new DeleteQuizPresenter(displayQuizViewModel, viewManagerModel);

        DeleteQuizInputBoundary deleteQuizInteractor = new DeleteQuizInteractor(quizDataAccessObject, deleteQuizOutputBoundary);

        return new DeleteQuizController(deleteQuizInteractor);
    }

}
