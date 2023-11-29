package view;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionState;
import interface_adapter.question.QuestionViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Map;

public class AnswerQuestionView extends JPanel implements PropertyChangeListener {
    public final String viewName = "question";
    private JButton submit;
    private final QuestionViewModel questionViewModel;

    private final AnswerQuestionController answerQuestionController;

    private JTextArea questionTextArea;
    private JPanel answerPanel;

    public AnswerQuestionView(QuestionViewModel questionViewModel, AnswerQuestionController controller) {
        this.questionViewModel = questionViewModel;
        this.answerQuestionController = controller;

        questionViewModel.addPropertyChangeListener(this);

        initializeUI();
        setupSubmitButtonAction();
        handleInitialQuestionType();
    }

    private void initializeUI() {
        JPanel buttons = new JPanel();
        submit = new JButton(QuestionViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(submit);
        add(buttons);

        answerPanel = new JPanel();
        add(answerPanel);

         questionTextArea = new JTextArea();
         add(questionTextArea);
    }

    private void setupSubmitButtonAction() {
        submit.addActionListener(e -> {
            if (e.getSource().equals(submit)) {
                AnswerQuestionState currentState = questionViewModel.getState();
                answerQuestionController.execute(currentState.getUserAnswer());
                questionViewModel.setState(currentState);
            }
        });
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("AQC PROP CHANGE");
        AnswerQuestionState currentState = questionViewModel.getState();
        questionTextArea.setText(currentState.getQuestionName());

        if (currentState.getQuestion() instanceof OpenEndedQuestion) {
            handleOpenEndedQuestion((OpenEndedQuestion) currentState.getQuestion());
        } else if (currentState.getQuestion() instanceof MultipleChoiceQuestion) {
            handleMultipleChoiceQuestion((MultipleChoiceQuestion) currentState.getQuestion());
        }
    }

    private void handleOpenEndedQuestion(OpenEndedQuestion question) {
        answerPanel.removeAll();

        JTextField textField = new JTextField();
        answerPanel.add(textField);
        revalidate();
    }

    private void handleMultipleChoiceQuestion(MultipleChoiceQuestion question) {
        answerPanel.removeAll();
        ButtonGroup buttonGroup = new ButtonGroup();

        for (Map.Entry<String, String> entry : question.getAnswerOptions().entrySet()) {
            String optionIndex = entry.getKey();
            String optionText = entry.getValue();

            JRadioButton radioButton = new JRadioButton(optionText);
            radioButton.setActionCommand(String.valueOf(optionIndex));
            buttonGroup.add(radioButton);
            answerPanel.add(radioButton);
        }

        revalidate();
    }

    private void handleInitialQuestionType() {
        AnswerQuestionState currentState = questionViewModel.getState();
        if (currentState.getQuestion() != null) {
            if (currentState.getQuestion() instanceof OpenEndedQuestion) {
                handleOpenEndedQuestion((OpenEndedQuestion) currentState.getQuestion());
            } else if (currentState.getQuestion() instanceof MultipleChoiceQuestion) {
                handleMultipleChoiceQuestion((MultipleChoiceQuestion) currentState.getQuestion());
            }
        }
    }
}
