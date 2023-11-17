package interface_adapter.quiz;

import use_case.quiz.display_quiz.DisplayQuizInputBoundary;

public class DisplayQuizController {
    final DisplayQuizInputBoundary displayQuizUseCaseInteractor;


    public DisplayQuizController(DisplayQuizInputBoundary displayQuizUseCaseInteractor) {
        this.displayQuizUseCaseInteractor = displayQuizUseCaseInteractor;
    }

    public void execute(){
        this.displayQuizUseCaseInteractor.execute();
    }
}
