package interface_adapter;

import data_access.NoteDataAccessObject;
import entity.Note;

public class NoteController {

    final NoteInputBoundary noteUseCaseInteractor;
    public NoteController(NoteInputBoundary noteUseCaseInteractor) {
        this.noteUseCaseInteractor = noteUseCaseInteractor;
    }
    public void execute(String title, Note inputText) {
        NoteInputData noteInputData = new NoteInputData(
                title, inputText);
        NoteUseCaseInteractor.execute(loginInputData);
    }
}