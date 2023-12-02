package interface_adapter.back;

import interface_adapter.ViewManagerModel;
import interface_adapter.back.BackPresenter;
import interface_adapter.note.NoteViewModel;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BackPresenterTest {
    private ViewManagerModel viewManagerModel;
    private NoteViewModel noteViewModel;
    private BackPresenter backPresenter;

    @Before
    public void create_presenter() {
        viewManagerModel = mock(ViewManagerModel.class);
        noteViewModel = mock(NoteViewModel.class);
        backPresenter = new BackPresenter(noteViewModel, viewManagerModel);
    }

    @Test
    public void testSuccess() {
        backPresenter.prepareSuccessView();
    }

    @Test
    public void testFailed() {
        backPresenter.prepareFailView();
    }
}
