package use_case.quiz;

public interface GenerateQuizOutputBoundary {
    void prepareSuccessView(String quiz);
    void prepareFailView(String error);
}
