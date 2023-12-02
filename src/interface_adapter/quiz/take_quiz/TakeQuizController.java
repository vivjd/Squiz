package interface_adapter.quiz.take_quiz;

import use_case.quiz.take_quiz.TakeQuizInputBoundary;
import use_case.quiz.take_quiz.TakeQuizInputData;

/**
 * Controller class responsible for handling user interactions related to quiz-taking.
 */
public class TakeQuizController {

    /**
     * The interactor responsible for processing quiz-taking operations.
     */
    final TakeQuizInputBoundary takeQuizInteractor;

    /**
     * Constructs a new TakeQuizController object with the specified interactor.
     *
     * @param takeQuizInteractor The interactor responsible for processing quiz-taking operations.
     */
    public TakeQuizController(TakeQuizInputBoundary takeQuizInteractor) {
        this.takeQuizInteractor = takeQuizInteractor;
    }

    /**
     * Executes the quiz-taking process with the specified quiz title.
     *
     * @param title The title of the quiz.
     */
    public void execute(String title) {
        TakeQuizInputData takeQuizInputData = new TakeQuizInputData(title);
        takeQuizInteractor.execute(takeQuizInputData);
    }

    /**
     * Starts the quiz-taking process with the specified quiz title.
     *
     * @param title The title of the quiz.
     */
    public void start(String title) {
        TakeQuizInputData takeQuizInputData = new TakeQuizInputData(title);
        takeQuizInteractor.start(takeQuizInputData);
    }

    /**
     * Moves to the next question in the quiz.
     */
    public void nextQuestion() {
        takeQuizInteractor.next();
    }
}
