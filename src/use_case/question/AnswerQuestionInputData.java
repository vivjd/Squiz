package use_case.question;

import entity.Question;

/**
 * The {@code AnswerQuestionInputData} class represents the input data required for answering a question.
 * It contains the user's answer and the question that the user has answered.
 */
public class AnswerQuestionInputData {
    private final String userAnswer;
    private final Question<?> question;

    /**
     * Constructs an {@code AnswerQuestionInputData} instance with the specified user answer and question.
     *
     * @param userAnswer The user's answer to the question.
     * @param question   The question that the user has answered.
     */
    public AnswerQuestionInputData(String userAnswer, Question<?> question){
        this.userAnswer = userAnswer;
        this.question = question;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public Question<?> getQuestion() {
        return question;
    }
}
