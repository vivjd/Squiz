package interface_adapter.note.back;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteState;
import interface_adapter.note.NoteViewModel;
import use_case.back.BackOutputBoundary;

public class BackPresenter implements BackOutputBoundary {
    private final NoteViewModel noteViewModel;
    private ViewManagerModel viewManagerModel;

    public BackPresenter(NoteViewModel noteViewModel, ViewManagerModel viewManagerModel) {
        this.noteViewModel = noteViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        viewManagerModel.setActiveView(noteViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {}
}
