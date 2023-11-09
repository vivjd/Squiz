package view;

import interface_adapter.quiz.DisplayQuizController;
import interface_adapter.quiz.QuizViewModel;
import interface_adapter.quiz.QuizState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuizView extends JPanel implements PropertyChangeListener {
    public final String viewName = "quiz";
    private final QuizViewModel quizViewModel;

    final JButton start;
    final JButton back;
    private final DisplayQuizController displayQuizController;

    public QuizView(QuizViewModel quizViewModel, DisplayQuizController controller) {
        this.quizViewModel = quizViewModel;
        this.displayQuizController = controller;

        quizViewModel.addPropertyChangeListener(this);

        JPanel buttons = new JPanel();
        start = new JButton(QuizViewModel.START_LABEL);
        back = new JButton(QuizViewModel.BACK_LABEL);
        buttons.add(start);
        buttons.add(back);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        QuizState state = (QuizState) evt.getNewValue();
    }
}
