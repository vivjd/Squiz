package use_case.quiz.delete;

import org.bson.types.ObjectId;

public class DeleteQuizInputData {
    private ObjectId quizId;

    public DeleteQuizInputData(ObjectId quizId) {
        this.quizId = quizId;
    }

    public ObjectId getQuizId() {
        return quizId;
    }
}
