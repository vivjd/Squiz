package use_case.note.save;

import data_access.NoteDataAccessObject;

import org.junit.Test;
import use_case.note.NoteDataAccessInterface;
import use_case.note.save.*;

import static org.junit.Assert.*;

public class SaveNoteInteractorTest {

    @Test
    public void successTest(){
        SaveNoteInputData inputData = new SaveNoteInputData("CSC207", "We love Java!");
        NoteDataAccessInterface noteRepository = new NoteDataAccessObject();

        SaveNoteOutputBoundary successPresenter = new SaveNoteOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveNoteOutputData note) {
                assertEquals("CSC207", note.getTitle());
                assertEquals("We love Java!", note.getInputText());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };
        SaveNoteInputBoundary interactor = new SaveNoteInteractor(noteRepository, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureEmptyTitleTest(){
        SaveNoteInputData inputData = new SaveNoteInputData("", "We love Java!");
        NoteDataAccessInterface noteRepository = new NoteDataAccessObject();

        SaveNoteOutputBoundary failurePresenter = new SaveNoteOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveNoteOutputData note) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Please enter a title for your note.", error);
            }
        };
        SaveNoteInputBoundary interactor = new SaveNoteInteractor(noteRepository, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureEmptyPromptTest(){
        SaveNoteInputData inputData = new SaveNoteInputData("CSC207", "");
        NoteDataAccessInterface noteRepository = new NoteDataAccessObject();

        SaveNoteOutputBoundary failurePresenter = new SaveNoteOutputBoundary() {
            @Override
            public void prepareSuccessView(SaveNoteOutputData note) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Please enter a minimum of 40 words for your " + inputData.getTitle() + " note.", error);
            }
        };
        SaveNoteInputBoundary interactor = new SaveNoteInteractor(noteRepository, failurePresenter);
        interactor.execute(inputData);
    }
}