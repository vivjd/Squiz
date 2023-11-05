package entity;
import java.util.HashMap;

class MultipleChoiceQuestion extends Question {
    private HashMap<Integer, String> answerOptions = new HashMap<>();
    private int correctAnswer;
    private String question;

    public MultipleChoiceQuestion(String question, HashMap<Integer, String> answerOptions, int correctAnswer){
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
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
    public int getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int correctAnswer){
        this.correctAnswer = correctAnswer;
    }
}
