package interface_adapter.quiz.take_quiz;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TakeQuizViewModel extends ViewModel {

    private TakeQuizState state = new TakeQuizState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public TakeQuizViewModel() {
        super("take_quiz");
    }

    public TakeQuizState getState() {
        return state;
    }

    public void setState(TakeQuizState state) {
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
