package view;

import interface_adapter.quiz.DisplayQuizzesController;
import interface_adapter.quiz.DisplayQuizzesState;
import interface_adapter.quiz.DisplayQuizzesViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DisplayQuizzesView extends JPanel implements PropertyChangeListener {
    public final String viewName = "quiz";
    private final DisplayQuizzesViewModel displayQuizzesViewModel;
    // frame
    JFrame frame;
    // Table
    JTable table;

    private String[][] quizData;

    final JButton start;

    final JButton edit;

    final JButton back;
    private final DisplayQuizzesController displayQuizzesController;

    public DisplayQuizzesView(DisplayQuizzesViewModel displayQuizzesViewModel, DisplayQuizzesController controller) {
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.displayQuizzesController = controller;

        displayQuizzesViewModel.addPropertyChangeListener(this);

        table = populateTable();
        JScrollPane scrollbar = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        Box buttons = Box.createVerticalBox();
        start = new JButton(DisplayQuizzesViewModel.START_LABEL);
        back = new JButton(DisplayQuizzesViewModel.BACK_LABEL);
        edit = new JButton(DisplayQuizzesViewModel.EDIT_LABEL);
        buttons.add(start);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(back);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(edit);
        buttons.add(Box.createVerticalStrut(10));

        this.add(scrollbar);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayQuizzesState state = (DisplayQuizzesState) evt.getNewValue();
        quizData = state.getQuizzesTable();
    }

    public JTable populateTable(){
//        frame = new JFrame();
//        frame.setTitle("Saved Quizzes");

        // Column Names
        String[] columnNames = {"Quiz Title", "No. Questions", "Time Created" };

        // Initializing the JTable
        // quizData = new String[10000][4];

        table = new JTable(quizData, columnNames);
        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
//        JScrollPane sp = new JScrollPane(table);
//        frame.add(sp);
//        // Frame Size
//        frame.setSize(500, 200);
//        // Frame Visible = true
//        frame.setVisible(true);

        return table;
    }
}
