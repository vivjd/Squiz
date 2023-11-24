package use_case.quiz;

/**
 * The {@code DisplayQuizzesInputBoundary} interface defines the contract for the input
 * boundary of the "Display Quizzes" use case. Implementations of this interface are
 * responsible for executing the necessary actions to display quizzes to the user.
 */
public interface DisplayQuizzesInputBoundary {
    /**
     * Executes the "Display Quizzes" use case, presenting quizzes to the user.
     * The implementation of this method should include the necessary logic to
     * retrieve and display quizzes, taking into account the specific requirements
     * of the application.
     */
    void execute();
}
