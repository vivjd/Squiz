package entity;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@BsonDiscriminator
public abstract class Question {

    @BsonId
    private ObjectId id;
    boolean answerDisplayed = false;
    String question;


    public abstract void displayAnswer();
    public abstract void setQuestion(String question);
    public abstract String getQuestion();

}