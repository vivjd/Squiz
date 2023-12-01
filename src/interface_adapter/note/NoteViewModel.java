package interface_adapter.note;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NoteViewModel extends ViewModel {

    public static final String SUBMIT_BUTTON_LABEL = "Generate Quiz";
    public static final String SAVE_LABEL = "Save Note";
    public static final String ALL_QUIZZES_LABEL = "View All Quizzes";

    public static final String ALL_NOTES_LABEL = "View All Notes";

    public static final String TITLE_LABEL = "Note Page";

    public static final String NOTE_LABEL = "Note";

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
