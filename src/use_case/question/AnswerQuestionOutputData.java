package use_case.question;

/**
 * The {@code AnswerQuestionOutputData} class represents the output data generated after
 * answering a question. It encapsulates the feedback related to the answer that should be outputted to the user.
 */
public class AnswerQuestionOutputData{
    private String answerFeedback;

    /**
     * Constructs an {@code AnswerQuestionOutputData} instance with the specified answer feedback.
     *
     * @param answerFeedback The feedback regarding the answer to the question.
     */
    public AnswerQuestionOutputData(String answerFeedback){
        this.answerFeedback = answerFeedback;
    }

    /**
     * Gets the feedback regarding the answer to the question.
     *
     * @return The answer feedback.
     */
    public String getAnswerFeedback() {
        return answerFeedback;
    }

}
