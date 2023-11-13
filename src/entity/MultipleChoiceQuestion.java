package entity;
import java.util.HashMap;

public class MultipleChoiceQuestion extends Question {
    private HashMap<Integer, String> answerOptions;
    private int correctAnswerIndex;
    private String question;

    public MultipleChoiceQuestion(String question, HashMap<Integer, String> answerOptions, int correctAnswerIndex){
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }
    public String getQuestion(){
        return this.question;
    }

    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    public void setQuestion(String question){
        this.question = question;
    }
    public HashMap<Integer, String> getAnswerOptions() {
        return answerOptions;
    }
    public void setAnswerOptions(HashMap<Integer, String> ansOps) {
        this.answerOptions = ansOps;
    }
    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
    public void setCorrectAnswerIndex(int correctAnswer){
        this.correctAnswerIndex = correctAnswer;
    }
}
