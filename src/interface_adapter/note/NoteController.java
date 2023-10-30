package interface_adapter.note;

import data_access.NoteDataAccessObject;
import use_case.note.NoteInputBoundary;
import use_case.note.NoteInputData;

public class NoteController {

    final NoteInputBoundary noteUseCaseInteractor;
    public NoteController(NoteInputBoundary noteUseCaseInteractor) {
        this.noteUseCaseInteractor = noteUseCaseInteractor;
    }
    public void execute(String title, String inputText) {
        NoteInputData noteInputData = new NoteInputData(title, inputText);
        this.noteUseCaseInteractor.execute(noteInputData);
    }
}