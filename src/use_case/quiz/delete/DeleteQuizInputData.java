package use_case.quiz.delete;

import org.bson.types.ObjectId;

/**
 * The {@code DeleteQuizInputData} class represents the input data for deleting a quiz.
 * It encapsulates the unique identifier (ObjectId) of the quiz to be deleted.
 */
public class DeleteQuizInputData {
    private final ObjectId quizId;

    /**
     * Constructs a new {@code DeleteQuizInputData} instance with the specified quiz identifier.
     *
     * @param quizId The unique identifier of the quiz to be deleted.
     */
    public DeleteQuizInputData(ObjectId quizId) {
        this.quizId = quizId;
    }

    /**
     * Gets the unique identifier of the quiz to be deleted.
     *
     * @return The ObjectId representing the quiz to be deleted.
     */
    public ObjectId getQuizId() {
        return quizId;
    }
}
