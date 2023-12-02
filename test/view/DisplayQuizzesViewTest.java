package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackController;
import interface_adapter.quiz.delete.DeleteQuizController;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesState;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.beans.PropertyChangeEvent;

import static org.mockito.Mockito.*;

public class DisplayQuizzesViewTest {
    @Mock
    private DisplayQuizzesViewModel displayQuizzesViewModel;

    @Mock
    private DisplayQuizzesController displayQuizzesController;

    @Mock
    private ViewManagerModel viewManagerModel;

    @Mock
    private DeleteQuizController deleteQuizController;

    @Mock
    private BackController backController;

    private DisplayQuizzesView displayQuizzesView;

    @Mock
    private TakeQuizController takeQuizController;

    @Mock
    private TakeQuizViewModel takeQuizViewModel;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        displayQuizzesView = new DisplayQuizzesView(
                displayQuizzesViewModel,
                displayQuizzesController,
                takeQuizController,
                takeQuizViewModel,
                deleteQuizController,
                backController
        );
    }

//    @Test
//    void testPropertyChange() {
//        DisplayQuizzesState state = new DisplayQuizzesState();
//        when(displayQuizzesViewModel.getState()).thenReturn(state);
//
//        displayQuizzesView.propertyChange(mock(PropertyChangeEvent.class));
//
//        verify(displayQuizzesView).updateTable();
//    }
}
