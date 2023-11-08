package app;

import data_access.NoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.*;
import use_case.note.NoteDataAccessInterface;
import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInteractor;
import use_case.note.delete.DeleteNoteOutputBoundary;
import use_case.note.save.SaveNoteInputBoundary;
import use_case.note.save.SaveNoteInteractor;
import use_case.note.save.SaveNoteOutputBoundary;
import view.NoteView;

public class NoteUseCaseFactory {
    private NoteUseCaseFactory() {
    }

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

    private static DeleteNoteController deleteNoteUseCase(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessObject noteDataAccessObject) {
        DeleteNoteOutputBoundary deleteNoteOutputBoundary = new DeleteNotePresenter(noteViewModel, viewManagerModel);
        DeleteNoteInputBoundary deleteNoteInteractor = new DeleteNoteInteractor(noteDataAccessObject, deleteNoteOutputBoundary);

        return new DeleteNoteController(deleteNoteInteractor);
    }

}
