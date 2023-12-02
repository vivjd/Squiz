package interface_adapter.quiz.take_quiz;

import entity.Question;

import java.util.Iterator;
import java.util.List;

/**
 * Represents the state of a quiz-taking session, including information about the current question index,
 * the list of questions, and the user's score.
 */
public class TakeQuizState {

    /**
     * The index of the current question in the quiz.
     */
    private int currentQuestionIndex = 0;

    /**
     * The list of questions in the quiz.
     */
    private List<Question<?>> questions;

    /**
     * The user's score in the quiz.
     */
    private int score = 0;

    /**
     * Default constructor for creating an empty TakeQuizState.
     */
    public TakeQuizState() {}

    /**
     * Constructor for creating a TakeQuizState with a specified list of questions.
     *
     * @param questions The list of questions in the quiz.
     */
    public TakeQuizState(List<Question<?>> questions) {
        this.questions = questions;
    }

    /**
     * Gets the index of the current question in the quiz.
     *
     * @return The index of the current question.
     */
    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    /**
     * Sets the index of the current question in the quiz.
     *
     * @param currentQuestionIndex The index of the current question.
     */
    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    /**
     * Gets the list of questions in the quiz.
     *
     * @return The list of questions.
     */
    public List<Question<?>> getQuestions() {
        return questions;
    }

    /**
     * Gets an iterator over the list of questions in the quiz.
     *
     * @return An iterator over the list of questions.
     */
    public Iterator<Question<?>> getQuestionsIterator() {
        return questions.iterator();
    }

    /**
     * Sets the list of questions in the quiz.
     *
     * @param questions The list of questions.
     */
    public void setQuestions(List<Question<?>> questions) {
        this.questions = questions;
    }

    /**
     * Gets the user's score in the quiz.
     *
     * @return The user's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Sets the user's score in the quiz.
     *
     * @param score The user's score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Resets all the state variables to their initial values.
     */
    public void resetAll() {
        currentQuestionIndex = 0;
        questions = null;
        score = 0;
    }
}
