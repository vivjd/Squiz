package use_case.quiz.take_quiz;

public interface TakeQuizOutputBoundary {

    void prepareExecuteSuccessView(TakeQuizOutputData takeQuizOutputData);
    void prepareStartSuccessView(TakeQuizOutputData takeQuizOutputData);

    void prepareFailView(String error);


}
