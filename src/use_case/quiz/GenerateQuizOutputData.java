package use_case.quiz;

/**
 * The GenerateQuizOutputData class represents output data for the quiz generation process.
 * It encapsulates a message indicating the status of the quiz generation.
 */
public class GenerateQuizOutputData {
    String msg;

    /**
     * Constructs a GenerateQuizOutputData object with a message indicating the successful generation of a quiz.
     *
     * @param title The title of the generated quiz.
     */
    public GenerateQuizOutputData(String title) {
        this.msg = "Quiz is generated. Title: " + title + " (QUIZ)";
    }
}
