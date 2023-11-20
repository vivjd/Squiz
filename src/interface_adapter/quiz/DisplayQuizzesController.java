package interface_adapter.quiz;

import use_case.quiz.DisplayQuizzesInputBoundary;

public class DisplayQuizzesController {

    // TODO: put back final

    final DisplayQuizzesInputBoundary displayQuizUseCaseInteractor;


    public DisplayQuizzesController(DisplayQuizzesInputBoundary displayQuizUseCaseInteractor) {
        this.displayQuizUseCaseInteractor = displayQuizUseCaseInteractor;
    }

    public DisplayQuizzesController() {}

    public void execute(){
        this.displayQuizUseCaseInteractor.execute();
    }
}
