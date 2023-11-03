package interface_adapter.note;

import org.bson.types.ObjectId;
import use_case.note.delete.DeleteNoteInputBoundary;
import use_case.note.delete.DeleteNoteInputData;

public class DeleteNoteController {

    final DeleteNoteInputBoundary deleteNoteInteractor;

    public DeleteNoteController(DeleteNoteInputBoundary deleteNoteInteractor) {
        this.deleteNoteInteractor = deleteNoteInteractor;
    }

    public void execute(ObjectId objectId) {
        DeleteNoteInputData deleteNoteInputData= new DeleteNoteInputData(objectId);

        deleteNoteInteractor.execute(deleteNoteInputData);
    }

}
