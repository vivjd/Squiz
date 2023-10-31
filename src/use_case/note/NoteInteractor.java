package use_case.note;

import data_access.NoteDataAccessObject;
import entity.Note;

/**
 * The NoteInteractor will execute the save notes interaction using the Note entities, and collects the result in a NoteOutputData object.
 * The NotePresenter is invoked and the NoteOutputData object is passed in.
 */
public class NoteInteractor implements NoteInputBoundary {
    final NoteDataAccessObject noteDataAccessObject;
    final NoteOutputBoundary notePresenter;

    /**
     *
     * @param noteDataAccessObject the DAO for notes to access the Note entity.
     * @param noteOutputBoundary the output data for notes.
     */
    public NoteInteractor(NoteDataAccessObject noteDataAccessObject, NoteOutputBoundary noteOutputBoundary) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.notePresenter = noteOutputBoundary;
    }

    /**
     * This executes the use case interaction of saving notes and displays a new screen to the user.
     * @param noteInputData the data that is inputted by the user from the initial state.
     */
    public void execute(NoteInputData noteInputData) {
        // Assume that the user always enters a valid input or the input is empty?
        String inputNote = noteInputData.getInputText();
        if (noteInputData.getTitle().isEmpty()) {
            // Display a message telling the user to input a title
            notePresenter.prepareFailView("Please enter a title for your note.");
        } else if (noteInputData.getInputText().isEmpty()) {
            // Display a message telling the user to input contents for their note
            notePresenter.prepareFailView("Please enter a minimum of 40 words for your " + noteInputData.getTitle() + " note.");
        } else {
            Note note = noteDataAccessObject.getNote(noteInputData.getTitle());
            NoteOutputData noteOutputData = new NoteOutputData(noteInputData.getTitle(), inputNote, false);
            notePresenter.prepareSuccessView(noteOutputData);
        }

    }
}
