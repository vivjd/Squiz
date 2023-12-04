package interface_adapter.quiz.take_quiz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TakeQuizViewModelTest {

    @Test
    void constructor_ShouldInitializeWithDefaultViewName() {
        TakeQuizViewModel viewModel = new TakeQuizViewModel();

        assertEquals("take_quiz", viewModel.getViewName());
    }

    @Test
    void getState_ShouldReturnInitialState() {
        TakeQuizViewModel viewModel = new TakeQuizViewModel();

        TakeQuizState initialState = viewModel.getState();

        assertEquals(initialState, viewModel.getState());
    }

    @Test
    void setState_ShouldUpdateState() {
        TakeQuizViewModel viewModel = new TakeQuizViewModel();
        TakeQuizState newState = new TakeQuizState();

        viewModel.setState(newState);

        assertEquals(newState, viewModel.getState());
    }

}
