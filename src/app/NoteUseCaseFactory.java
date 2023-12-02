package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.*;
import interface_adapter.quiz.GenerateQuizController;
import interface_adapter.note.display_notes.DisplayNotesController;
import interface_adapter.note.display_notes.DisplayNotesPresenter;
import interface_adapter.note.display_notes.DisplayNotesViewModel;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesPresenter;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import use_case.note.NoteDataAccessInterface;
import use_case.note.display_notes.DisplayNotesInputBoundary;
import use_case.note.display_notes.DisplayNotesInteractor;
import use_case.note.display_notes.DisplayNotesOutputBoundary;
import use_case.note.save.SaveNoteInputBoundary;
import use_case.note.save.SaveNoteInteractor;
import use_case.note.save.SaveNoteOutputBoundary;

import use_case.quiz.display.DisplayQuizzesInputBoundary;
import use_case.quiz.display.DisplayQuizzesInteractor;
import use_case.quiz.display.DisplayQuizzesOutputBoundary;
import use_case.quiz.QuizDataAccessInterface;
import view.NoteView;

/**
 * The NoteUseCaseFactory class is responsible for creating and initializing the components
 * necessary for the Note feature, including the NoteView, SaveNoteController, DisplayQuizzesController,
 * and DisplayNotesController. It encapsulates the instantiation of controllers and associated input
 * and output boundaries, facilitating the separation of concerns in the architecture.
 */
public class NoteUseCaseFactory {
    private NoteUseCaseFactory() {
    }

    /**
     * Creates an instance of the NoteView by initializing the required components,
     * such as the SaveNoteController, DisplayQuizzesController, and DisplayNotesController.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param noteViewModel              The NoteViewModel representing the data for the note.
     * @param noteDataAccessObject       The NoteDataAccessInterface for accessing note-related data.
     * @param displayQuizzesViewModel    The DisplayQuizzesViewModel representing the data for displaying quizzes.
     * @param quizDataAccessObject       The QuizDataAccessInterface for accessing quiz-related data.
     * @param displayNotesViewModel      The DisplayNotesViewModel representing the data for displaying notes.
     * @return The created NoteView instance.
     */
    public static NoteView create(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject,
            DisplayQuizzesViewModel displayQuizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            DisplayNotesViewModel displayNotesViewModel) {

        SaveNoteController saveNoteController = createSaveNoteUseCase(viewManagerModel, noteViewModel, noteDataAccessObject);
        DisplayQuizzesController displayQuizzesController = createDisplayQuizzesUseCase(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        DisplayNotesController displayNotesController = createDisplayNotesUseCase(viewManagerModel, displayNotesViewModel, noteDataAccessObject);

        return new NoteView(saveNoteController, noteViewModel, displayQuizzesController, displayQuizzesViewModel, displayNotesController, displayNotesViewModel);
    }

    /**
     * Creates an instance of the SaveNoteController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param noteViewModel              The NoteViewModel representing the data for the note.
     * @param noteDataAccessObject       The NoteDataAccessInterface for accessing note-related data.
     * @return The created SaveNoteController instance.
     */
    private static SaveNoteController createSaveNoteUseCase(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        SaveNoteOutputBoundary saveNoteOutputBoundary = new SaveSaveNotePresenter(noteViewModel, viewManagerModel);
        SaveNoteInputBoundary noteInteractor = new SaveNoteInteractor(noteDataAccessObject, saveNoteOutputBoundary);

        return new SaveNoteController(noteInteractor);
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
     * Creates an instance of the DisplayQuizzesController by initializing the associated input and output boundaries.
     *
     * @param viewManagerModel           The ViewManagerModel responsible for managing views in the application.
     * @param quizzesViewModel           The DisplayQuizzesViewModel representing the data for displaying quizzes.
     * @param quizDataAccessObject       The QuizDataAccessInterface for accessing quiz-related data.
     * @return The created DisplayQuizzesController instance.
     */
    private static DisplayQuizzesController createDisplayQuizzesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel quizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject) {
        DisplayQuizzesOutputBoundary displayQuizzesOutputBoundary = new DisplayQuizzesPresenter(quizzesViewModel, viewManagerModel);
        DisplayQuizzesInputBoundary displayQuizzesInteractor = new DisplayQuizzesInteractor(quizDataAccessObject, displayQuizzesOutputBoundary);

        return new DisplayQuizzesController(displayQuizzesInteractor);
    }
}
