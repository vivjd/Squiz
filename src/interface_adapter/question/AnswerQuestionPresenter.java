package interface_adapter.question;

import interface_adapter.ViewManagerModel;
import use_case.question.AnswerQuestionOutputBoundary;
import use_case.question.AnswerQuestionOutputData;

/**
 * Presenter class responsible for preparing and updating views related to answering a question.
 */
public class AnswerQuestionPresenter implements AnswerQuestionOutputBoundary {

    /**
     * The view model representing the state of the question interface.
     */
    private QuestionViewModel questionViewModel;

    /**
     * The model managing the active views in the application.
     */
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a new AnswerQuestionPresenter object with the specified dependencies.
     *
     * @param questionViewModel The view model representing the state of the question interface.
     * @param viewManagerModel  The model managing the active views in the application.
     */
    public AnswerQuestionPresenter(QuestionViewModel questionViewModel, ViewManagerModel viewManagerModel) {
        this.questionViewModel = questionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful completion of the question-answering process.
     *
     * @param userFeedback The output data containing feedback for the user's answer.
     */
    @Override
    public void prepareSuccessView(AnswerQuestionOutputData userFeedback) {
        AnswerQuestionState questionState = questionViewModel.getState();
        questionState.setFeedback(userFeedback.getAnswerFeedback());

    }

    /**
     * Prepares the view for a failed completion of the question-answering process.
     *
     * @param error The error message describing the cause of the failure.
     */
    @Override
    public void prepareFailView(String error) {
        // Implementation can be added based on the requirements.
    }
}
