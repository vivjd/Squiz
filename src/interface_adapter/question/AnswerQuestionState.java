package interface_adapter.question;

public class AnswerQuestionState {
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
}
