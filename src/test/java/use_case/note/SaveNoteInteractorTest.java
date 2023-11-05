package use_case.note;

import data_access.NoteDataAccessObject;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SaveNoteInteractorTest {

    @Test
    void successTest(){
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
    void failureEmptyTitleTest(){
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
    void failureEmptyPromptTest(){
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