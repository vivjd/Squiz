package interface_adapter.quiz;
import interface_adapter.ViewModel;

import interface_adapter.quiz.display_quiz.DisplayQuizState;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

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
