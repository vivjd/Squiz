package interface_adapter.quiz.take_quiz;

import entity.Question;

import java.util.List;

public class TakeQuizState {

    private int currentQuestionIndex = 0;
    private List<Question<?>> questions;

    public TakeQuizState() {};

    public TakeQuizState(List<Question<?>> questions) {
        this.questions = questions;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void setCurrentQuestionIndex(int currentQuestionIndex) {
        this.currentQuestionIndex = currentQuestionIndex;
    }

    public List<Question<?>> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question<?>> questions) {
        this.questions = questions;
    }
}
