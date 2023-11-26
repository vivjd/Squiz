package interface_adapter.quiz.display_quizzes;

import use_case.quiz.display_quizzes.DisplayQuizzesInputBoundary;

public class DisplayQuizzesController {

    final DisplayQuizzesInputBoundary displayQuizUseCaseInteractor;


    public DisplayQuizzesController(DisplayQuizzesInputBoundary displayQuizUseCaseInteractor) {
        this.displayQuizUseCaseInteractor = displayQuizUseCaseInteractor;
    }

    public void execute() {
        this.displayQuizUseCaseInteractor.execute();
    }
}
