package use_case.note.display;

import org.bson.types.ObjectId;

/**
 * The {@code DisplayNotesOutputData} class represents the output data for displaying all notes.
 *
 * <p>It encapsulates information about notes, including the note data and a flag indicating
 * whether the use case for displaying notes has failed.</p>
 *
 */
public class DisplayNotesOutputData {
    /**
     * A 2D array representing the notes data, which contains all the notes stored in the database.
     * Each array contains relevant information pertaining to the note that will be displayed to the user.
     */
    private final String[][] notes;
    private final ObjectId[] ids;

    /**
     * A flag indicating whether the use case for displaying quizzes has failed.
     */
    private boolean useCaseFailed;

    /**
     * Constructs a new {@code DisplayNotesOutputData} with the specified (most likely the ones in the database) quizzes.
     * @param notes The 2D array representing the notes.
     */
    public DisplayNotesOutputData(String[][] notes, ObjectId[] ids) {
        this.notes = notes;
        this.ids = ids;
    }

    /**
     * Returns 2D array representing the current notes data found in the Database
     * @return 2D array of notes data
     */
    public String[][] getNotes() {return notes;}

    /**
     * Returns array of the current notes' ObjectID found in the Database
     * @return array of ObjectId of each notes
     */
    public ObjectId[] getIds() {return ids;}
}
