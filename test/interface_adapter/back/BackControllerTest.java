package interface_adapter.back;

import interface_adapter.back.BackController;
import org.junit.Before;
import org.junit.Test;
import use_case.back.BackOutputBoundary;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class BackControllerTest {
    private BackOutputBoundary backPresenter;
    private BackController controller;

    @Before
    public void create_initial() {
        backPresenter = mock(BackOutputBoundary.class);
        controller = new BackController(backPresenter);
    }

    @Test
    public void testExecuteSuccess() {
        controller.execute();
        verify(backPresenter).prepareSuccessView();
    }

}
