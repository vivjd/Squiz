package use_case.question;

import entity.Question;

public class AnswerQuestionInputData {
    private final String userAnswer;
    private final Question<?> question;

    public String getUserAnswer() {
        return userAnswer;
    }

    public AnswerQuestionInputData(String userAnswer, Question<?> question){
        this.userAnswer = userAnswer;
        this.question = question;
    }

    public Question<?> getQuestion() {
        return question;
    }
}
