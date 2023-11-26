package use_case.quiz.delete;

public interface DeleteQuizOutputBoundary {
    void prepareSuccessView(DeleteQuizOutputData deleteQuizOutputData);

    void prepareFailView(String error);
}
