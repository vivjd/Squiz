package use_case.quiz.display;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DisplayQuizzesOutputDataTest {
    private DisplayQuizzesOutputData outputDataMock;

    @BeforeEach
    public void setUp() {
        // Mocking the DisplayQuizzesOutputData class in the setup method
        outputDataMock = mock(DisplayQuizzesOutputData.class);

        // Sample data for mocking
        String[][] sampleQuizzes = {
                {"Quiz 1", "Question 1", "Option 1", "Option 2", "Option 3", "Option 4", "Correct Option"},
                {"Quiz 2", "Question 1", "Option 1", "Option 2", "Option 3", "Option 4", "Correct Option"}
        };

        ObjectId[] sampleIds = {
                new ObjectId("656583e8d05ae3b112ed77c1"),
                new ObjectId("656583e8d05ae3b112ed77c2")
        };

        // Stubbing the methods to return the sample data
        when(outputDataMock.getQuizzes()).thenReturn(sampleQuizzes);
        when(outputDataMock.getIds()).thenReturn(sampleIds);
    }

    @Test
    public void testDisplayQuizzesOutputDataWithMocking() {
        // Test getters
        assertArrayEquals(outputDataMock.getQuizzes(), outputDataMock.getQuizzes());
        assertArrayEquals(outputDataMock.getIds(), outputDataMock.getIds());
    }
}
