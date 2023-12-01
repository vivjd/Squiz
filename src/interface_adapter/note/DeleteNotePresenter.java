package interface_adapter.note;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.display_notes.DisplayNotesViewModel;
import use_case.note.delete.DeleteNoteOutputBoundary;

/**
 * The DeleteNotePresenter class is responsible for presenting the results of the note deletion process.
 * It implements the DeleteNoteOutputBoundary interface.
 */
public class DeleteNotePresenter implements DeleteNoteOutputBoundary {

    private final DisplayNotesViewModel displayNotesViewModel;
    private ViewManagerModel viewManagerModel;

    /**
     * Constructs a DeleteNotePresenter with the specified displayNotesViewModel and viewManagerModel.
     *
     * @param displayNotesViewModel The ViewModel representing displayed notes.
     * @param viewManagerModel       The model for managing views.
     */
    public DeleteNotePresenter(DisplayNotesViewModel displayNotesViewModel, ViewManagerModel viewManagerModel) {
        this.displayNotesViewModel = displayNotesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares a success view for the note deletion.
     */
    @Override
    public void prepareSuccessView() {

    }

    /**
     * Prepares a fail view for the note deletion with the given error message.
     *
     * @param error A string representing the error or failure information.
     */
    @Override
    public void prepareFailView(String error) {

    }
}
