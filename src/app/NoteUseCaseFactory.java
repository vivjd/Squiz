package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.SaveNoteController;
import interface_adapter.note.SaveSaveNotePresenter;
import interface_adapter.note.NoteViewModel;
import use_case.note.NoteDataAccessInterface;
import use_case.note.SaveNoteInputBoundary;
import use_case.note.SaveNoteInteractor;
import use_case.note.SaveNoteOutputBoundary;
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

        SaveNoteOutputBoundary saveNoteOutputBoundary = new SaveSaveNotePresenter(noteViewModel, viewManagerModel);
        SaveNoteInputBoundary noteInteractor = new SaveNoteInteractor(noteDataAccessObject, saveNoteOutputBoundary);

        return new SaveNoteController(noteInteractor);
    }

}
