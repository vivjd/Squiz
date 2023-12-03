package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionPresenter;
import interface_adapter.question.QuestionViewModel;
import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInteractor;
import use_case.question.AnswerQuestionOutputBoundary;
import use_case.question.QuestionDataAccessInterface;
import view.AnswerQuestionView;

/**
 * The AnswerQuestionUseCaseFactory class is responsible for creating and initializing the components
 * necessary for the AnswerQuestion feature, including the AnswerQuestionView and AnswerQuestionController.
 * It encapsulates the instantiation of the controller and the associated input and output boundaries,
 * facilitating the separation of concerns in the architecture.
 */
public class AnswerQuestionUseCaseFactory {

    /**
     * Private constructor to prevent instantiation of the factory class.
     */
    private AnswerQuestionUseCaseFactory() {}

    /**
     * Creates an instance of the AnswerQuestionView by initializing the required components,
     * such as the AnswerQuestionController, QuestionViewModel, and ViewManagerModel.
     *
     * @param viewManagerModel            The ViewManagerModel responsible for managing views in the application.
     * @param questionViewModel           The QuestionViewModel representing the data for the question.
     * @param questionDataAccessObject The QuestionDataAccessInterface for accessing question-related data.
     * @return The created AnswerQuestionView instance.
     */
    public static AnswerQuestionView create(
            ViewManagerModel viewManagerModel,
            QuestionViewModel questionViewModel,
            QuestionDataAccessInterface questionDataAccessObject) {
        AnswerQuestionController answerQuestionController = createAnswerQuestionController(viewManagerModel, questionViewModel, questionDataAccessObject);
        return new AnswerQuestionView(questionViewModel, answerQuestionController);
    }

    /**
     * Creates an instance of the AnswerQuestionController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel            The ViewManagerModel responsible for managing views in the application.
     * @param questionViewModel           The QuestionViewModel representing the data for the question.
     * @param questionDataAccessObject The QuestionDataAccessInterface for accessing question-related data.
     * @return The created AnswerQuestionController instance.
     */
    public static AnswerQuestionController createAnswerQuestionController(
            ViewManagerModel viewManagerModel,
            QuestionViewModel questionViewModel,
            QuestionDataAccessInterface questionDataAccessObject)
    {
        AnswerQuestionOutputBoundary answerQuestionOutputBoundary = new AnswerQuestionPresenter(questionViewModel, viewManagerModel);
        AnswerQuestionInputBoundary answerQuestionInputBoundary = new AnswerQuestionInteractor(questionDataAccessObject, answerQuestionOutputBoundary);

        return new AnswerQuestionController(answerQuestionInputBoundary);

    }

}
