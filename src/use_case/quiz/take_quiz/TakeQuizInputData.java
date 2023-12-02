package use_case.quiz.take_quiz;

/**
 * Represents the input data for taking a quiz.
 */
public class TakeQuizInputData {

    /**
     * The title of the quiz.
     */
    private final String title;

    /**
     * Constructs a new TakeQuizInputData object with the specified title.
     *
     * @param title The title of the quiz.
     */
    public TakeQuizInputData(String title) {
        this.title = title;
    }

    /**
     * Gets the title of the quiz.
     *
     * @return The title of the quiz.
     */
    public String getTitle() {
        return title;
    }
}
