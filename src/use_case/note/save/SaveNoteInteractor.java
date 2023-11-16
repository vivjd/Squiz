package use_case.note.save;

import entity.Note;
import use_case.note.NoteDataAccessInterface;

/**
 * The NoteInteractor will execute the save notes interaction using the Note entities, and collects the result in a NoteOutputData object.
 * The NotePresenter is invoked and the NoteOutputData object is passed in.
 */
public class SaveNoteInteractor implements SaveNoteInputBoundary {
    final NoteDataAccessInterface noteDataAccessObject;
    final SaveNoteOutputBoundary notePresenter;

    /**
     *
     * @param noteDataAccessObject the DAO for notes to access the Note entity.
     * @param saveNoteOutputBoundary the output data for notes.
     */
    public SaveNoteInteractor(NoteDataAccessInterface noteDataAccessObject, SaveNoteOutputBoundary saveNoteOutputBoundary) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.notePresenter = saveNoteOutputBoundary;
    }

    /**
     * This executes the use case interaction of saving notes and displays a new screen to the user.
     * @param saveNoteInputData the data that is inputted by the user from the initial state.
     */
    public void execute(SaveNoteInputData saveNoteInputData) {
        // Assume that the user always enters a valid input or the input is empty?
        String inputNote = saveNoteInputData.getInputText();
        String inputTitle = saveNoteInputData.getTitle();
        if (inputTitle.isEmpty()) {
            // Display a message telling the user to input a title
            notePresenter.prepareFailView("Please enter a title for your note.");
        } else if (inputNote.isEmpty()) {
            // Display a message telling the user to input contents for their note
            notePresenter.prepareFailView("Please enter a minimum of 40 words for your " + saveNoteInputData.getTitle() + " note.");
        } else {
            Note note = new Note(inputTitle, inputNote);
            noteDataAccessObject.saveNote(note);
            SaveNoteOutputData saveNoteOutputData = new SaveNoteOutputData(saveNoteInputData.getTitle(), inputNote, false);
            notePresenter.prepareSuccessView(saveNoteOutputData);
        }

    }
}
