package use_case.quiz.take_quiz;

import entity.Question;
import entity.Quiz;
import use_case.quiz.QuizDataAccessInterface;

import java.util.Iterator;

/**
 * The interactor class responsible for handling quiz-taking operations.
 */
public class TakeQuizInteractor implements TakeQuizInputBoundary {

    /**
     * The data access object for retrieving quiz-related data.
     */
    final QuizDataAccessInterface quizDataAccessObject;

    /**
     * The presenter for displaying the quiz-taking results.
     */
    final TakeQuizOutputBoundary takeQuizPresenter;

    /**
     * The iterator for navigating through quiz questions.
     */
    private Iterator<Question<?>> questionIterator;

    /**
     * Constructs a new TakeQuizInteractor object with the specified dependencies.
     *
     * @param quizDataAccessObject The data access object for retrieving quiz-related data.
     * @param takeQuizPresenter    The presenter for displaying the quiz-taking results.
     */
    public TakeQuizInteractor(QuizDataAccessInterface quizDataAccessObject, TakeQuizOutputBoundary takeQuizPresenter) {
        this.quizDataAccessObject = quizDataAccessObject;
        this.takeQuizPresenter = takeQuizPresenter;
    }

    /**
     * Starts the quiz-taking process based on the provided input data.
     *
     * @param takeQuizInputData The input data containing information to start the quiz.
     */
    @Override
    public void start(TakeQuizInputData takeQuizInputData) {
        Quiz quiz = quizDataAccessObject.getQuiz(takeQuizInputData.getTitle());
        TakeQuizOutputData outputData = new TakeQuizOutputData(quiz);

        takeQuizPresenter.prepareStartSuccessView(outputData);
    }

    /**
     * Executes the quiz-taking process based on the provided input data.
     *
     * @param takeQuizInputData The input data containing information to execute the quiz.
     */
    @Override
    public void execute(TakeQuizInputData takeQuizInputData) {
        TakeQuizOutputData outputData = new TakeQuizOutputData();

        takeQuizPresenter.prepareExecuteSuccessView(outputData);
    }

    /**
     * Moves to the next question in the quiz.
     */
    @Override
    public void next() {
//        Question<?> nextQuestion = questionIterator.next();
        TakeQuizOutputData outputData = new TakeQuizOutputData();

        takeQuizPresenter.prepareNextSuccessView(outputData);
    }
}
