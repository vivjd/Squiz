package use_case.quiz.take_quiz;

public interface TakeQuizOutputBoundary {

    void prepareSuccessView(int score);

    void prepareFailView(String error);


}
