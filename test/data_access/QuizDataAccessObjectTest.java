package data_access;

import entity.Quiz;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QuizDataAccessObjectTest {

    private final QuizDataAccessObject quizDataAccessObject = new QuizDataAccessObject();

    @Test
    public void testGetAllQuizzes() {
        List<Quiz> allQuizzes = quizDataAccessObject.getAllQuizzes();
        System.out.println(allQuizzes);
    }
}