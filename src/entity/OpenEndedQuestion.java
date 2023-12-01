package entity;


import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator
public class OpenEndedQuestion extends Question<String> {

    private String answer;
    @BsonProperty("question")
    private String question;

    public OpenEndedQuestion() {
    }

    public OpenEndedQuestion(@BsonProperty("question") String question, @BsonProperty("answer") String answer){
        this.question = question;
        this.answer = answer;
    }

    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return this.question;
    }

    @Override
    public int checkAnswer(Object userResponse) {
        if (userResponse == answer) return 1;
        return 0;
    }

    public String getCorrectAnswer() {
        return answer;
    }
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}
