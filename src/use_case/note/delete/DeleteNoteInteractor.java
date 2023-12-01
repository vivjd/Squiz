package use_case.note.delete;

import use_case.note.NoteDataAccessInterface;

/**
 * The DeleteNoteInteractor class is responsible for handling the business logic of deleting a note.
 * It implements the DeleteNoteInputBoundary interface.
 */
public class DeleteNoteInteractor implements DeleteNoteInputBoundary {

    final NoteDataAccessInterface noteDataAccessObject;
    final DeleteNoteOutputBoundary deleteNoteOutputBoundary;

    /**
     * Constructs a DeleteNoteInteractor with the specified dependencies.
     *
     * @param noteDataAccessObject      The data access object responsible for interacting with notes.
     * @param deleteNoteOutputBoundary The output boundary for presenting results of note deletion.
     */
    public DeleteNoteInteractor(NoteDataAccessInterface noteDataAccessObject,
                                DeleteNoteOutputBoundary deleteNoteOutputBoundary) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.deleteNoteOutputBoundary = deleteNoteOutputBoundary;
    }


    /**
     * Executes the process of deleting a note based on the input data.
     *
     * @param deleteNoteInputData The input data containing the ObjectId of the note to be deleted.
     */
    @Override
    public void execute(DeleteNoteInputData deleteNoteInputData) {
        try {
            noteDataAccessObject.deleteNote(deleteNoteInputData.getObjectId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
