package entity;

public abstract class Question {

    boolean answerDisplayed = false;
    String question;
    String answer;

    public void displayAnswer(){
        this.answerDisplayed = true
    }
    public void setQuestion(){

    }
    public String getQuesiton(){
        return this.question
    }
    public void setAnswer(){

    }
    public String getAnswer(){
        return this.answer
    }
}
