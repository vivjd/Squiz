package interface_adapter.quiz.delete;

import interface_adapter.ViewModel;

import interface_adapter.quiz.display.DisplayQuizzesState;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteQuizViewModel extends ViewModel {
    public final String TITLE_LABEL = "Delete Quiz View";
    public static final String DELETE_LABEL = "Delete";

    public DeleteQuizState state = new DeleteQuizState();

    public DeleteQuizViewModel() {
        super("delete quiz");
    }

    public void setState(DeleteQuizState state) {
        this.state = state;
    }

    public DeleteQuizState getState(){
        return state;
    }

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
