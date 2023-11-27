package interface_adapter.quiz;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The {@code DisplayQuizzesViewModel} class extends {@link ViewModel} and represents the
 * view model for the "Display Quizzes" view. It holds the state of the view, including the
 * table of quizzes and error messages for empty quizzes.
 *
 * <p>Instances of this class are responsible for notifying observers about changes in the
 * view state by firing property change events. It also provides methods for setting and
 * retrieving the view state.</p>
 *
 * <p><b>Note:</b> This class extends {@link ViewModel} and inherits its functionality for
 * managing the view name and firing property change events. It also encapsulates a
 * {@link DisplayQuizzesState} object to represent the state of the "Display Quizzes" view.</p>
 *
 * @see ViewModel
 * @see DisplayQuizzesState
 */
public class DisplayQuizzesViewModel extends ViewModel {
    public static final String START_LABEL = "Start Quiz";
    public static final String EDIT_LABEL = "Edit Quiz";
    public static final String QUIZ_LABEL = "Quiz";

    public static final String BACK_LABEL = "Back";
    private DisplayQuizzesState state = new DisplayQuizzesState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DisplayQuizzesState getState(){return state;}

    public DisplayQuizzesViewModel() {
        super("quiz");
    }

    public void setState(DisplayQuizzesState state){
        this.state = state;
    }

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
