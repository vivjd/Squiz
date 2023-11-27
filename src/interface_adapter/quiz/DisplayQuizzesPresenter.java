package interface_adapter.quiz;

import interface_adapter.ViewManagerModel;
import use_case.quiz.display.DisplayQuizzesOutputBoundary;
import use_case.quiz.display.DisplayQuizzesOutputData;

/**
 * The {@code DisplayQuizzesPresenter} class implements the {@link DisplayQuizzesOutputBoundary}
 * interface to handle the presentation of output data from the "Display Quizzes" use case.
 *
 * <p>This presenter is responsible for preparing the view model ({@link DisplayQuizzesViewModel}) based
 * on the output data received from the use case. It updates the state of the view model, fires property
 * change events to notify observers, and sets the active view in the {@link ViewManagerModel}.</p>
 *
 * @see DisplayQuizzesOutputBoundary
 * @see DisplayQuizzesViewModel
 * @see ViewManagerModel
 */
public class DisplayQuizzesPresenter implements DisplayQuizzesOutputBoundary {
    private final DisplayQuizzesViewModel displayQuizzesViewModel;

    private ViewManagerModel viewManagerModel;

    public DisplayQuizzesPresenter(DisplayQuizzesViewModel displayQuizzesViewModel, ViewManagerModel viewManagerModel){
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Prepares the view for a successful execution of the "Display Quizzes" use case.
     *
     * @param quiz The output data containing information about displayed quizzes.
     */
    @Override
    public void prepareSuccessView(DisplayQuizzesOutputData quiz) {
        DisplayQuizzesState quizState = displayQuizzesViewModel.getState();
        quizState.setQuizzesTable(quiz.getQuizzes());

        this.displayQuizzesViewModel.setState(quizState);
        displayQuizzesViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(displayQuizzesViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a failed execution of the "Display Quizzes" use case.
     *
     * @param error The error message indicating the reason for the failure.
     */
    @Override
    public void prepareFailView(String error) {
        DisplayQuizzesState quizState = displayQuizzesViewModel.getState();
        quizState.setEmptyQuizError(error);
        displayQuizzesViewModel.firePropertyChanged();
    }
}
