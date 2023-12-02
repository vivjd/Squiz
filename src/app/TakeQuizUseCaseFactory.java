package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.question.QuestionViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizPresenter;
import view.AnswerQuestionView;
import view.TakeQuizView;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import use_case.quiz.QuizDataAccessInterface;
import use_case.quiz.take_quiz.TakeQuizInputBoundary;
import use_case.quiz.take_quiz.TakeQuizInteractor;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;

/**
 * The TakeQuizUseCaseFactory class is responsible for creating and initializing the components
 * necessary for the TakeQuiz feature, including the TakeQuizView and TakeQuizController. It encapsulates
 * the instantiation of controllers and associated input and output boundaries, facilitating the separation
 * of concerns in the architecture.
 */
public class TakeQuizUseCaseFactory {

    private TakeQuizUseCaseFactory() {}


    /**
     * Creates an instance of the TakeQuizView by initializing the required components,
     * such as the TakeQuizController and AnswerQuestionView.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param takeQuizViewModel          The TakeQuizViewModel representing the data for taking a quiz.
     * @param quizDataAccessObject       The QuizDataAccessInterface for accessing quiz-related data.
     * @param answerQuestionView         The AnswerQuestionView responsible for answering quiz questions.
     * @param questionViewModel          The QuestionViewModel representing the data for a quiz question.
     * @return The created TakeQuizView instance.
     */
    public static TakeQuizView create(
            ViewManagerModel viewManagerModel,
            TakeQuizViewModel takeQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            AnswerQuestionView answerQuestionView,
            QuestionViewModel questionViewModel
    ) {
        TakeQuizController takeQuizController = createTakeQuizController(viewManagerModel, takeQuizViewModel, quizDataAccessObject, questionViewModel);
        return new TakeQuizView(takeQuizViewModel, takeQuizController, answerQuestionView);
    }

    /**
     * Creates an instance of the TakeQuizController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param takeQuizViewModel          The TakeQuizViewModel representing the data for taking a quiz.
     * @param quizDataAccessObject       The QuizDataAccessInterface for accessing quiz-related data.
     * @param questionViewModel          The QuestionViewModel representing the data for a quiz question.
     * @return The created TakeQuizController instance.
     */
    public static TakeQuizController createTakeQuizController(
            ViewManagerModel viewManagerModel,
            TakeQuizViewModel takeQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            QuestionViewModel questionViewModel
    ) {
        TakeQuizOutputBoundary takeQuizOutputBoundary = new TakeQuizPresenter(takeQuizViewModel, viewManagerModel, questionViewModel);
        TakeQuizInputBoundary takeQuizInputBoundary = new TakeQuizInteractor(quizDataAccessObject, takeQuizOutputBoundary);

        return new TakeQuizController(takeQuizInputBoundary);
    }
}
