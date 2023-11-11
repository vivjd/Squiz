package interface_adapter.note;

import interface_adapter.ViewManagerModel;
import use_case.note.delete.DeleteNoteOutputBoundary;

public class DeleteNotePresenter implements DeleteNoteOutputBoundary {

    private final NoteViewModel noteViewModel;
    private ViewManagerModel viewManagerModel;

    public DeleteNotePresenter(NoteViewModel noteViewModel, ViewManagerModel viewManagerModel) {
        this.noteViewModel = noteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {

    }

    @Override
    public void prepareFailView(String error) {

    }
}
