package view;

import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;

import javax.swing.*;

public class TakeQuizView extends JPanel {

    public final String viewName = "take_quiz";

    private final TakeQuizViewModel takeQuizViewModel;
    private final TakeQuizController takeQuizController;

    public TakeQuizView(TakeQuizViewModel takeQuizViewModel, TakeQuizController takeQuizController) {

        this.takeQuizViewModel = takeQuizViewModel;
        this.takeQuizController = takeQuizController;
    }
}
