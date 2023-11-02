package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteController;
import interface_adapter.note.NotePresenter;
import interface_adapter.note.NoteViewModel;
import use_case.note.NoteDataAccessInterface;
import use_case.note.NoteInputBoundary;
import use_case.note.NoteInteractor;
import use_case.note.NoteOutputBoundary;
import view.NoteView;

import javax.swing.*;

public class NoteUseCaseFactory {
    private NoteUseCaseFactory() {}

    public static NoteView create(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        NoteController noteController = createNoteUseCase(viewManagerModel, noteViewModel, noteDataAccessObject);
        return new NoteView(noteController, noteViewModel);
    }

    private static NoteController createNoteUseCase(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        NoteOutputBoundary noteOutputBoundary = new NotePresenter(noteViewModel, viewManagerModel);
        NoteInputBoundary noteInteractor = new NoteInteractor(noteDataAccessObject, noteOutputBoundary);

        return new NoteController(noteInteractor);
    }

}
