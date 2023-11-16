package use_case.quiz;

import entity.Quiz;

import java.util.List;

public interface QuizDataAccessInterface {
    void saveQuiz(Quiz quiz);

    Quiz getQuiz(String title);

    List<Quiz> getAllQuizzes();

    String[][] getAllQuizzesTable();

    List<String> getAllQuizTitles();
}
