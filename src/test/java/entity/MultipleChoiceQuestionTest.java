package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MultipleChoiceQuestionTest {
    private MultipleChoiceQuestion question;
    @BeforeEach
    void setUp() {
        HashMap<Integer, String> answerOptions = new HashMap<>();
        answerOptions.put(1, "Single Reason Principle");
        answerOptions.put(2, "Singular Reason Principle");
        answerOptions.put(3, "Single Responsibility Principle");
        question = new MultipleChoiceQuestion("What does SRP stand for?", answerOptions, 3);
    }

    @Test
    void getQuestion() {
        Assertions.assertEquals("What does SRP stand for?", question.getQuestion());
    }

    @Test
    void displayAnswer() {
        question.displayAnswer();
        Assertions.assertTrue(question.answerDisplayed);
    }

    @Test
    void setQuestion() {
        question.setQuestion("What does SRP stand for in Clean Architecture?");
        Assertions.assertEquals("What does SRP stand for in Clean Architecture?", question.getQuestion());
    }

    @Test
    void getAnswerOptions() {
        HashMap<Integer, String> answerOptions = question.getAnswerOptions();
        Assertions.assertEquals("Single Reason Principle", answerOptions.get(1));
        Assertions.assertEquals("Singular Reason Principle", answerOptions.get(2));
        Assertions.assertEquals("Single Responsibility Principle", answerOptions.get(3));
    }

    @Test
    void setAnswerOptions() {
        HashMap<Integer, String> newAnswerOptions = new HashMap<>();
        newAnswerOptions.put(1, "S R P");
        newAnswerOptions.put(2, "Single R P");
        newAnswerOptions.put(3, "R P");

        question.setAnswerOptions(newAnswerOptions);
        HashMap<Integer, String> updatedAnswerOptions = question.getAnswerOptions();

        Assertions.assertEquals("S R P", updatedAnswerOptions.get(1));
        Assertions.assertEquals("Single R P", updatedAnswerOptions.get(2));
        Assertions.assertEquals("R P", updatedAnswerOptions.get(3));
    }

    @Test
    void getCorrectAnswerIndex() {
        Assertions.assertEquals(2, question.getCorrectAnswerIndex());
    }

    @Test
    void setCorrectAnswerIndex() {
        question.setCorrectAnswerIndex(1);
        Assertions.assertEquals(1, question.getCorrectAnswerIndex());
    }
}