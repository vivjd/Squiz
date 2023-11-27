package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.display_notes.DisplayNotesController;
import interface_adapter.note.display_notes.DisplayNotesPresenter;
import interface_adapter.note.display_notes.DisplayNotesViewModel;

import use_case.note.display_notes.*;
import use_case.note.NoteDataAccessInterface;

import view.DisplayNotesView;

public class DisplayNotesUseCaseFactory {
    private DisplayNotesUseCaseFactory() {}

    public static DisplayNotesView create(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        DisplayNotesController controller = createDisplayNotesUseCase(viewManagerModel, displayNotesViewModel, noteDataAccessObject);
        return new DisplayNotesView(displayNotesViewModel, controller);
    }

    private static DisplayNotesController createDisplayNotesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        DisplayNotesOutputBoundary displayNotesOutputBoundary = new DisplayNotesPresenter(displayNotesViewModel, viewManagerModel);
        DisplayNotesInputBoundary displayNotesInteractor = new DisplayNotesInteractor(noteDataAccessObject, displayNotesOutputBoundary);
        return new DisplayNotesController(displayNotesInteractor);
    }
}
