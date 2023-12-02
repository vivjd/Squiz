package interface_adapter.question;

import entity.Question;

/**
 * Represents the state of answering a question, including information about the question itself,
 * the user's answer, feedback, and question name.
 */
public class AnswerQuestionState {

    /**
     * The actual question object.
     */
    private Question<?> question;

    /**
     * The name or text representation of the question.
     */
    private String questionName;

    /**
     * The user's answer to the question.
     */
    private String userAnswer;

    /**
     * The feedback related to the user's answer.
     */
    private String feedback;

    /**
     * Default constructor for creating an empty AnswerQuestionState.
     */
    public AnswerQuestionState() {}

    /**
     * Sets the name or text representation of the question.
     *
     * @param questionName The name or text representation of the question.
     */
    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    /**
     * Sets the user's answer to the question.
     *
     * @param userAnswer The user's answer to the question.
     */
    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    /**
     * Sets the feedback related to the user's answer.
     *
     * @param feedback The feedback related to the user's answer.
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    /**
     * Gets the name or text representation of the question.
     *
     * @return The name or text representation of the question.
     */
    public String getQuestionName() {
        return questionName;
    }

    /**
     * Gets the user's answer to the question.
     *
     * @return The user's answer to the question.
     */
    public String getUserAnswer() {
        return userAnswer;
    }

    /**
     * Gets the feedback related to the user's answer.
     *
     * @return The feedback related to the user's answer.
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * Gets the actual question object.
     *
     * @return The actual question object.
     */
    public Question<?> getQuestion() {
        return question;
    }

    /**
     * Sets the actual question object and updates the question name based on the question.
     *
     * @param question The actual question object.
     */
    public void setQuestion(Question<?> question) {
        this.question = question;
        this.questionName = question.getQuestion();
    }

    /**
     * Returns a string representation of the AnswerQuestionState.
     *
     * @return A string representation of the AnswerQuestionState.
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
