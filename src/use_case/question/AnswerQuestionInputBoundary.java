package use_case.question;

/**
 * The {@code AnswerQuestionInputBoundary} interface defines the contract for components responsible
 * for handling user input related to answering questions within the application. Classes that implement
 * this interface are expected to provide an execution method to process the user's answer to a specific
 * question based on the input data provided.
 */
public interface AnswerQuestionInputBoundary {
    void execute(AnswerQuestionInputData answerQuestionInputData);
}
