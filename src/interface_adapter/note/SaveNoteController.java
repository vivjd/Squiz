package interface_adapter.note;

import use_case.note.save.SaveNoteInputBoundary;
import use_case.note.save.SaveNoteInputData;

public class SaveNoteController {

    final SaveNoteInputBoundary noteUseCaseInteractor;

    /**
     * This constructor creates a NoteController object.
     * @param noteUseCaseInteractor the interactor of the current Note usecase.
     */
    public SaveNoteController(SaveNoteInputBoundary noteUseCaseInteractor) {
        this.noteUseCaseInteractor = noteUseCaseInteractor;
    }

    /**
     * This method calls the interactor to continue with the code execution.
     * @param title the title of the note as inputted by the user
     * @param inputText the body of the note
     */
    public void execute(String title, String inputText) {
        SaveNoteInputData saveNoteInputData = new SaveNoteInputData(title, inputText);
        this.noteUseCaseInteractor.execute(saveNoteInputData);
    }
}