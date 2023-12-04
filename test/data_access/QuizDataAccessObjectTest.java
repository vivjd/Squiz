package data_access;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import entity.MultipleChoiceQuestion;
import entity.Question;
import entity.Quiz;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuizDataAccessObjectTest {
    private final QuizDataAccessObject quizDataAccessObject = new QuizDataAccessObject();

    @Test
    public void testGetAllQuizzes() {
        List<Quiz> allQuizzes = quizDataAccessObject.getAllQuizzes();
        System.out.println(allQuizzes);
    }

    @Test
    public void testSaveAndGetQuiz() {
        Quiz quiz = new Quiz("testMCQ", LocalDateTime.now());
        quiz.setId(new ObjectId("656583e8d05ae3b112ed77c1"));
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
        quizDataAccessObject.getQuiz("testMCQ");
        quizDataAccessObject.getAllQuizzesTable();
        quizDataAccessObject.getAllIds();
        quizDataAccessObject.getQuizById(new ObjectId("656583e8d05ae3b112ed77c1"));
        quizDataAccessObject.deleteQuizById(new ObjectId("656583e8d05ae3b112ed77c1"));
    }
}