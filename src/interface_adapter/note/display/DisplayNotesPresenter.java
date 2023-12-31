package interface_adapter.note.display;

import interface_adapter.ViewManagerModel;
import use_case.note.display.DisplayNotesOutputBoundary;
import use_case.note.display.DisplayNotesOutputData;

/**
 * The {@code DisplayQuizzesPresenter} class implements the {@link DisplayNotesOutputBoundary}
 * interface to handle the presentation of output data from the "Display Notes" use case.
 *
 * <p>This presenter is responsible for preparing the view model ({@link DisplayNotesViewModel}) based
 * on the output data received from the use case. It updates the state of the view model, fires property
 * change events to notify observers, and sets the active view in the {@link ViewManagerModel}.</p>
 *
 * @see DisplayNotesOutputBoundary
 * @see DisplayNotesViewModel
 * @see ViewManagerModel
 */
public class DisplayNotesPresenter implements DisplayNotesOutputBoundary {
    private final DisplayNotesViewModel displayNotesViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructor for the Presenter of the "Display Notes" use case
     * @param displayNotesViewModel is the view model of the "Display Notes" use case
     * @param viewManagerModel is the manager model that controls the active view
     */
    public DisplayNotesPresenter(DisplayNotesViewModel displayNotesViewModel, ViewManagerModel viewManagerModel) {
        this.displayNotesViewModel = displayNotesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful execution of the "Display Notes" use case.
     *
     * @param note The output data containing information about displayed notes.
     */
    @Override
    public void prepareSuccessView(DisplayNotesOutputData note) {
        DisplayNotesState notesState = displayNotesViewModel.getState();
        notesState.setTable(note.getNotes());
        notesState.setIds(note.getIds());
        this.displayNotesViewModel.setState(notesState);
        displayNotesViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(displayNotesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed execution of the "Display Notes" use case
     * @param error the error message indicating the reason for failure
     */
    @Override
    public void prepareFailView(String error) {
        DisplayNotesState notesState = displayNotesViewModel.getState();
        notesState.setEmptyNotesError(error);
        displayNotesViewModel.firePropertyChanged();
    }
}
