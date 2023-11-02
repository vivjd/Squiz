package interface_adapter.note;

import use_case.note.NoteInputBoundary;
import use_case.note.NoteInputData;

public class NoteController {

    final NoteInputBoundary noteUseCaseInteractor;

    /**
     * This constructor creates a NoteController object.
     * @param noteUseCaseInteractor the interactor of the current Note usecase.
     */
    public NoteController(NoteInputBoundary noteUseCaseInteractor) {
        this.noteUseCaseInteractor = noteUseCaseInteractor;
    }

    /**
     * This method calls the interactor to continue with the code execution.
     * @param title the title of the note as inputted by the user
     * @param inputText the body of the note
     */
    public void execute(String title, String inputText) {
        NoteInputData noteInputData = new NoteInputData(title, inputText);
        this.noteUseCaseInteractor.execute(noteInputData);
    }
}