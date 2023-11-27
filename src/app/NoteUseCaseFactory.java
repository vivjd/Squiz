package app;

import data_access.NoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.*;

import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesPresenter;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;

import use_case.note.NoteDataAccessInterface;
import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInteractor;
import use_case.note.delete.DeleteNoteOutputBoundary;
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
            QuizDataAccessInterface quizDataAccessObject) {

        SaveNoteController saveNoteController = createSaveNoteUseCase(viewManagerModel, noteViewModel, noteDataAccessObject);
        DisplayQuizzesController displayQuizzesController = createDisplayQuizzesUseCase(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        return new NoteView(saveNoteController, noteViewModel, displayQuizzesController, displayQuizzesViewModel);
    }

    private static SaveNoteController createSaveNoteUseCase(
            ViewManagerModel viewManagerModel,
            NoteViewModel noteViewModel,
            NoteDataAccessInterface noteDataAccessObject) {

        SaveNoteOutputBoundary saveNoteOutputBoundary = new SaveSaveNotePresenter(noteViewModel, viewManagerModel);
        SaveNoteInputBoundary noteInteractor = new SaveNoteInteractor(noteDataAccessObject, saveNoteOutputBoundary);

        return new SaveNoteController(noteInteractor);
    }

    private static DisplayQuizzesController createDisplayQuizzesUseCase(
            ViewManagerModel viewManagerModel,
            DisplayQuizzesViewModel quizzesViewModel,
            QuizDataAccessInterface quizDataAccessObject) {
        DisplayQuizzesOutputBoundary displayQuizzesOutputBoundary = new DisplayQuizzesPresenter(quizzesViewModel, viewManagerModel);
        DisplayQuizzesInputBoundary displayQuizzesInteractor = new DisplayQuizzesInteractor(quizDataAccessObject, displayQuizzesOutputBoundary);

        return new DisplayQuizzesController(displayQuizzesInteractor);
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
