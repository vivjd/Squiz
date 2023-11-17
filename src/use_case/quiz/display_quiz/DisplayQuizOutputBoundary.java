package use_case.quiz.display_quiz;

public interface DisplayQuizOutputBoundary {
    void prepareSuccessView(DisplayQuizOutputData quiz);
    void prepareFailView(String error);
}
