package interface_adapter.note;

import org.bson.types.ObjectId;
import use_case.note.DeleteNoteInputBoundary;
import use_case.note.DeleteNoteInputData;

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
