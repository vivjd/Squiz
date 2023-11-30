package use_case.quiz.delete;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import use_case.quiz.QuizDataAccessInterface;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DeleteQuizInteractorTest {

    private QuizDataAccessInterface quizDataAccessObject;
    private DeleteQuizOutputBoundary deleteQuizOutputBoundary;
    private DeleteQuizInteractor deleteQuizInteractor;

    @Before
    public void setUp() {
        quizDataAccessObject = mock(QuizDataAccessInterface.class);
        deleteQuizOutputBoundary = mock(DeleteQuizOutputBoundary.class);
        deleteQuizInteractor = new DeleteQuizInteractor(quizDataAccessObject, deleteQuizOutputBoundary);
    }

    @Test
    public void testExecuteSuccess() {

        ObjectId quizIdToDelete = new ObjectId("656583e8d05ae3b112ed77c1");
        DeleteQuizInputData deleteQuizInputData = new DeleteQuizInputData(quizIdToDelete);

        deleteQuizInteractor.execute(deleteQuizInputData);

//        verify(quizDataAccessObject).getQuizById(quizIdToDelete);
        verify(quizDataAccessObject).deleteQuizById(quizIdToDelete);
//        verify(deleteQuizOutputBoundary).prepareSuccessView(any(DeleteQuizOutputData.class));
    }

    @Test
    public void testExecuteThrowsRuntimeException() {
        ObjectId quizIdToDelete = new ObjectId("656583e8d05ae3b112ed77c1");
        DeleteQuizInputData deleteQuizInputData = new DeleteQuizInputData(quizIdToDelete);

        doThrow(new RuntimeException("Mocked Exception"))
                .when(quizDataAccessObject).getQuizById(quizIdToDelete);

        try {
            deleteQuizInteractor.execute(deleteQuizInputData);
            fail("Should throw a runtime Exception");
        } catch (RuntimeException e) {
            verify(quizDataAccessObject).getQuizById(quizIdToDelete);
            verifyNoMoreInteractions(quizDataAccessObject);
            verifyNoInteractions(deleteQuizOutputBoundary);
        }
    }
}
