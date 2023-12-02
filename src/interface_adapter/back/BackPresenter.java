package interface_adapter.back;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteViewModel;
import use_case.back.BackOutputBoundary;

/**
 * The {@code BackPresenter} class implements the {@link BackOutputBoundary}
 * interface to handle the presentation of output data from the "Display Notes" use case.
 *
 * <p>This presenter is responsible for preparing the view model ({@link NoteViewModel}) when
 * the user interacts with the back button on any screens. It updates the state of the view model
 * to the Main Page and fires property change events to notify observers, and sets the active view in the
 * {@link ViewManagerModel}.</p>
 *
 * @see BackOutputBoundary
 * @see NoteViewModel
 * @see ViewManagerModel
 */
public class BackPresenter implements BackOutputBoundary {
    private final NoteViewModel noteViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructor for the Presenter of the "Back" use case
     * @param noteViewModel is the view model of the main note page (initial main screen)
     * @param viewManagerModel is the manager model that determines the active view when the program is running
     */
    public BackPresenter(NoteViewModel noteViewModel, ViewManagerModel viewManagerModel) {
        this.noteViewModel = noteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful execution of the "Back" use case.
     */
    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(noteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed execution of the "Back" use case
     * This should not need to be implemented since the there is no input data; user just has to
     * click the button and should go to the notes main page
     */
    @Override
    public void prepareFailView() {}
}
