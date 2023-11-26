package entity;

import com.google.gson.Gson;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Quiz implements Iterable<Question<?>>{
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


    public Quiz(@BsonProperty("title") String title, @BsonProperty("creationTime")LocalDateTime creationTime){
        this.title = title;
        this.creationTime = creationTime.toString();
    }

    public Quiz(){}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public void setQuizLength(int quizLength) {
        this.quizLength = quizLength;
    }

    public ObjectId getId() {
        return id;
    }

    public List<Question<?>> getQuestions() {
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

    public String getCreationTime(){
        return creationTime;
    }


    public void setQuestions(List<Question<?>> questions) {
        this.questions = questions;
        this.quizLength = questions.size();
    }

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

    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Quiz object to JSON.
        return gson.toJson(this);
    }

    @NotNull
    @Override
    public Iterator<Question<?>> iterator() {
        return new QuizIterator();
    }

    private class QuizIterator implements Iterator<Question<?>> {

        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < questions.size();
        }

        @Override
        public Question<?> next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return questions.get(currentIndex++);
        }
    }

    @Override
    public void forEach(Consumer<? super Question<?>> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Question<?>> spliterator() {
        return Iterable.super.spliterator();
    }
}
