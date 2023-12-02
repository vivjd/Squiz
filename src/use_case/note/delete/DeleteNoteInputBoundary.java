package use_case.note.delete;

/**
 * The DeleteNoteInputBoundary interface defines the contract for classes responsible for executing
 * the deletion of a note based on user input.
 */
public interface DeleteNoteInputBoundary {

    /**
     * Executes the note deletion process based on user input.
     *
     * @param deleteNoteInputData The input data containing information needed for note deletion.
     */
    void execute(DeleteNoteInputData deleteNoteInputData);
}
