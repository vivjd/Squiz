package use_case.note.delete;

import org.bson.types.ObjectId;

/**
 * The DeleteNoteInputData class represents input data for the note deletion process.
 */
public class DeleteNoteInputData {


    private final ObjectId objectId;

    /**
     * Constructs a DeleteNoteInputData object with the specified ObjectId.
     *
     * @param objectId The ObjectId of the note to be deleted.
     */
    public DeleteNoteInputData(ObjectId objectId) {
        this.objectId = objectId;
    }

    /**
     * Retrieves the ObjectId of the note to be deleted.
     *
     * @return The ObjectId of the note.
     */
    public ObjectId getObjectId() {
        return objectId;
    }
}
