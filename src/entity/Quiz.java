package entity;

import com.google.gson.Gson;

import java.util.List;

public class Quiz {

    List<Question> questions;
    int quizLength = 0;
    int numCorrect = 0;

    public Quiz(){
    }

    public int getQuizLength() {
        return quizLength;
    }
    public int getNumCorrect() {
        return numCorrect;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String toJson() {
        // Create a Gson instance.
        Gson gson = new Gson();

        // Use Gson to convert the Quiz object to JSON.
        return gson.toJson(this);
    }
}
