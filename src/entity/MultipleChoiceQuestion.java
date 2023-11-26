package entity;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.HashMap;
import java.util.Map;

@BsonDiscriminator
public class MultipleChoiceQuestion extends Question<Integer> {
    private Map<Integer, String> answerOptions;

    private int correctAnswerIndex;

    @BsonProperty("question")
    private String question;


    public MultipleChoiceQuestion() {
    }

    public MultipleChoiceQuestion(@BsonProperty("question") String question,
                                  @BsonProperty("answerOptions") Map<Integer, String> answerOptions,
                                  @BsonProperty("correctAnswerIndex") int correctAnswerIndex) {

        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return this.question;
    }


    @Override
    public int checkAnswer(Object userResponse) {
        int userResponseInt = (int) userResponse;
        if (userResponseInt == correctAnswerIndex) return 1;
        return 0;
    }

    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
    public Map<Integer, String> getAnswerOptions() {

        return answerOptions;
    }

    public void setAnswerOptions(Map<Integer, String> ansOps) {
        this.answerOptions = ansOps;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(int correctAnswer) {
        this.correctAnswerIndex = correctAnswer;
    }
}