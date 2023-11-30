package use_case.question;

/**
 * The {@code AnswerQuestionOutputBoundary} interface defines the contract for preparing views in response to
 * the result of answering a question. Implementing classes should handle the presentation of success feedback
 * and error messages.
 */
public interface AnswerQuestionOutputBoundary {
    /**
     * Prepares the view for a successful response to answering a question by providing feedback.
     *
     * @param feedback The feedback data containing information in response to the user answer.
     */
    void prepareSuccessView(AnswerQuestionOutputData feedback);

    /**
     * Prepares the view for a failure response to answering a question by displaying an error message.
     *
     * @param error The error message to be displayed.
     */
    void prepareFailView(String error);

}
