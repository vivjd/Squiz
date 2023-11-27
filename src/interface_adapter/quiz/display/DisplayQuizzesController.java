package interface_adapter.quiz.display;

import use_case.quiz.display.DisplayQuizzesInputBoundary;

/**
 * The {@code DisplayQuizzesController} class serves as the controller for the "Display Quizzes" use case.
 *
 * @see DisplayQuizzesInputBoundary
 */
public class DisplayQuizzesController {

    final DisplayQuizzesInputBoundary displayQuizUseCaseInteractor;

    public DisplayQuizzesController(DisplayQuizzesInputBoundary displayQuizUseCaseInteractor) {
        this.displayQuizUseCaseInteractor = displayQuizUseCaseInteractor;
    }

    /**
     * Executes the "Display Quizzes" use case by invoking the corresponding method
     * on the {@link DisplayQuizzesInputBoundary} instance.
     */
    public void execute(){
        this.displayQuizUseCaseInteractor.execute();
    }
}
