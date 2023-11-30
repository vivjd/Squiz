package interface_adapter.quiz.delete;

import org.bson.types.ObjectId;
import use_case.quiz.delete.DeleteQuizInputBoundary;
import use_case.quiz.delete.DeleteQuizInputData;
/**
 * The {@code DeleteQuizController} class serves as the controller for deleting quizzes from the database.
 * It interacts with the use case through the {@link DeleteQuizInputBoundary} interface.
 * This class receives requests to delete a quiz and delegates the operation to the corresponding
 * use case interactor.
 *
 */
public class DeleteQuizController {
    final DeleteQuizInputBoundary deleteQuizInteractor;

    /**
     * Constructs a new {@code DeleteQuizController} with the specified delete quiz interactor.
     *
     * @param deleteQuizInteractor The interactor for deleting quizzes.
     */
    public DeleteQuizController(DeleteQuizInputBoundary deleteQuizInteractor) {
        this.deleteQuizInteractor = deleteQuizInteractor;
    }

    /**
     * Executes the delete quiz operation based on the provided quiz identifier.
     *
     * @param quizId The unique identifier of the quiz to be deleted.
     */
    public void execute(ObjectId quizId){
        DeleteQuizInputData deleteQuizInputData = new DeleteQuizInputData(quizId);
        deleteQuizInteractor.execute(deleteQuizInputData);
    }
}
