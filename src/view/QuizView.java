package view;


import interface_adapter.quiz.QuizViewModel;
import interface_adapter.quiz.display_quiz.DisplayQuizController;
import interface_adapter.quiz.display_quiz.DisplayQuizState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuizView extends JPanel implements PropertyChangeListener {
    public final String viewName = "quiz";
    private final QuizViewModel quizViewModel;
    // frame
    JFrame frame;
    // Table
    JTable table;

    private String[][] quizData;

    final JButton start;

    final JButton edit;

    final JButton back;
    private final DisplayQuizController displayQuizController;

    public QuizView(QuizViewModel quizViewModel, DisplayQuizController controller) {
        this.quizViewModel = quizViewModel;
        this.displayQuizController = controller;

        quizViewModel.addPropertyChangeListener(this);
        populateTable();

        JPanel buttons = new JPanel();
        start = new JButton(QuizViewModel.START_LABEL);
        back = new JButton(QuizViewModel.BACK_LABEL);
        edit = new JButton(QuizViewModel.EDIT_LABEL);
        buttons.add(start);
        buttons.add(back);
        buttons.add(edit);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayQuizState state = (DisplayQuizState) evt.getNewValue();
        quizData = state.getQuizzesTable();
    }

    public void populateTable(){
        frame = new JFrame();
        frame.setTitle("Saved Quizzes");

        // Column Names
        String[] columnNames = { "Quiz Title", "No. Questions", "Time Created" };

        // Initializing the JTable
        table = new JTable(quizData, columnNames);
        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        // Frame Size
        frame.setSize(500, 200);
        // Frame Visible = true
        frame.setVisible(true);
    }
}
