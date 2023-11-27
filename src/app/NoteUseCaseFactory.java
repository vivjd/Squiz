package app;

import data_access.NoteDataAccessObject;
import data_access.QuizDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.*;
import interface_adapter.note.display_notes.DisplayNotesController;
import interface_adapter.note.display_notes.DisplayNotesPresenter;
import interface_adapter.note.display_notes.DisplayNotesViewModel;
import interface_adapter.quiz.*;
import use_case.note.NoteDataAccessInterface;
import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInteractor;
import use_case.note.delete.DeleteNoteOutputBoundary;
import use_case.note.display_notes.DisplayNotesInputBoundary;
import use_case.note.display_notes.DisplayNotesInteractor;
import use_case.note.display_notes.DisplayNotesOutputBoundary;
import use_case.note.save.SaveNoteInputBoundary;
import use_case.note.save.SaveNoteInteractor;
import use_case.note.save.SaveNoteOutputBoundary;

import use_case.quiz.DisplayQuizzesInputBoundary;
import use_case.quiz.DisplayQuizzesInteractor;
import use_case.quiz.DisplayQuizzesOutputBoundary;
import use_case.quiz.QuizDataAccessInterface;
import view.DisplayQuizzesView;
import view.NoteView;

public class NoteUseCaseFactory {
    private NoteUseCaseFactory() {
    }

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

    private static SaveNoteController createSaveNoteUseCase(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        SaveNoteOutputBoundary saveNoteOutputBoundary = new SaveSaveNotePresenter(noteViewModel, viewManagerModel);
        SaveNoteInputBoundary noteInteractor = new SaveNoteInteractor(noteDataAccessObject, saveNoteOutputBoundary);

        return new SaveNoteController(noteInteractor);
    }

    private static DisplayNotesController createDisplayNotesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayNotesViewModel displayNotesViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        DisplayNotesOutputBoundary displayNotesOutputBoundary = new DisplayNotesPresenter(displayNotesViewModel, viewManagerModel);
        DisplayNotesInputBoundary displayNotesInteractor = new DisplayNotesInteractor(noteDataAccessObject, displayNotesOutputBoundary);
        return new DisplayNotesController(displayNotesInteractor);
    }

    private static DisplayQuizzesController createDisplayQuizzesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel quizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject) {
        DisplayQuizzesOutputBoundary displayQuizzesOutputBoundary = new DisplayQuizzesPresenter(quizzesViewModel, viewManagerModel);
        DisplayQuizzesInputBoundary displayQuizzesInteractor = new DisplayQuizzesInteractor(quizDataAccessObject, displayQuizzesOutputBoundary);

        return new DisplayQuizzesController(displayQuizzesInteractor);
    }
}
