package interface_adapter.question;

import entity.Question;

/**
 * The {@code AnswerQuestionState} class represents the state of the answer question view,
 * encapsulating information about the current question, user's answer, and feedback.
 * It facilitates communication between the answer question presenter and the view model.
 */
public class AnswerQuestionState {

    /**
     * The question being presented in the answer question view.
     */
    private Question<?> question;

    /**
     * The name of the current question.
     */
    private String questionName;

    /**
     * The user's answer to the current question.
     */
    private String userAnswer;

    /**
     * The feedback received after answering the question.
     */
    private String feedback;

    /**
     * Constructs an empty {@code AnswerQuestionState}.
     */
    public AnswerQuestionState() {
        // Default constructor
    }

    /**
     * Sets the name of the current question.
     *
     * @param questionName The name of the current question.
     */
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    /**
     * Sets the user's answer to the current question.
     *
     * @param userAnswer The user's answer to the current question.
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * Sets the feedback received after answering the question.
     *
     * @param feedback The feedback received after answering the question.
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Gets the name of the current question.
     *
     * @return The name of the current question.
     */
    public String getQuestionName() {
        return questionName;
    }

    /**
     * Gets the user's answer to the current question.
     *
     * @return The user's answer to the current question.
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     * Gets the feedback received after answering the question.
     *
     * @return The feedback received after answering the question.
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Gets the current question.
     *
     * @return The current question.
     */
    public Question<?> getQuestion() {
        return question;
    }

    /**
     * Sets the current question and updates the question name accordingly.
     *
     * @param question The current question.
     */
    public void setQuestion(Question<?> question) {
        this.question = question;
        this.questionName = question.getQuestion();
    }

    /**
     * Returns a string representation of the {@code AnswerQuestionState} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "AnswerQuestionState{" +
                "questionName='" + questionName + '\'' +
                ", userAnswer='" + userAnswer + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
