package use_case.quiz.take_quiz;

import use_case.quiz.display_quiz.DisplayQuizOutputData;

public interface TakeQuizOutputBoundary {

    void prepareSuccessView(TakeQuizOutputData takeQuizOutputData);

    void prepareFailView(String error);


}
