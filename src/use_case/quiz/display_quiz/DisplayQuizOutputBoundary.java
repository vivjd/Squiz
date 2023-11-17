package use_case.quiz;

public interface DisplayQuizOutputBoundary {
    void prepareSuccessView(DisplayQuizOutputData quiz);
    void prepareFailView(String error);
}
