package interface_adapter.question;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class representing the state and properties for the question interface.
 */
public class QuestionViewModel extends ViewModel {

    /**
     * Constant representing the title label for the question page.
     */
    public static final String TITLE_LABEL = "Question Page";

    /**
     * Constant representing the label for the question.
     */
    public static final String QUESTION_LABEL = "Question";

    /**
     * Constant representing the label for the submit button.
     */
    public static final String SUBMIT_BUTTON_LABEL = "Submit Answer";

    /**
     * The state of answering a question.
     */
    public AnswerQuestionState state = new AnswerQuestionState();

    /**
     * The property change support for notifying listeners about changes in the view model.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * Constructs a new QuestionViewModel with the specified view name.
     */
    public QuestionViewModel() {
        super("answer_question");
    }

    /**
     * Gets the current state of answering a question.
     *
     * @return The current state of answering a question.
     */
    public AnswerQuestionState getState() {
        return state;
    }

    /**
     * Sets the state of answering a question.
     *
     * @param state The new state of answering a question.
     */
    public void setState(AnswerQuestionState state) {
        this.state = state;
    }

    /**
     * Notifies listeners about changes in the view model's state.
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
