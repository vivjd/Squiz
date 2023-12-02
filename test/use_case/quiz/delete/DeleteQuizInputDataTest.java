package use_case.quiz.delete;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DeleteQuizInputDataTest {
    @Test
    public void testDeleteQuizInputDataConstruction() {
        ObjectId quizId = new ObjectId("656583e8d05ae3b112ed77c1");

        DeleteQuizInputData deleteQuizInputData = new DeleteQuizInputData(quizId);

        assertNotNull(deleteQuizInputData);
        assertEquals(quizId, deleteQuizInputData.getQuizId());
    }
}
