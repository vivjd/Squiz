package use_case.quiz.delete;

/**
 * The {@code DeleteQuizInputBoundary} interface defines the boundary for the input side of the
 * use case for deleting a quiz. It declares a method for executing the deletion based on
 * the provided input data.
 */
public interface DeleteQuizInputBoundary {
    void execute(DeleteQuizInputData deleteQuizInputData);
}
