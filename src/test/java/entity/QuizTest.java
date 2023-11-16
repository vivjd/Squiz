package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuizTest {
    private Quiz sampleQuiz;
    private List<Question> sampleQuestions;

    @BeforeEach
    void init(){
        sampleQuiz = new Quiz();
        sampleQuestions = new ArrayList<>();
        HashMap<Integer, String> answerOptions = new HashMap<>();
        answerOptions.put(1, "Option A");
        answerOptions.put(2, "Option B");
        answerOptions.put(3, "Option C");
        sampleQuestions.add(new MultipleChoiceQuestion("What is 1+1?", answerOptions, 1));
        sampleQuestions.add(new OpenEndedQuestion("What is Clean Architecture?", "Clean Architecture is a software design pattern that emphasizes separating an application into layers, with the core business logic at the center, independent of external frameworks. It promotes maintainability, testability, and flexibility in software development."));
        sampleQuiz.setQuestions(sampleQuestions);
    }

    @Test
    void getQuizLengthTest() {
        Assertions.assertEquals(sampleQuestions.size(), sampleQuiz.getQuizLength());
    }

    @Test
    void getNumCorrectTest() {
        Assertions.assertEquals(0, sampleQuiz.getNumCorrect());
    }

    @Test
    void setQuestionsTest() {
        Assertions.assertEquals(sampleQuestions, sampleQuiz.questions);
    }

    @Test
    void setQuestionsShouldNotModifyOriginalListTest() {
        List<Question> modifiedList = sampleQuiz.questions;
        modifiedList.add(new OpenEndedQuestion("Sample Question new", "New Answer new"));
        Assertions.assertNotEquals(sampleQuestions, modifiedList);
    }
}