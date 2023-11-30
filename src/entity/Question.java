package entity;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

/**
 * An abstract class representing a generic question with a specified answer type.
 *
 * @param <T> The type of the answer to the question.
 */
@BsonDiscriminator
public abstract class Question<T> {
    /**
     * Flag indicating whether the answer has been displayed.
     */
    @BsonId
    private ObjectId id;
    boolean answerDisplayed = false;

    /**
     * The text of the question.
     */

    @BsonProperty("question")
    String question;

    /**
     * Displays the answer to the question.
     */

    public abstract void displayAnswer();

    /**
     * Sets the text of the question.
     *
     * @param question The text of the question.
     */
    public abstract void setQuestion(String question);

    /**
     * Retrieves the text of the question.
     *
     * @return The text of the question.
     */
    public abstract String getQuestion();

    /**
     * Converts the question object to JSON using the Gson library.
     *
     * @return A JSON representation of the question object.
     */
    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Quiz object to JSON.
        return gson.toJson(this);
    }

    /**
     * Checks the user's response against the correct answer.
     *
     * @param userResponse The user's response to the question.
     * @return 1 if the user's response is correct, 0 otherwise.
     */
    public abstract int checkAnswer(Object userResponse);

}