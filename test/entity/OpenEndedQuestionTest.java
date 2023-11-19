package entity;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpenEndedQuestionTest {
    private OpenEndedQuestion sampleQuestion;

    @Before
    public void setUp() {
        sampleQuestion = new OpenEndedQuestion("What is Clean Architecture?", "Clean Architecture is a software design pattern.");
    }

    @Test
    public void displayAnswerTest() {
        sampleQuestion.displayAnswer();
        assertTrue(sampleQuestion.answerDisplayed);
    }

    @Test
    public void getQuestionTest() {
        assertEquals("What is Clean Architecture?", sampleQuestion.getQuestion());
    }

    @Test
    public void getCorrectAnswerTest() {
        assertEquals("Clean Architecture is a software design pattern.", sampleQuestion.getCorrectAnswer());
    }

    @Test
    public void setCorrectAnswerTest() {
        sampleQuestion.setCorrectAnswer("Software design.");
        assertEquals("Software design.", sampleQuestion.getCorrectAnswer());
    }
}
