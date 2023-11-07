package entity;

public abstract class Question {

    boolean answerDisplayed = false;
    String question;
    String correctAnswer;


    public abstract void displayAnswer();
    public abstract void setQuestion(String question);
    public abstract String getQuestion();g

    public abstract void setCorrectAnswer(String ans);
    public abstract String getCorrectAnswer();

}