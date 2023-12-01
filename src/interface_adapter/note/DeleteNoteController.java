package interface_adapter.note;

import org.bson.types.ObjectId;
import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInputData;

/**
 * The DeleteNoteController class is responsible for handling user input related to note deletion.
 */
public class DeleteNoteController {

    final DeleteNoteInputBoundary deleteNoteInteractor;

    /**
     * Constructs a DeleteNoteController with the specified interactor.
     *
     * @param deleteNoteInteractor The interactor responsible for handling the delete note use case.
     */
    public DeleteNoteController(DeleteNoteInputBoundary deleteNoteInteractor) {
        this.deleteNoteInteractor = deleteNoteInteractor;
    }

    /**
     * Executes the note deletion based on the provided ObjectId.
     *
     * @param objectId The ObjectId of the note to be deleted.
     */
    public void execute(ObjectId objectId) {
        DeleteNoteInputData deleteNoteInputData= new DeleteNoteInputData(objectId);

        deleteNoteInteractor.execute(deleteNoteInputData);
    }

}
