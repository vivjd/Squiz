package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.SaveNoteController;
import interface_adapter.note.SaveNotePresenter;
import interface_adapter.note.NoteViewModel;
import use_case.note.NoteDataAccessInterface;
import use_case.note.SaveNoteInputBoundary;
import use_case.note.SaveNoteInteractor;
import use_case.note.NoteOutputBoundary;
import view.NoteView;

public class NoteUseCaseFactory {
    private NoteUseCaseFactory() {}

    public static NoteView create(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        SaveNoteController saveNoteController = createNoteUseCase(viewManagerModel, noteViewModel, noteDataAccessObject);
        return new NoteView(saveNoteController, noteViewModel);
    }

    private static SaveNoteController createNoteUseCase(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        NoteOutputBoundary noteOutputBoundary = new SaveNotePresenter(noteViewModel, viewManagerModel);
        SaveNoteInputBoundary noteInteractor = new SaveNoteInteractor(noteDataAccessObject, noteOutputBoundary);

        return new SaveNoteController(noteInteractor);
    }

}
