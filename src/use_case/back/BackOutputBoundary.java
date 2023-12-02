package use_case.back;

/**
 * The {@code BackNotesOutputBoundary} interface defines methods for preparing views
 * in response to the success or failure of going back to the main page.
 *
 * <p>Implementing classes are responsible for handling the presentation of notes-related data
 * and error messages.</p>
 *
 */
public interface BackOutputBoundary {
    void prepareSuccessView();
    void prepareFailView();
}
