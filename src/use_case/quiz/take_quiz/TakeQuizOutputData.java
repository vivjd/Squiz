package use_case.quiz.take_quiz;

import entity.Quiz;

public class TakeQuizOutputData {

    private Quiz quiz;

    public TakeQuizOutputData(Quiz quiz) {
        this.quiz = quiz;
    };

    public TakeQuizOutputData() {

    }

    public Quiz getQuiz() {
        return quiz;
    }

}
