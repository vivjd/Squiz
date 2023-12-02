package interface_adapter.quiz;

import use_case.quiz.GenerateQuizOutputBoundary;

/**
 * The GenerateQuizPresenter class is responsible for presenting the results of the quiz generation process.
 */
public class GenerateQuizPresenter implements GenerateQuizOutputBoundary {

    /**
     * Constructs a GenerateQuizPresenter.
     */
    public GenerateQuizPresenter() {
        // Constructor logic, if any, can be added here.
    }

    /**
     * Prepares a success view with the given quiz information.
     *
     * @param quizInformation A string representing the generated quiz or relevant success information.
     */
    @Override
    public void prepareSuccessView(String quizInformation) {
        // Implement logic to display success view, e.g., print to console or update UI.
        System.out.println("Quiz Generation Successful: " + quizInformation);
    }

    /**
     * Prepares a fail view with the given error message.
     *
     * @param errorMessage A string representing the error or failure information.
     */
    @Override
    public void prepareFailView(String errorMessage) {
        System.err.println("Quiz Generation Failed: " + errorMessage);
    }
}
