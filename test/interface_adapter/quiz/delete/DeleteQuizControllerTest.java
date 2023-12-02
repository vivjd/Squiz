package interface_adapter.quiz.delete;

import interface_adapter.note.DeleteNoteController;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.quiz.delete.DeleteQuizInputBoundary;

import static org.mockito.Mockito.*;
public class DeleteQuizControllerTest {

    @Mock
    private DeleteQuizInputBoundary deleteQuizInteractor;

    private DeleteQuizController deleteQuizController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        deleteQuizController = new DeleteQuizController(deleteQuizInteractor);
    }

    @Test
    public void testExecute() {
        ObjectId quizId = new ObjectId("656583e8d05ae3b112ed77c1");

        deleteQuizController.execute(quizId);

        verify(deleteQuizInteractor).execute(argThat(argument -> argument.getQuizId().equals(quizId)));
    }
}
