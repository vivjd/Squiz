package interface_adapter.question;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The {@code QuestionViewModel} class serves as a view model for the answer question view,
 * encapsulating the state of the view and providing access to relevant labels and constants.
 * It extends the {@link ViewModel} class and implements property change support for binding
 * with UI components.
 */
public class QuestionViewModel extends ViewModel {
    /**
     * The constant label for the title of the question page.
     */
    public static final String TITLE_LABEL = "Question Page";

    /**
     * The constant label for displaying the question.
     */
    public static final String QUESTION_LABEL = "Question";

    /**
     * The constant label for the submit answer button.
     */
    public static final String SUBMIT_BUTTON_LABEL = "Submit Answer";

    /**
     * Constructs a {@code QuestionViewModel} with the specified view name.
     */
    public QuestionViewModel() {
        super("answer_question");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * The state representing the current state of the answer question view.
     */
    public AnswerQuestionState state = new AnswerQuestionState();

    /**
     * Gets the current state of the answer question view.
     *
     * @return The current state of the view.
     */
    public AnswerQuestionState getState() {
        return state;
    }

    /**
     * Sets the state of the answer question view.
     *
     * @param state The new state to set.
     */
    public void setState(AnswerQuestionState state) {
        this.state = state;
    }

    /**
     * Fires a property change event to notify listeners of changes to the view model state.
     */
    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    /**
     * Adds a property change listener to the view model.
     *
     * @param listener The listener to be added.
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
