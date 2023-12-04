package entity;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonProperty;
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

    /**
     * empty constructor that creates an empty Note object
     */
    public Note() {}

    /**
     * constructor that creates a Note object based on the title and text given
     * @param title is the title of the note
     * @param userPrompt is the note contents
     */
    @BsonCreator
    public Note(@BsonProperty("title") String title, @BsonProperty("userPrompt") String userPrompt) {
        this.title = title;
        this.userPrompt = userPrompt;

    }

    /**
     * returns the id of the note
     * @return ObjectId of the note
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * sets the id of the note
     * @param id the new ObjectID of note
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * returns the title of the note
     * @return String title of the note
     */
    public String getTitle() {
        return title;
    }

    /**
     * sets the title of the note
     * @param title is the new String title of the note
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * returns the content of the note
     * @return String note content
     */
    public String getUserPrompt() {
        return userPrompt;
    }

    /**
     * sets the content of the note
     * @param userPrompt the new String content of the note
     */
    public void setUserPrompt(String userPrompt) {
        this.userPrompt = userPrompt;
    }

    /**
     * Returns a string representation of the Note object
     * @return String representation of the JSON Note object
     */
    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Note object to JSON.
        return gson.toJson(this);
    }

}
