package interface_adapter.note;

import interface_adapter.ViewManagerModel;
import use_case.note.save.SaveNoteOutputData;
import use_case.note.save.SaveNoteOutputBoundary;

public class SaveSaveNotePresenter implements SaveNoteOutputBoundary {
    private final NoteViewModel noteViewModel;
    private ViewManagerModel viewManagerModel;

    public SaveSaveNotePresenter(NoteViewModel noteViewModel, ViewManagerModel viewManagerModel) {
        this.noteViewModel = noteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SaveNoteOutputData user) {
        NoteState noteState = noteViewModel.getState();
        noteState.setNote(user.getInputText());
        noteState.setTitle(user.getTitle());
    }

    @Override
    public void prepareFailView(String error) {
        NoteState noteState = noteViewModel.getState();
        noteState.setEmptyNoteError(error);
        noteViewModel.firePropertyChanged();
    }
}
