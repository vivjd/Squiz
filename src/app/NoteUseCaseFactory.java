package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.note.*;
import interface_adapter.note.display.DisplayNotesController;
import interface_adapter.note.display.DisplayNotesPresenter;
import interface_adapter.note.display.DisplayNotesViewModel;
import interface_adapter.note.save.SaveNoteController;
import interface_adapter.note.save.SaveNotePresenter;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesPresenter;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import use_case.note.NoteDataAccessInterface;
import use_case.note.display.DisplayNotesInputBoundary;
import use_case.note.display.DisplayNotesInteractor;
import use_case.note.display.DisplayNotesOutputBoundary;
import use_case.note.save.SaveNoteInputBoundary;
import use_case.note.save.SaveNoteInteractor;
import use_case.note.save.SaveNoteOutputBoundary;

import use_case.quiz.display.DisplayQuizzesInputBoundary;
import use_case.quiz.display.DisplayQuizzesInteractor;
import use_case.quiz.display.DisplayQuizzesOutputBoundary;
import use_case.quiz.QuizDataAccessInterface;
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

        SaveNoteOutputBoundary saveNoteOutputBoundary = new SaveNotePresenter(noteViewModel, viewManagerModel);
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
