package interface_adapter.back;

import use_case.back.BackOutputBoundary;

/**
 * The {@code BackController} class serves as the controller for the "Back" use case.
 *
 */
public class BackController {
    BackOutputBoundary backPresenter;

    /**
     * Constructor to create controller for the "Back" use case
     * @param backPresenter is the Presenter of the "Back" use case
     */
    public BackController(BackOutputBoundary backPresenter) {this.backPresenter = backPresenter;}

    /**
     * Executes the "Back" use case by invoking the corresponding method on the Back Presenter to
     * show the Main Page in the program
     */
    public void execute(){
        backPresenter.prepareSuccessView();
    }
}
