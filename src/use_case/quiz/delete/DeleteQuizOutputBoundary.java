package use_case.quiz.delete;

/**
 * The {@code DeleteQuizOutputBoundary} interface defines the contract for presenting the results
 * of the delete quiz operation. Classes implementing this interface are responsible for preparing
 * views based on the outcome of the deletion.
 */
public interface DeleteQuizOutputBoundary {
    void prepareSuccessView(DeleteQuizOutputData deleteQuizOutputData);

    void prepareFailView(String error);
}
