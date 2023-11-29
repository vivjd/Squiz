package data_access;

import entity.MultipleChoiceQuestion;
import entity.Question;
import entity.Quiz;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class QuizDataAccessObjectTest {

    private final QuizDataAccessObject quizDataAccessObject = new QuizDataAccessObject();

    @Test
    public void testGetAllQuizzes() {
        List<Quiz> allQuizzes = quizDataAccessObject.getAllQuizzes();
        System.out.println(allQuizzes);
    }

    @Test
    public void testSaveQuiz() {
        Quiz quiz = new Quiz("testMCQ", LocalDateTime.now());
        List<Question<?>> questions = new ArrayList<>();
        Map<String, String> answerOptions = new HashMap<>();
        answerOptions.put("0", "0");
        answerOptions.put("1", "1");
        answerOptions.put("2", "2");
        answerOptions.put("3", "3");
        questions.add(
                new MultipleChoiceQuestion(
                        "TEST MCQ",
                        answerOptions,
                        "0"
                )
        );
        quiz.setQuestions(questions);
        quizDataAccessObject.saveQuiz(quiz);
    }
}