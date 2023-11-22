package entity;

import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator
public
class OpenEndedQuestion extends Question {

    @BsonProperty("answer")
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
    public String getCorrectAnswer() {
        return answer;
    }
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}