package use_case.note.display;

import entity.Note;
import org.bson.types.ObjectId;
import use_case.note.NoteDataAccessInterface;

import java.util.List;

/**
 * The {@code DisplayNotesInteractor} class is responsible for executing the display of notes
 * in the database by interacting with the provided data access object and presenting the
 * results through the {@link DisplayNotesOutputBoundary} output boundary.
 *
 * <p>This class implements the {@link DisplayNotesInputBoundary} interface.</p>
 *
 */
public class DisplayNotesInteractor implements DisplayNotesInputBoundary {
    final NoteDataAccessInterface noteDataAccessObject;
    final DisplayNotesOutputBoundary notesPresenter;

    /**
     * Constructs a new {@code DisplayQuizzesInteractor} with the specified dependencies.
     *
     * @param noteDataAccessObject The data access object providing access to note information.
     * @param notesPresenter        The presenter for displaying all the notes in the database.
     */
    public DisplayNotesInteractor(NoteDataAccessInterface noteDataAccessObject, DisplayNotesOutputBoundary notesPresenter) {
        this.noteDataAccessObject = noteDataAccessObject;
        this.notesPresenter = notesPresenter;
    }

    /**
     * Executes the display of notes. Retrieves all notes from the data access object and
     * prepares the data for presentation through the output boundary.
     */
    @Override
    public void execute() {
        List<Note> notes = noteDataAccessObject.getAllNotes();

        if (notes.isEmpty()) {
            notesPresenter.prepareFailView("There are no saved notes to display. Please create a note first and save it.");
        } else {
            String[][] table = noteDataAccessObject.getAllNotesTable();
            ObjectId[] ids = noteDataAccessObject.getAllIds();
            DisplayNotesOutputData displayNotesOutputData = new DisplayNotesOutputData(table, ids);
            notesPresenter.prepareSuccessView(displayNotesOutputData);
        }
    }

}
