package view;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;
import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionState;
import interface_adapter.question.QuestionViewModel;
import use_case.quiz.take_quiz.AnswerQuestionListener;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

/**
 * The {@code AnswerQuestionView} class represents the graphical user interface for answering questions during take quiz.
 * It extends {@link JPanel} and implements {@link PropertyChangeListener} to react to changes in the
 * underlying question state.
 */
public class AnswerQuestionView extends JPanel implements PropertyChangeListener{
    public final String viewName = "question";
    private JButton submit;
    private final QuestionViewModel questionViewModel;

    private final AnswerQuestionController answerQuestionController;
    private AnswerQuestionListener answerQuestionListener;

    private JTextArea questionTextArea;
    private JPanel answerPanel;
    private Map<JRadioButton, String> radioButtonValues = new HashMap<>();

    /**
     * Constructs a new {@code AnswerQuestionView} with the specified dependencies.
     *
     * @param questionViewModel      The view model containing the question state.
     * @param controller The controller for handling user interactions related to answering questions.
     */
    public AnswerQuestionView(QuestionViewModel questionViewModel,
                              AnswerQuestionController controller
    ) {
        this.questionViewModel = questionViewModel;
        this.answerQuestionController = controller;


        questionViewModel.addPropertyChangeListener(this);

        initializeUI();
        setupSubmitButtonAction();
        handleInitialQuestionType();
    }

    private void initializeUI() {
        setLayout(new BorderLayout(10, 10));

        JPanel buttonPanel = new JPanel();
        submit = new JButton(QuestionViewModel.SUBMIT_BUTTON_LABEL);
        buttonPanel.add(submit);
        add(buttonPanel, BorderLayout.SOUTH);

        answerPanel = new JPanel();
        add(answerPanel, BorderLayout.CENTER);

        JPanel questionPanel = new JPanel(new BorderLayout());
        questionTextArea = new JTextArea();
        questionTextArea.setEditable(false);
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
                showFeedbackPopup(currentState.getFeedback());
                answerQuestionListener.onSubmitButtonPressed();

            }
        });
    }

    /**
     * Reacts to property change events in the underlying question state and updates the view.
     *
     * @param evt The property change event.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

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

        textField.setPreferredSize(new Dimension(300, 50));

        answerPanel.setLayout(new BorderLayout());
        answerPanel.add(textField, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    private void handleMultipleChoiceQuestion(MultipleChoiceQuestion question) {
        answerPanel.removeAll();
        ButtonGroup buttonGroup = new ButtonGroup();

        for (Map.Entry<String, String> entry : question.getAnswerOptions().entrySet()) {
            String optionIndex = entry.getKey();
            String optionText = entry.getValue();

            JRadioButton radioButton = new JRadioButton(optionIndex.replace('\"', ' ') + ":" + optionText);
            radioButton.setActionCommand(optionIndex);
            buttonGroup.add(radioButton);
            answerPanel.add(radioButton);
            radioButtonValues.put(radioButton, optionText);
        }

        answerPanel.setLayout(new GridLayout(0, 1));
        revalidate();
        repaint();
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

    /**
     * Sets the answer question listener for handling events.
     *
     * @param answerQuestionListener The answer question listener.
     */
    public void setAnswerQuestionListener(AnswerQuestionListener answerQuestionListener) {
        this.answerQuestionListener = answerQuestionListener;
    }
    private void showFeedbackPopup(String feedback){
        JOptionPane.showMessageDialog(this, feedback);
    }

}
