package view;

import interface_adapter.quiz.display_quiz.DisplayQuizzesController;
import interface_adapter.quiz.display_quiz.DisplayQuizzesState;
import interface_adapter.quiz.display_quiz.DisplayQuizzesViewModel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class QuizView extends JPanel implements PropertyChangeListener {
    public final String viewName = "quiz";
    private final DisplayQuizzesViewModel quizViewModel;
    // frame
    JFrame frame;
    // Table
    JTable table;

    private String[][] quizData;

    final JButton start;

    final JButton edit;

    final JButton back;
    private final DisplayQuizzesController displayQuizController;

    public QuizView(DisplayQuizzesViewModel quizViewModel, DisplayQuizzesController controller) {
        this.quizViewModel = quizViewModel;
        this.displayQuizController = controller;

        quizViewModel.addPropertyChangeListener(this);
        populateTable();

        JPanel buttons = new JPanel();
        start = new JButton(DisplayQuizzesViewModel.START_LABEL);
        back = new JButton(DisplayQuizzesViewModel.BACK_LABEL);
        edit = new JButton(DisplayQuizzesViewModel.EDIT_LABEL);
        buttons.add(start);
        buttons.add(back);
        buttons.add(edit);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayQuizzesState state = (DisplayQuizzesState) evt.getNewValue();
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
