package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenEndedQuestionTest {
    private OpenEndedQuestion sampleQuestion;

    @BeforeEach
    void setUp() {
        sampleQuestion = new OpenEndedQuestion("What is Clean Architecture?", "Clean Architecture is a software design pattern.");
    }

    @Test
    void displayAnswerTest() {
        sampleQuestion.displayAnswer();
        Assertions.assertTrue(sampleQuestion.answerDisplayed);
    }

    @Test
    void getQuestionTest() {
        Assertions.assertEquals("What is Clean Architecture?", sampleQuestion.getQuestion());
    }

    @Test
    void getCorrectAnswerTest() {
        Assertions.assertEquals("Clean Architecture is a software design pattern.", sampleQuestion.getCorrectAnswer());
    }

    @Test
    void setCorrectAnswerTest() {
        sampleQuestion.setCorrectAnswer("Software design.");
        Assertions.assertEquals("Software design.", sampleQuestion.getCorrectAnswer());
    }
}