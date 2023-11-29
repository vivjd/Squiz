package entity;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

@BsonDiscriminator
public abstract class Question <T> {

    boolean answerDisplayed = false;

    @BsonProperty("question")
    String question;


    public abstract void displayAnswer();
    public abstract void setQuestion(String question);
    public abstract String getQuestion();

    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Quiz object to JSON.
        return gson.toJson(this);
    }

  public abstract int checkAnswer(Object userResponse);

}