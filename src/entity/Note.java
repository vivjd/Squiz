package entity;

import com.google.gson.Gson;
import use_case.quiz.Generator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

public class Note {
    @BsonId
    private ObjectId id;
    private String title;
    private String userPrompt;
    private Generator quizGenerator;

    public Note(Generator quizGenerator) {
        this.quizGenerator = quizGenerator;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserPrompt() {
        return userPrompt;
    }

    public void setUserPrompt(String userPrompt) {
        this.userPrompt = userPrompt;
    }

    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Note object to JSON.
        return gson.toJson(this);
    }

    public Quiz createQuiz() {
        return quizGenerator.createQuiz(userPrompt);
    }

}
