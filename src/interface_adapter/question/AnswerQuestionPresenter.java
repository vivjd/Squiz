package interface_adapter.question;

import interface_adapter.ViewManagerModel;
import use_case.question.AnswerQuestionOutputBoundary;
import use_case.question.AnswerQuestionOutputData;

/**
 * The {@code AnswerQuestionPresenter} class serves as an adapter responsible for preparing
 * the view model based on the output of the answer question use case. It implements the
 * {@link AnswerQuestionOutputBoundary} interface to handle success and failure scenarios.
 */
public class AnswerQuestionPresenter implements AnswerQuestionOutputBoundary {
    private QuestionViewModel questionViewModel;

    private ViewManagerModel viewManagerModel;

    /**
     * Constructs an {@code AnswerQuestionPresenter} with the specified view model and view manager model.
     *
     * @param questionViewModel The view model for managing the state of the answer question view.
     * @param viewManagerModel  The model responsible for managing the overall state of the application's views.
     */
    public AnswerQuestionPresenter(QuestionViewModel questionViewModel, ViewManagerModel viewManagerModel) {
        this.questionViewModel = questionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful response to answering a question by updating the view model state.
     *
     * @param userFeedback The feedback data containing information about the answer.
     */
    @Override
    public void prepareSuccessView(AnswerQuestionOutputData userFeedback) {
        AnswerQuestionState questionState = questionViewModel.getState();
        questionState.setFeedback(userFeedback.getAnswerFeedback());
    }

    /**
     * Prepares the view for a failure response to answering a question. Currently, it does not handle failures.
     *
     * @param error The error message received from the answer question use case.
     */
    @Override
    public void prepareFailView(String error) {
        // Currently, failure scenarios are not handled in the view.
    }
}
