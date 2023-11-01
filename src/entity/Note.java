package entity;

import com.google.gson.Gson;
import use_case.quiz.Generator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * The Note class represents a note that can be used to create quizzes.
 * It contains information about the note, including its title, user prompt, and an associated quiz generator.
 */
public class Note {
    @BsonId
    private ObjectId id;
    private String title;
    private String userPrompt;
    private Generator quizGenerator;

    /**
     * Constructs a new `Note` object with an associated quiz generator.
     *
     * @param quizGenerator The quiz generator to be associated with the note.
     */
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

    /**
     * Creates a quiz based on the user prompt using the associated quiz generator.
     *
     * @return A `Quiz` object generated from the user prompt.
     */
    public Quiz createQuiz() {
        return quizGenerator.createQuiz(userPrompt);
    }

}
