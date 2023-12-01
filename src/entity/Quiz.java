package entity;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonCreator;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a quiz containing a list of questions.
 */
public class Quiz implements Iterable<Question<?>>{

    /**
     * The unique identifier for the quiz.
     */
    @BsonId
    private ObjectId id;

    /**
     * The title of the quiz.
     */
    @BsonProperty("title")
    private String title;

    /**
     * The list of questions in the quiz.
     */

    @BsonProperty("questions")
    List<Question<?>> questions;

    @BsonProperty("creationTime")
    private String creationTime;

    @BsonProperty("quizLength")
    int quizLength = 0;



    /**
     * Constructs a Quiz with the specified title and creation time.
     *
     * @param title        The title of the quiz.
     * @param creationTime The creation time of the quiz.
     */
    @BsonCreator
    public Quiz(@BsonProperty("title") String title, @BsonProperty("creationTime")LocalDateTime creationTime){
        this.title = title;
        this.creationTime = creationTime.toString();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    /**
     * Retrieves the unique identifier for the quiz.
     *
     * @return The unique identifier for the quiz.
     */
    public void setQuizLength(int quizLength) {
        this.quizLength = quizLength;
    }

    public ObjectId getId() {
        return id;
    }

    /**
     * Retrieves the list of questions in the quiz.
     *
     * @return The list of questions in the quiz.
     */
    public List<Question<?>> getQuestions() {
        return questions;
    }

    /**
     * Sets the unique identifier for the quiz.
     *
     * @param id The unique identifier for the quiz.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    /**
     * Retrieves the total number of questions in the quiz.
     *
     * @return The total number of questions in the quiz.
     */
    public int getQuizLength() {
        return quizLength;
    }

    public String getCreationTime(){
        return creationTime;
    }

    /**
     * Sets the list of questions in the quiz and updates the quiz length.
     *
     * @param questions The list of questions in the quiz.
     */
    public void setQuestions(List<Question<?>> questions) {
        this.questions = questions;
        this.quizLength = questions.size();
    }


    /**
     * Converts the quiz object to JSON using the Gson library.
     *
     * @return A JSON representation of the quiz object.
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
     * Converts the quiz object to JSON using the Gson library.
     *
     * @return A JSON representation of the quiz object.
     */
    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Quiz object to JSON.
        return gson.toJson(this);
    }

    /**
     * Returns an iterator over the questions in the quiz.
     *
     * @return An iterator over the questions in the quiz.
     */
    @NotNull
    @Override
    public Iterator<Question<?>> iterator() {
        return new QuizIterator();
    }

    /**
     * Private inner class representing an iterator over the questions in the quiz.
     */
    private class QuizIterator implements Iterator<Question<?>> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < questions.size();
        }

        /**
         * Retrieves the next question in the iterator.
         *
         * @return The next question in the iterator.
         * @throws java.util.NoSuchElementException if there is no next question.
         */
        @Override
        public Question<?> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return questions.get(currentIndex++);
        }
    }

    /**
     * Performs the given action for each question in the quiz.
     *
     * @param action The action to be performed for each question.
     */
    @Override
    public void forEach(Consumer<? super Question<?>> action) {
        Iterable.super.forEach(action);
    }

    /**
     * Creates a spliterator over the questions in the quiz.
     *
     * @return A spliterator over the questions in the quiz.
     */
    @Override
    public Spliterator<Question<?>> spliterator() {
        return Iterable.super.spliterator();
    }
}
