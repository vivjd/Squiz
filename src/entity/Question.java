package entity;

public abstract class Question {

    boolean answerDisplayed = false;
    String question;
    String correctAnswer;

    public void displayAnswer(){}
    public void setQuestion(String question){}
    public String getQuestion(){
        return this.question;
    }
    public void setCorrectAnswer(){}
    public String getCorrectAnswer(){
        return this.correctAnswer;
    }
}