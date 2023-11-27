package interface_adapter.note;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.display_notes.DisplayNotesViewModel;
import use_case.note.delete.DeleteNoteOutputBoundary;

public class DeleteNotePresenter implements DeleteNoteOutputBoundary {

    private final DisplayNotesViewModel displayNotesViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteNotePresenter(DisplayNotesViewModel displayNotesViewModel, ViewManagerModel viewManagerModel) {
        this.displayNotesViewModel = displayNotesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
