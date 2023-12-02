package interface_adapter.quiz.take_quiz;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * ViewModel class representing the state and properties for the take quiz interface.
 */
public class TakeQuizViewModel extends ViewModel {

    /**
     * The state of the quiz-taking session.
     */
    private TakeQuizState state = new TakeQuizState();

    /**
     * Constructs a new TakeQuizViewModel with the specified view name.
     */
    public TakeQuizViewModel() {
        super("take_quiz");
    }

    /**
     * Gets the current state of the quiz-taking session.
     *
     * @return The current state of the quiz-taking session.
     */
    public TakeQuizState getState() {
        return state;
    }

    /**
     * Sets the state of the quiz-taking session.
     *
     * @param state The new state of the quiz-taking session.
     */
    public void setState(TakeQuizState state) {
        this.state = state;
    }

    /**
     * The property change support for notifying listeners about changes in the view model.
     */
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

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
