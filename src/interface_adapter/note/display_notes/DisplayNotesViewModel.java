package interface_adapter.note.display_notes;

import interface_adapter.ViewModel;
import interface_adapter.note.display_notes.DisplayNotesState;

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

    private DisplayNotesState state = new DisplayNotesState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public DisplayNotesViewModel(){super("display_notes");}

    public DisplayNotesState getState(){return state;}

    public void setState(DisplayNotesState state){this.state = state;}

    @Override
    public void firePropertyChanged() {support.firePropertyChange("state", null, this.state);}

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
