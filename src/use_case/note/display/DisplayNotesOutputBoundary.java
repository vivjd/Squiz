package use_case.note.display;

/**
 * The {@code DisplayNotesOutputBoundary} interface defines methods for preparing views
 * in response to the success or failure of displaying all notes.
 *
 * <p>Implementing classes are responsible for handling the presentation of notes-related data
 * and error messages.</p>
 *
 */
public interface DisplayNotesOutputBoundary {
    void prepareSuccessView(DisplayNotesOutputData quiz);
    void prepareFailView(String error);
}
