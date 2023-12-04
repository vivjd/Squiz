package entity;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.List;

/**
 * this class represents the Quiz in our program
 * this Quiz will contain its id, the title, the questions in the quiz
 * length, and creation time
 */
public class Quiz{
    @BsonId
    private ObjectId id;

    @BsonProperty("title")
    private String title;

    @BsonProperty("questions")
    List<Question<?>> questions;

    @BsonProperty("creationTime")
    private String creationTime;

    @BsonProperty("quizLength")
    int quizLength = 0;


    /**
     * this is the Quiz constructor that creates a Quiz object given the title and the creation time
     * @param title is the String title of the quiz
     * @param creationTime is the LocalDateTime timestamp of when it is created
     */
    public Quiz(@BsonProperty("title") String title, @BsonProperty("creationTime")LocalDateTime creationTime){
        this.title = title;
        this.creationTime = creationTime.toString();
    }

    /**
     * this is an empty constructor that creates and empty Quiz object
     */
    public Quiz(){}

    /**
     * sets the new title of the quiz
     * @param title is the new String title of the quiz
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * sets the creation time of the Quiz object
     * @param creationTime String of the creation time
     */
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * sets the Quiz length
     * @param quizLength is the length of the quiz
     */
    public void setQuizLength(int quizLength) {
        this.quizLength = quizLength;
    }

    /**
     * returns the id of the Quiz
     * @return ObjectID id of the Quiz
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * returns the questions
     * @return List<Question<?>> questions
     */
    public List<Question<?>> getQuestions() {
        return questions;
    }

    /**
     * sets the new id of the Quiz
     * @param id is the ObjectId id of the Quiz
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * returns the title of the Quiz
     * @return String title of the Quiz
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the length of the quiz
     * @return the int of the quiz length
     */
    public int getQuizLength() {
        return quizLength;
    }

    /**
     * Returns the creation time of the Quiz object
     * @return String of the creation Time
     */
    public String getCreationTime(){
        return creationTime;
    }

    /**
     * sets the new questions of the Quiz
     * @param questions is List<Question<?>> of questions for the quiz
     */
    public void setQuestions(List<Question<?>> questions) {
        this.questions = questions;
        this.quizLength = questions.size();
    }

    /**
     * Returns a string representation of the Quiz object
     * @return a String representation of Quiz
     */
    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", questions=" + questions +
                ", creationTime='" + creationTime + '\'' +
                ", quizLength=" + quizLength +
                '}';
    }

    /**
     * Returns a string representation of the Quiz object in JSON format
     * @return String representation of the JSON Quiz object
     */
    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Quiz object to JSON.
        return gson.toJson(this);
    }

}