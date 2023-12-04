package use_case.question;

import entity.MultipleChoiceQuestion;
import entity.Question;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;


public class AnswerQuestionInputDataTest {

    @Test
    public void constructor_ShouldSetUserAnswerAndQuestion() {
        // Arrange
        String userAnswer = "User's answer";
        Question<?> question = mock(MultipleChoiceQuestion.class); // Mock a question

        // Act
        AnswerQuestionInputData input = new AnswerQuestionInputData(userAnswer, question);

        // Assert
        assertEquals(userAnswer, input.getUserAnswer());
        assertEquals(question, input.getQuestion());
    }
}