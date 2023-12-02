package interface_adapter.quiz.display;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayQuizzesStateTest {
    @Test
    public void testDefaultConstructor() {
        DisplayQuizzesState state = new DisplayQuizzesState();

        assertNull(state.getQuizzesTable());
        assertNull(state.getEmptyQuizzesError());
        assertNull(state.getIds());
    }

    @Test
    public void testSetAndGetQuizzesTable() {
        DisplayQuizzesState state = new DisplayQuizzesState();

        String[][] quizzesTable = {{"Quiz 1"}, {"Quiz 2"}};
        state.setQuizzesTable(quizzesTable);

        assertArrayEquals(quizzesTable, state.getQuizzesTable());
    }

    @Test
    public void testSetAndGetEmptyQuizzesError() {
        DisplayQuizzesState state = new DisplayQuizzesState();

        state.setEmptyQuizError("Error: No quizzes to display.");

        assertEquals("Error: No quizzes to display.", state.getEmptyQuizzesError());
    }

    @Test
    public void testSetAndGetIds() {
        DisplayQuizzesState state = new DisplayQuizzesState();

        ObjectId[] ids = {new ObjectId(), new ObjectId()};
        state.setIds(ids);

        assertArrayEquals(ids, state.getIds());
    }
}
