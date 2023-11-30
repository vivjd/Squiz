package interface_adapter.question;

import entity.Question;

public class AnswerQuestionState {

    private Question<?> question;
    private String questionName;
    private String userAnswer;
    private String feedback;

    public AnswerQuestionState(){

    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public void setUserAnswer(String userAnswer) {
        this.userAnswer = userAnswer;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getQuestionName() {
        return questionName;
    }

    public String getUserAnswer() {
        return userAnswer;
    }

    public String getFeedback() {
        return feedback;
    }

    @Override
    public String toString() {
        return "AnswerQuestionState{" +
                "questionName='" + questionName + '\'' +
                ", userAnswer='" + userAnswer + '\'' +
                ", feedback='" + feedback + '\'' +
                '}';
    }

    public Question<?> getQuestion() {
        return question;
    }

    public void setQuestion(Question<?> question) {
        this.question = question;
        this.questionName = question.getQuestion();
    }
}
