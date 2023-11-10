package interface_adapter.quiz;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class QuizViewModel extends ViewModel {
    public static final String START_LABEL = "Start Quiz";
    public static final String EDIT_LABEL = "Edit Quiz";
    public static final String QUIZ_LABEL = "Quiz";

    public static final String BACK_LABEL = "Back";
    private QuizState state = new QuizState();

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public QuizState getState(){return state;}

    public QuizViewModel() {
        super("quiz");
    }

    public void setState(QuizState state){
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
