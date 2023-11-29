package entity;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.HashMap;
import java.util.Map;

@BsonDiscriminator
public class MultipleChoiceQuestion extends Question<String> {
    private Map<String, String> answerOptions;

    private String correctAnswerIndex;


    @BsonProperty("question")
    private String question;


    public MultipleChoiceQuestion() {
    }

    public MultipleChoiceQuestion(@BsonProperty("question") String question,

                                  @BsonProperty("answerOptions") Map<String, String> answerOptions,
                                  @BsonProperty("correctAnswerIndex") String correctAnswerIndex) {

        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }
    public String getQuestion(){
        return this.question;
    }

    @Override
    public int checkAnswer(Object userResponse) {
        String userResponseInt = (String) userResponse;
        if (userResponseInt == correctAnswerIndex) return 1;
        return 0;
    }

    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public Map<String, String> getAnswerOptions() {

        return answerOptions;
    }

    public void setAnswerOptions(Map<String, String> ansOps) {
        this.answerOptions = ansOps;
    }

    public String getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    public void setCorrectAnswerIndex(String correctAnswer) {
        this.correctAnswerIndex = correctAnswer;
    }
}