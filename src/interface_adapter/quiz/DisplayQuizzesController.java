package interface_adapter.quiz;

import use_case.quiz.DisplayQuizzesInputBoundary;

public class DisplayQuizzesController {

    final DisplayQuizzesInputBoundary displayQuizUseCaseInteractor;


    public DisplayQuizzesController(DisplayQuizzesInputBoundary displayQuizUseCaseInteractor) {
        this.displayQuizUseCaseInteractor = displayQuizUseCaseInteractor;
    }

    public void execute(){
        this.displayQuizUseCaseInteractor.execute();
    }
}
