package use_case.question;

import entity.Question;

public class AnswerQuestionInputData implements AnswerQuestionInputBoundary{
    private final String userAnswer;
    private final Question<?> question;

    public String getUserAnswer() {
        return userAnswer;
    }

    public AnswerQuestionInputData(String userAnswer, Question<?> question){
        this.userAnswer = userAnswer;
        this.question = question;
    }


    @Override
    public void execute(AnswerQuestionInputData answerQuestionInputData) {

    }

    public Question<?> getQuestion() {
        return question;
    }
}
