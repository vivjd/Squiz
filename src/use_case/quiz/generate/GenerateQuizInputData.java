package use_case.quiz.generate;

/**
 * The GenerateQuizInputData class represents input data for the quiz generation process.
 * It contains information such as the user's note and the title of the generated quiz.
 */
public class GenerateQuizInputData {
    private String note;
    private String title;

    /**
     * Constructs a GenerateQuizInputData object with the specified note and title.
     *
     * @param note  The user's note, used as input for quiz generation.
     * @param title The title of the generated quiz.
     */
    public GenerateQuizInputData(String note, String title){
        this.note = note;
        this.title = title;
    }

    /**
     * Gets the title of the generated quiz.
     *
     * @return The title of the quiz.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the user's note used as input for quiz generation.
     *
     * @return The user's note.
     */
    public String getNote() {
        return this.note;
    }

    /**
     * Sets the title of the generated quiz.
     *
     * @param title The new title for the quiz.
     */
    public void setTitle(String title) {
        this.title = title;
    }

}
