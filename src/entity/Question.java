package entity;

public abstract class Question {

    boolean answerDisplayed = false;
    String question;


    public abstract void displayAnswer();
    public abstract void setQuestion(String question);
    public abstract String getQuestion();

}