package interface_adapter.note.display;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * The {@code DisplayNotesViewModel} class extends {@link ViewModel} and represents the
 * view model for the "Display Notes" view. It holds the state of the view, including the
 * table of notes and error messages for empty notes.
 *
 * <p>Instances of this class are responsible for notifying observers about changes in the
 * view state by firing property change events. It also provides methods for setting and
 * retrieving the view state.</p>
 *
 * <p><b>Note:</b> This class extends {@link ViewModel} and inherits its functionality for
 * managing the view name and firing property change events. It also encapsulates a
 * {@link DisplayNotesState} object to represent the state of the "Display Notes" view.</p>
 *
 * @see ViewModel
 * @see DisplayNotesState
 */
public class DisplayNotesViewModel extends ViewModel{
    public static final String DELETE_LABEL = "Delete Note";
    public static final String BACK_LABEL = "Back";
    public static final String NOTE_LABEL = "View Note";
    public static final String GENERATE_QUIZ_LABEL = "Generate Quiz";

    private DisplayNotesState state = new DisplayNotesState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * empty constructor responsible for creating a DisplayNotesViewModel
     */
    public DisplayNotesViewModel(){super("display_notes");}

    /**
     * Returns the state of the display notes view model
     * @return the current DisplayNotesState
     */
    public DisplayNotesState getState(){return state;}

    /**
     * Sets the state of the display notes view model
     * @param state is the DisplayNotesState of the use case
     */
    public void setState(DisplayNotesState state){this.state = state;}

    /**
     * Method is called to let the ViewModel know to alert the View
     */
    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}

    /**
     * Method is called to add PropertyChangeListeners
     * @param listener is the PropertyChangeListener
     */
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
