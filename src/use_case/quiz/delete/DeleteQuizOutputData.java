package use_case.quiz.delete;

/**
 * The {@code DeleteQuizOutputData} class represents the output data for a deleted quiz.
 * It encapsulates information about the deleted quiz, including its name and length.
 *
 * This class is reserved for future implementations but is currently not used.
 */
public class DeleteQuizOutputData {
    private String quizName;
    private int quizLength;

    /**
     * Constructs a new {@code DeleteQuizOutputData} instance with the specified quiz name and length.
     *
     * @param quizName   The name of the deleted quiz.
     * @param quizLength The length of the deleted quiz.
     */
    public DeleteQuizOutputData(String quizName, int quizLength) {
        this.quizName = quizName;
        this.quizLength = quizLength;
    }

    /**
     * Gets the name of the deleted quiz.
     *
     * @return The name of the deleted quiz.
     */
    public String getQuizName() {
        return quizName;
    }

    /**
     * Gets the length of the deleted quiz.
     *
     * @return The length of the deleted quiz.
     */
    public int getQuizLength() {
        return quizLength;
    }
}
