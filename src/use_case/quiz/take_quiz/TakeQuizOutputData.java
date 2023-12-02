package use_case.quiz.take_quiz;

import entity.Quiz;

public class TakeQuizOutputData {

    private int score = 0;
    private Quiz quiz;

    public TakeQuizOutputData(Quiz quiz) {
        this.quiz = quiz;
    };

    public TakeQuizOutputData() {

    }


    public int getScore() {
        return score;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
