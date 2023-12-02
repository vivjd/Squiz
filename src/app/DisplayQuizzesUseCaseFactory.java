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

/**
 * The DisplayQuizzesUseCaseFactory class is responsible for creating and initializing the components
 * necessary for the DisplayQuizzes feature, including the DisplayQuizzesView, DisplayQuizzesController,
 * TakeQuizController, DeleteQuizController, and BackController. It encapsulates the instantiation of controllers
 * and associated input and output boundaries, facilitating the separation of concerns in the architecture.
 */
public class DisplayQuizzesUseCaseFactory {

    /**
     * Private constructor to prevent instantiation of the factory class.
     */
    private DisplayQuizzesUseCaseFactory () {}

    /**
     * Creates an instance of the DisplayQuizzesView by initializing the required components,
     * such as the DisplayQuizzesController, TakeQuizController, DeleteQuizController, and BackController.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param displayQuizzesViewModel    The DisplayQuizzesViewModel representing the data for displaying quizzes.
     * @param quizDataAccessObject       The QuizDataAccessInterface for accessing quiz-related data.
     * @param takeQuizViewModel          The TakeQuizViewModel representing the data for taking a quiz.
     * @param questionViewModel          The QuestionViewModel representing the data for a quiz question.
     * @param noteViewModel              The NoteViewModel representing the data for an individual note.
     * @return The created DisplayQuizzesView instance.
     */
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

    /**
     * Creates an instance of the DisplayQuizzesController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param displayQuizzesViewModel    The DisplayQuizzesViewModel representing the data for displaying quizzes.
     * @param quizDataAccessObject       The QuizDataAccessInterface for accessing quiz-related data.
     * @return The created DisplayQuizzesController instance.
     */
    private static DisplayQuizzesController createDisplayQuizzesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject){
        DisplayQuizzesOutputBoundary displayQuizzesOutputBoundary = new DisplayQuizzesPresenter(displayQuizzesViewModel, viewManagerModel);

        DisplayQuizzesInputBoundary displayQuizzesInteractor = new DisplayQuizzesInteractor(quizDataAccessObject, displayQuizzesOutputBoundary);

        return new DisplayQuizzesController(displayQuizzesInteractor);
    }

    /**
     * Creates an instance of the DeleteQuizController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param displayQuizViewModel       The DisplayQuizzesViewModel representing the data for displaying quizzes.
     * @param quizDataAccessObject       The QuizDataAccessInterface for accessing quiz-related data.
     * @return The created DeleteQuizController instance.
     */
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
