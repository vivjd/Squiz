package use_case.quiz.take_quiz;

public interface TakeQuizOutputBoundary {

    void prepareSuccessView(TakeQuizOutputData takeQuizOutputData);

    void prepareFailView(String error);


}
