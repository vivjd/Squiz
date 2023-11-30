package use_case.quiz.display;

/**
 * The {@code DisplayQuizzesOutputBoundary} interface defines methods for preparing views
 * in response to the success or failure of displaying all quizzes.
 *
 * <p>Implementing classes are responsible for handling the presentation of quiz-related data
 * and error messages.</p>
 *
 */
public interface DisplayQuizzesOutputBoundary {
    void prepareSuccessView(DisplayQuizzesOutputData quiz);
    void prepareFailView(String error);
}
