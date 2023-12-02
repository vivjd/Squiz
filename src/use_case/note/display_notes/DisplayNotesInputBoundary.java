package use_case.note.display_notes;

/**
 * This interface defines methods for the execution of the use case in response to the user's
 * interaction with the program
 *
 * <p>Implementing classes are responsible for handling the execution of the use case </p>
 */
public interface DisplayNotesInputBoundary {
    /**
     * Executes the "Display Notes" use case, presenting all the notes to the user.
     */
    void execute();
}
