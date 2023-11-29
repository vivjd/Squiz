package view;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;
import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionState;
import interface_adapter.question.QuestionViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class AnswerQuestionView extends JPanel implements PropertyChangeListener {
    public final String viewName = "question";
    private JButton submit;
    private final QuestionViewModel questionViewModel;

    private final AnswerQuestionController answerQuestionController;

    private JTextArea questionTextArea;
    private JPanel answerPanel;
    private Map<JRadioButton, String> radioButtonValues = new HashMap<>();

    public AnswerQuestionView(QuestionViewModel questionViewModel, AnswerQuestionController controller) {
        this.questionViewModel = questionViewModel;
        this.answerQuestionController = controller;

        questionViewModel.addPropertyChangeListener(this);

        initializeUI();
        setupSubmitButtonAction();
        handleInitialQuestionType();
    }

    private void initializeUI() {
        setLayout(new BorderLayout(10, 10)); // Add some spacing between components

        JPanel buttonPanel = new JPanel();
        submit = new JButton(QuestionViewModel.SUBMIT_BUTTON_LABEL);
        buttonPanel.add(submit);
        add(buttonPanel, BorderLayout.SOUTH); // Place the button at the bottom

        answerPanel = new JPanel();
        add(answerPanel, BorderLayout.CENTER);

        JPanel questionPanel = new JPanel(new BorderLayout());
        questionTextArea = new JTextArea();
        questionTextArea.setEditable(false); // Make it non-editable
        questionPanel.add(questionTextArea, BorderLayout.CENTER);
        add(questionPanel, BorderLayout.NORTH);
    }


    private void setupSubmitButtonAction() {
        submit.addActionListener(e -> {
            if (e.getSource().equals(submit)) {
                AnswerQuestionState currentState = questionViewModel.getState();
                questionViewModel.setState(currentState);
                String selection = getSelectedRadioButtonValue();
                Question<?> question = currentState.getQuestion();
                answerQuestionController.execute(selection, question);

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
            radioButton.setActionCommand(optionIndex);
            buttonGroup.add(radioButton);
            answerPanel.add(radioButton);

            // Map the radio button to its value
            radioButtonValues.put(radioButton, optionText);
        }

        revalidate();
    }

    private String getSelectedRadioButtonValue() {
        for (Map.Entry<JRadioButton, String> entry : radioButtonValues.entrySet()) {
            JRadioButton radioButton = entry.getKey();
            if (radioButton.isSelected()) {
                return entry.getValue();
            }
        }
        return null;
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
