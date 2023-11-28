package view;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizState;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;

public class TakeQuizView extends JPanel implements PropertyChangeListener {

    public final String viewName = "take_quiz";

    private final TakeQuizViewModel takeQuizViewModel;
    private final TakeQuizController takeQuizController;

    private JFrame questionView;
    private JTextArea questionTextArea;
    private JPanel answerPanel;

    public TakeQuizView(TakeQuizViewModel takeQuizViewModel, TakeQuizController takeQuizController) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.takeQuizController = takeQuizController;

        // Initialize the JTextArea for displaying the question
        questionTextArea = new JTextArea();
        questionTextArea.setEditable(false);
        questionTextArea.setLineWrap(true);
        questionTextArea.setWrapStyleWord(true);

        // Initialize the JPanel for displaying answers
        answerPanel = new JPanel();
        answerPanel.setLayout(new BoxLayout(answerPanel, BoxLayout.Y_AXIS));

        takeQuizViewModel.addPropertyChangeListener(this);

        setLayout(new BorderLayout());
        add(questionTextArea, BorderLayout.NORTH);
        add(answerPanel, BorderLayout.CENTER);

        JButton nextButton = new JButton("Next Question");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        add(nextButton, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        TakeQuizState state = (TakeQuizState) evt.getNewValue();

        List<Question<?>> questions = takeQuizViewModel.getState().getQuestions();
        Question<?> question = questions.get(state.getCurrentQuestionIndex());
        String questionText = question.getQuestion();

        if (question instanceof MultipleChoiceQuestion) {
            handleMultipleChoiceQuestion((MultipleChoiceQuestion) question);
        } else if (question instanceof OpenEndedQuestion) {
            handleOpenEndedQuestion((OpenEndedQuestion) question);
        }

        questionTextArea.setText(questionText);

    }

    private void handleOpenEndedQuestion(OpenEndedQuestion question) {
        JTextField textField = new JTextField();
        answerPanel.add(textField);
    }

    private void handleMultipleChoiceQuestion(MultipleChoiceQuestion question) {
        ButtonGroup buttonGroup = new ButtonGroup();

        for (Map.Entry<String, String> entry : question.getAnswerOptions().entrySet()) {
            String optionIndex = entry.getKey();
            String optionText = entry.getValue();

            JRadioButton radioButton = new JRadioButton(optionText);
            radioButton.setActionCommand(String.valueOf(optionIndex));
            buttonGroup.add(radioButton);
            answerPanel.add(radioButton);
        }
    }
}
