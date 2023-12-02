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
import use_case.note.NoteDataAccessInterface;
import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInteractor;
import use_case.note.delete.DeleteNoteOutputBoundary;
import use_case.note.display_notes.DisplayNotesInputBoundary;
import use_case.note.display_notes.DisplayNotesInteractor;
import use_case.note.display_notes.DisplayNotesOutputBoundary;
import view.DisplayNotesView;

/**
 * The DisplayNotesUseCaseFactory class is responsible for creating and initializing the components
 * necessary for the DisplayNotes feature, including the DisplayNotesView, DisplayNotesController, DeleteNoteController,
 * and BackController. It encapsulates the instantiation of controllers and associated input and output boundaries,
 * facilitating the separation of concerns in the architecture.
 */
public class DisplayNotesUseCaseFactory {

    /**
     * Private constructor to prevent instantiation of the factory class.
     */
    private DisplayNotesUseCaseFactory() {}

    /**
     * Creates an instance of the DisplayNotesView by initializing the required components,
     * such as the DisplayNotesController, DeleteNoteController, and BackController.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param displayNotesViewModel      The DisplayNotesViewModel representing the data for displaying notes.
     * @param noteDataAccessObject       The NoteDataAccessInterface for accessing note-related data.
     * @param noteViewModel              The NoteViewModel representing the data for an individual note.
     * @return The created DisplayNotesView instance.
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

    /**
     * Creates an instance of the DisplayNotesController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param displayNotesViewModel      The DisplayNotesViewModel representing the data for displaying notes.
     * @param noteDataAccessObject       The NoteDataAccessInterface for accessing note-related data.
     * @return The created DisplayNotesController instance.
     */
    private static DisplayNotesController createDisplayNotesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        DisplayNotesOutputBoundary displayNotesOutputBoundary = new DisplayNotesPresenter(displayNotesViewModel, viewManagerModel);
        DisplayNotesInputBoundary displayNotesInteractor = new DisplayNotesInteractor(noteDataAccessObject, displayNotesOutputBoundary);
        return new DisplayNotesController(displayNotesInteractor);
    }

    /**
     * Creates an instance of the DeleteNoteController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param displayNotesViewModel      The DisplayNotesViewModel representing the data for displaying notes.
     * @param noteDataAccessObject       The NoteDataAccessInterface for accessing note-related data.
     * @return The created DeleteNoteController instance.
     */
    private static DeleteNoteController deleteNoteUseCase(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject) {
        DeleteNoteOutputBoundary deleteNoteOutputBoundary = new DeleteNotePresenter(displayNotesViewModel, viewManagerModel);
        DeleteNoteInputBoundary deleteNoteInteractor = new DeleteNoteInteractor(noteDataAccessObject, deleteNoteOutputBoundary);

        return new DeleteNoteController(deleteNoteInteractor);
    }
}
