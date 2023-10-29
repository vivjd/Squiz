package interface_adapter.note;

import interface_adapter.ViewModel;
import interface_adapter.note.NoteState;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NoteViewModel extends ViewModel {

    public static final String SUBMIT_BUTTON_LABEL = "Generate Quiz";
    public static final String SAVE_LABEL = "Save Note";
    public static final String EDIT_LABEL = "Edit Quiz";
    public static final String TITLE_LABEL = "Note Page";

    private NoteState state = new NoteState();

    public NoteViewModel(){super("note");}

    public void setState(NoteState state) {this.state = state;}

    public NoteState getState() {return state;}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
