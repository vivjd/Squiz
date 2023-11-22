package entity;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.HashMap;

@BsonDiscriminator
public class MultipleChoiceQuestion extends Question {

    @BsonProperty("answerOptions")
    private HashMap<Integer, String> answerOptions;

    @BsonProperty("correctAnswerIndex")
    private int correctAnswerIndex;

    @BsonProperty("question")
    private String question;

    public MultipleChoiceQuestion() {
    }

    public MultipleChoiceQuestion(@BsonProperty("question") String question,
                                  @BsonProperty("answerOptions") HashMap<Integer, String> answerOptions,
                                  @BsonProperty("correctAnswerIndex") int correctAnswerIndex) {
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return this.question;
    }


    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    public void setQuestion(String question) {
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

    public void setCorrectAnswerIndex(int correctAnswer) {
        this.correctAnswerIndex = correctAnswer;
    }
}