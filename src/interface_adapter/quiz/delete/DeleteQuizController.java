package interface_adapter.quiz.delete;

import org.bson.types.ObjectId;
import use_case.quiz.delete.DeleteQuizInputBoundary;
import use_case.quiz.delete.DeleteQuizInputData;

public class DeleteQuizController {
    final DeleteQuizInputBoundary deleteQuizInteractor;

    public DeleteQuizController(DeleteQuizInputBoundary deleteQuizInteractor) {
        this.deleteQuizInteractor = deleteQuizInteractor;
    }

    public void execute(ObjectId quizId){
        DeleteQuizInputData deleteQuizInputData = new DeleteQuizInputData(quizId);
        deleteQuizInteractor.execute(deleteQuizInputData);
    }
}
