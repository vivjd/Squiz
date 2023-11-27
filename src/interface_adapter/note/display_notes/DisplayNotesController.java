package interface_adapter.note.display_notes;

import use_case.note.display_notes.DisplayNotesInputBoundary;

/**
 * The {@code DisplayNotes Controller} class serves as the controller for the "Display Notes" use case.
 *
 * @see DisplayNotesInputBoundary
 */
public class DisplayNotesController {
    final DisplayNotesInputBoundary displayNotesUseCaseInteractor;

    public DisplayNotesController(DisplayNotesInputBoundary displayNotesUseCaseInteractor) {
        this.displayNotesUseCaseInteractor = displayNotesUseCaseInteractor;
    }

    /**
     * Executes the "Display Notes" use case by invoking the corresponding method
     * on the {@link DisplayNotesInputBoundary} instance.
     */
    public void execute(){
        this.displayNotesUseCaseInteractor.execute();
    }
}
