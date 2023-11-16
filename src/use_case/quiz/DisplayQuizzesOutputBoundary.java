package use_case.quiz;

public interface DisplayQuizzesOutputBoundary {
    void prepareSuccessView(DisplayQuizzesOutputData quiz);
    void prepareFailView(String error);
}
