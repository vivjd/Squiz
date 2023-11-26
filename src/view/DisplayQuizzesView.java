package view;

import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesState;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DisplayQuizzesView extends JPanel implements PropertyChangeListener {
    public final String viewName = "quiz";

    /** The column names for the quiz table. */
    String[] columnNames = {"Quiz Title", "No. Questions", "Time Created" };

    /** The data to be displayed in the quiz table. */
    private String[][] quizData;
    private final DisplayQuizzesController displayQuizzesController;
    private final DisplayQuizzesViewModel displayQuizzesViewModel;
//    private final NoteViewModel noteViewModel;
    // Table
    JTable table;

    final JButton start;

    final JButton edit;

    final JButton back;

    public DisplayQuizzesView(DisplayQuizzesViewModel displayQuizzesViewModel, DisplayQuizzesController controller) {
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.displayQuizzesController = controller;
//        this.noteViewModel = noteViewModel;

        displayQuizzesViewModel.addPropertyChangeListener(this);

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

        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) {
                            // TODO: implement start quiz button
//                            TakeQuizState currentState = takeQuizViewModel.getState();
//                            takeQuizController.execute();
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if (e.getSource().equals(back)) {
                            // TODO: implement back button
//                            NoteState currentState = noteViewModel.getState();
//                            System.out.println(noteViewModel.getState());
//                            noteViewModel.setState(currentState);
                        }
                    }
                }
        );

        table = new JTable(new DefaultTableModel(new String[0][0], columnNames));
        table.setBounds(30, 40, 200, 300);
        JScrollPane scrollbar = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollbar);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayQuizzesState state = (DisplayQuizzesState) evt.getNewValue();
        if (state.getEmptyQuizzesError() != null){
            JOptionPane.showMessageDialog(this, state.getEmptyQuizzesError());
        } else{
            updateTable();
        }
    }

    /**
     * Updates the quiz table based on the current state of the view model.
     * It will delete all the initial data in the table and add all the current quizzes from quizData
     * into the table.
     */
    public void updateTable(){
        quizData = displayQuizzesViewModel.getState().getQuizzesTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        for (String[] quizDatum : quizData) {
            tableModel.addRow(quizDatum);
        }
    }
}
