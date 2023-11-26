package use_case.quiz.delete;

import entity.Quiz;
import use_case.quiz.QuizDataAccessInterface;

public class DeleteQuizInteractor implements DeleteQuizInputBoundary{
    final QuizDataAccessInterface quizDataAccessObject;
    final DeleteQuizOutputBoundary deleteQuizPresenter;

    public DeleteQuizInteractor(QuizDataAccessInterface quizDataAccessObject, DeleteQuizOutputBoundary deleteQuizOutputBoundary) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.deleteQuizPresenter = deleteQuizOutputBoundary;
    }

    @Override
    public void execute(DeleteQuizInputData deleteQuizInputData) {
        try {
            Quiz targetQuiz = quizDataAccessObject.getQuizById(deleteQuizInputData.getQuizId());
            quizDataAccessObject.deleteQuizById(deleteQuizInputData.getQuizId());
            DeleteQuizOutputData deleteQuizOutputData = new DeleteQuizOutputData(targetQuiz.getTitle(), targetQuiz.getQuizLength());
            deleteQuizPresenter.prepareSuccessView(deleteQuizOutputData);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
