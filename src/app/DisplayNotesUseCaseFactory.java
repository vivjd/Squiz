package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.DeleteNoteController;
import interface_adapter.note.DeleteNotePresenter;
import interface_adapter.note.NoteViewModel;
import interface_adapter.note.back.BackController;
import interface_adapter.note.back.BackPresenter;
import interface_adapter.note.display_notes.DisplayNotesController;
import interface_adapter.note.display_notes.DisplayNotesPresenter;
import interface_adapter.note.display_notes.DisplayNotesViewModel;

import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInteractor;
import use_case.note.delete.DeleteNoteOutputBoundary;
import use_case.note.display_notes.*;
import use_case.note.NoteDataAccessInterface;

import view.DisplayNotesView;

/**
 * Responsible for building the initial view for the "Display Notes" use case
 */
public class DisplayNotesUseCaseFactory {
    private DisplayNotesUseCaseFactory() {}

    /**
     * Method is responsible for creating the initial view for
     * the "Display Notes" use case
     * @param viewManagerModel is the manager model responsible for tracking the current
     *                         view in the program
     * @param displayNotesViewModel is the view model responsible for the display notes page
     * @param noteDataAccessObject is the object that interacts with the back end
     * @param noteViewModel is the view model responsible for the note main page
     * @return the initial DisplayNotesView for the "Display Notes" use case
     */
    public static DisplayNotesView create(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject,
            NoteViewModel noteViewModel) {

        DisplayNotesController controller = createDisplayNotesUseCase(viewManagerModel, displayNotesViewModel, noteDataAccessObject);
        DeleteNoteController deleteNoteController = deleteNoteUseCase(viewManagerModel, displayNotesViewModel, noteDataAccessObject);
        BackPresenter backPresenter = new BackPresenter(noteViewModel, viewManagerModel);
        BackController backController = new BackController(backPresenter);

        return new DisplayNotesView(displayNotesViewModel, controller, deleteNoteController, backController);
    }

    private static DisplayNotesController createDisplayNotesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        DisplayNotesOutputBoundary displayNotesOutputBoundary = new DisplayNotesPresenter(displayNotesViewModel, viewManagerModel);
        DisplayNotesInputBoundary displayNotesInteractor = new DisplayNotesInteractor(noteDataAccessObject, displayNotesOutputBoundary);
        return new DisplayNotesController(displayNotesInteractor);
    }

    private static DeleteNoteController deleteNoteUseCase(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject) {
        DeleteNoteOutputBoundary deleteNoteOutputBoundary = new DeleteNotePresenter(displayNotesViewModel, viewManagerModel);
        DeleteNoteInputBoundary deleteNoteInteractor = new DeleteNoteInteractor(noteDataAccessObject, deleteNoteOutputBoundary);

        return new DeleteNoteController(deleteNoteInteractor);
    }
}
