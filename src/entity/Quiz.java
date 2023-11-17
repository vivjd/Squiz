package entity;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

public class Quiz {
    @BsonId
    private ObjectId id;

    private String title;
    List<Question> questions;

    @BsonProperty("creationTime")
    private final LocalDateTime creationTime;

    @BsonProperty("numberOfQuestions")
    int quizLength = 0;
    int numCorrect = 0;

    public Quiz(@BsonProperty("title") String title, @BsonProperty("creationTime")LocalDateTime creationTime){
        this.title = title;
        this.creationTime = creationTime;
    }

    public ObjectId getId() {
        return id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getQuizLength() {
        return quizLength;
    }
    public int getNumCorrect() {
        return numCorrect;
    }

    public LocalDateTime getCreationTime(){
        return creationTime;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
        this.quizLength = questions.size();
    }

    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Quiz object to JSON.
        return gson.toJson(this);
    }
}
