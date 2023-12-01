package use_case.quiz;

/**
 * The GenerateQuizOutputBoundary interface defines the contract for classes responsible for
 * preparing views in response to quiz generation outcomes.
 */
public interface GenerateQuizOutputBoundary {

    /**
     * Prepares a success view for the quiz generation.
     *
     * @param quiz A string representing the generated quiz or relevant success information.
     */
    void prepareSuccessView(String quiz);

    /**
     * Prepares a fail view for the quiz generation.
     *
     * @param error A string representing the error or failure information.
     */
    void prepareFailView(String error);
}
