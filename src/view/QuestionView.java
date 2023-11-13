package view;

import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionState;
import interface_adapter.question.QuestionViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuestionView extends JPanel implements PropertyChangeListener {
    public final String viewName = "question";
    private final JButton submit;
    private final QuestionViewModel questionViewModel;

    private final AnswerQuestionController answerQuestionController;

    public QuestionView(QuestionViewModel questionViewModel, AnswerQuestionController controller){
        this.questionViewModel = questionViewModel;
        this.answerQuestionController = controller;

        questionViewModel.addPropertyChangeListener(this);

        JPanel buttons = new JPanel();
        submit = new JButton(QuestionViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(submit);
        this.add(buttons);

        // TODO: Further implementation needed and double check needed.
        submit.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(submit)){
                            AnswerQuestionState currentState = questionViewModel.getState();

                            answerQuestionController.execute(
                                    currentState.getUserAnswer()
                            );
                        }
                    }
                }
        );

    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    // TODO: Implementation needed
    }
}
