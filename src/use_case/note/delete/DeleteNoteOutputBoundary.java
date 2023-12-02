package use_case.note.delete;

/**
 * The DeleteNoteOutputBoundary interface defines the contract for classes responsible for
 * presenting the results of the note deletion process.
 */
public interface DeleteNoteOutputBoundary {

    /**
     * Prepares a success view for the note deletion.
     */
    void prepareSuccessView();

    /**
     * Prepares a fail view for the note deletion with the given error message.
     *
     * @param error A string representing the error or failure information.
     */
    void prepareFailView(String error);
}
