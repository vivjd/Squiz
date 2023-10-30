package interface_adapter.note;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.note.NoteViewModel;
import use_case.note.NoteOutputData;
import use_case.note.NoteOutputBoundary;

public class NotePresenter implements NoteOutputBoundary{
    private final NoteViewModel noteViewModel;
    private ViewManagerModel viewManagerModel;

    public NotePresenter(NoteViewModel noteViewModel, ViewManagerModel viewManagerModel) {
        this.noteViewModel = noteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(NoteOutputData user) {
        NoteState noteState = noteViewModel.getState();
        noteState.setNote(user.getInputText());
        noteState.setTitle(user.getTitle());
        //TODO: next panel? check to see which state goes to next
    }

    @Override
    public void prepareFailView(String error) {
        NoteState noteState = noteViewModel.getState();
        noteState.setEmptyNoteError(error);
        noteViewModel.firePropertyChanged();
    }
}
