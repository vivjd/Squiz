package use_case.quiz.generate;

/**
 * The GenerateQuizInputBoundary interface defines the contract for classes responsible for executing
 * the quiz generation process based on user input.
 *
 * Implementing classes must provide an implementation for the {@code execute} method, which takes
 * a {@code GenerateQuizInputData} object containing user-specific information and performs the quiz
 * generation accordingly.
 */
public interface GenerateQuizInputBoundary {
    /**
     * Executes the quiz generation process based on user input.
     *
     * @param generateQuizInputData The input data containing user-specific information.
     * @throws Exception If an error occurs during the quiz generation process.
     */
    void execute(GenerateQuizInputData generateQuizInputData) throws Exception;
}
