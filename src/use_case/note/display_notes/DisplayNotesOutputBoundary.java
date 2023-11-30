package use_case.note.display_notes;

/**
 * The {@code DisplayNotesOutputBoundary} interface defines methods for preparing views
 * in response to the success or failure of displaying all notes.
 *
 * <p>Implementing classes are responsible for handling the presentation of notes-related data
 * and error messages.</p>
 *
 */
public interface DisplayNotesOutputBoundary {
    /**
     * Method is responsible for displaying the success
     * @param note is the note data to present to the user
     */
    void prepareSuccessView(DisplayNotesOutputData note);

    /**
     * Method is responsible for displaying the failure of the program
     * @param error is a String that tells the user the error it is
     */
    void prepareFailView(String error);
}
