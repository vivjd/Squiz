package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.delete.DeleteNoteController;
import interface_adapter.note.delete.DeleteNotePresenter;
import interface_adapter.note.NoteViewModel;
import interface_adapter.note.back.BackController;
import interface_adapter.note.back.BackPresenter;
import interface_adapter.note.display.DisplayNotesController;
import interface_adapter.note.display.DisplayNotesPresenter;
import interface_adapter.note.display.DisplayNotesViewModel;
import interface_adapter.quiz.GenerateQuizController;
import interface_adapter.quiz.GenerateQuizPresenter;
import use_case.note.NoteDataAccessInterface;
import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInteractor;
import use_case.note.delete.DeleteNoteOutputBoundary;
import use_case.note.display.DisplayNotesInputBoundary;
import use_case.note.display.DisplayNotesInteractor;
import use_case.note.display.DisplayNotesOutputBoundary;
import use_case.quiz.GenerateQuizInputBoundary;
import use_case.quiz.GenerateQuizInteractor;
import use_case.quiz.GenerateQuizOutputBoundary;
import view.DisplayNotesView;

public class DisplayNotesUseCaseFactory {
    private DisplayNotesUseCaseFactory() {}

    public static DisplayNotesView create(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject,
            NoteViewModel noteViewModel) {

        DisplayNotesController controller = createDisplayNotesUseCase(viewManagerModel, displayNotesViewModel, noteDataAccessObject);
        DeleteNoteController deleteNoteController = deleteNoteUseCase(viewManagerModel, displayNotesViewModel, noteDataAccessObject);
        BackPresenter backPresenter = new BackPresenter(noteViewModel, viewManagerModel);
        BackController backController = new BackController(backPresenter);
        GenerateQuizController generateQuizController = generateQuizUseCase();

        return new DisplayNotesView(displayNotesViewModel, controller, deleteNoteController, backController, generateQuizController);
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

    private static GenerateQuizController generateQuizUseCase(){
        GenerateQuizOutputBoundary generateQuizOutputBoundary = new GenerateQuizPresenter();
        GenerateQuizInputBoundary generateQuizInteractor = new GenerateQuizInteractor(generateQuizOutputBoundary);

        return new GenerateQuizController(generateQuizInteractor);
    }
}
