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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;

public class TakeQuizView extends JPanel implements PropertyChangeListener {

    public final String viewName = "take_quiz";

    private final TakeQuizViewModel takeQuizViewModel;
    private final TakeQuizController takeQuizController;

    private JPanel questionView;
    private JTextArea questionTextArea;
    private JPanel answerPanel;

    public TakeQuizView(TakeQuizViewModel takeQuizViewModel, TakeQuizController takeQuizController, AnswerQuestionView answerQuestionView) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.takeQuizController = takeQuizController;
        this.questionView = answerQuestionView;

        setLayout(new BorderLayout());
        add(answerQuestionView, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        add(submitButton, BorderLayout.SOUTH);

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
