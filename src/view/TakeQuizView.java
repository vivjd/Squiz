package view;

import app.AnswerQuestionUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.question.QuestionViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizState;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import use_case.quiz.take_quiz.AnswerQuestionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class TakeQuizView extends JPanel implements PropertyChangeListener, AnswerQuestionListener {

    public final String viewName = "take_quiz";

    private final TakeQuizViewModel takeQuizViewModel;
    private final TakeQuizController takeQuizController;

    private AnswerQuestionView answerQuestionView;

    public TakeQuizView(TakeQuizViewModel takeQuizViewModel, TakeQuizController takeQuizController, AnswerQuestionView answerQuestionView) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.takeQuizController = takeQuizController;
        this.answerQuestionView = answerQuestionView;

        setLayout(new BorderLayout());
        add(answerQuestionView, BorderLayout.CENTER);


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        TakeQuizState state = (TakeQuizState) evt.getNewValue();

    }


    @Override
    public void onSubmitButtonPressed() {
        TakeQuizState currentState = takeQuizViewModel.getState();
        currentState.setCurrentQuestionIndex(currentState.getCurrentQuestionIndex() + 1);
        if (currentState.getCurrentQuestionIndex() < currentState.getQuestions().size()) {
            takeQuizController.nextQuestion();
        } else {
            showQuizDonePopUp();
            takeQuizController.nextQuestion();
        }
    }

    private void showQuizDonePopUp() {
        JOptionPane.showMessageDialog(this, "Quiz Completed!");
    }
}
