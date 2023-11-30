package interface_adapter.question;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class QuestionViewModel extends ViewModel {
    public static final String TITLE_LABEL = "Question Page";
    public static final String QUESTION_LABEL = "Question";
    public static final String SUBMIT_BUTTON_LABEL = "Submit Answer";

    public QuestionViewModel() {
        super("answer_question");
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public AnswerQuestionState state = new AnswerQuestionState();

    public AnswerQuestionState getState() {
        return state;
    }

    public void setState(AnswerQuestionState state) {
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
