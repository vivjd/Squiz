package use_case.quiz.delete;

import entity.Quiz;
import use_case.quiz.QuizDataAccessInterface;

/**
 * The {@code DeleteQuizInteractor} class serves as an intermediary between the application's use case layer
 * and the data access layer for deleting quizzes. It implements the {@code DeleteQuizInputBoundary} interface.
 *
 * This interactor is responsible for executing the deletion of a quiz, interacting with the
 * {@code QuizDataAccessInterface} to retrieve and delete the quiz from the underlying data source.
 * Upon successful deletion, it prepares the output data and communicates with the {@code DeleteQuizOutputBoundary}
 * for presentation purposes.
 */
public class DeleteQuizInteractor implements DeleteQuizInputBoundary{
    final QuizDataAccessInterface quizDataAccessObject;
    final DeleteQuizOutputBoundary deleteQuizPresenter;

    /**
     * Constructs a new {@code DeleteQuizInteractor} with the specified dependencies.
     *
     * @param quizDataAccessObject The data access object for quizzes.
     * @param deleteQuizOutputBoundary The presenter for handling the output of the delete operation.
     */
    public DeleteQuizInteractor(QuizDataAccessInterface quizDataAccessObject, DeleteQuizOutputBoundary deleteQuizOutputBoundary) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.deleteQuizPresenter = deleteQuizOutputBoundary;
    }

    /**
     * Executes the delete operation for a quiz based on the input data.
     * Retrieves the quiz from the data access object using its identifier,
     * deletes the quiz, and prepares the output data for successful deletion.
     * Communicates with the presenter to handle the view for successful deletion.
     *
     * @param deleteQuizInputData The input data for the delete operation.
     * @throws RuntimeException If an exception occurs during the delete operation.
     */

    @Override
    public void execute(DeleteQuizInputData deleteQuizInputData) {
        try {
            Quiz targetQuiz = quizDataAccessObject.getQuizById(deleteQuizInputData.getQuizId());
            quizDataAccessObject.deleteQuizById(deleteQuizInputData.getQuizId());
            DeleteQuizOutputData deleteQuizOutputData = new DeleteQuizOutputData(targetQuiz.getTitle(), targetQuiz.getQuizLength());
            deleteQuizPresenter.prepareSuccessView(deleteQuizOutputData);
        } catch (Exception e) {
            //TODO: is there some other exception we haven't considered?
            throw new RuntimeException(e);
        }
    }
}
