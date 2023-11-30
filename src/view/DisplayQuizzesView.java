package view;

import interface_adapter.back.BackController;
import interface_adapter.quiz.delete.DeleteQuizController;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesState;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The {@code DisplayQuizzesView} class represents the view for displaying quizzes.
 * It extends {@code JPanel} and implements {@code PropertyChangeListener}.
 * This class provides a graphical user interface for managing quizzes, including options
 * to start, edit, delete quizzes and return to the home page.
 */
public class DisplayQuizzesView extends JPanel implements PropertyChangeListener {
    /** The name of the view. */
    public final String viewName = "quiz";

    /** The column names for the quiz table. */
    private final String[] columnNames = {"Quiz Title", "No. Questions", "Time Created" };

    /** The data to be displayed in the quiz table. */
    private String[][] quizData;
    private final DisplayQuizzesController displayQuizzesController;
    private final DisplayQuizzesViewModel displayQuizzesViewModel;
    private final DeleteQuizController deleteQuizController;
    private final BackController backController;

    JTable table;
    final JButton start;
    final JButton edit;
    final JButton back;
    final JButton delete;

    private ListSelectionModel selectionModel;
    private String selectedTitle;

    /**
     * Constructs a new {@code DisplayQuizzesView} with the specified view model and controllers.
     *
     * @param displayQuizzesViewModel The view model for displaying quizzes.
     * @param controller The controller for managing the display of quizzes.
     * @param takeQuizController The controller for taking quizzes.
     * @param takeQuizViewModel The view model for taking quizzes.
     * @param deleteQuizController The controller for deleting quizzes.
     */
    public DisplayQuizzesView(DisplayQuizzesViewModel displayQuizzesViewModel,
                              DisplayQuizzesController controller,
                              TakeQuizController takeQuizController,
                              TakeQuizViewModel takeQuizViewModel,
                              DeleteQuizController deleteQuizController,
                              BackController backController
    ) {
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.displayQuizzesController = controller;
        this.deleteQuizController = deleteQuizController;
        this.backController = backController;

        final String noQuizSelectedMessage = "Please select a quiz or return to the home page to create a quiz.";
        displayQuizzesViewModel.addPropertyChangeListener(this);

        Box buttons = Box.createVerticalBox();
        start = new JButton(DisplayQuizzesViewModel.START_LABEL);
        delete = new JButton (DisplayQuizzesViewModel.DELETE_LABEL);
        back = new JButton(DisplayQuizzesViewModel.BACK_LABEL);
        edit = new JButton(DisplayQuizzesViewModel.EDIT_LABEL);
        buttons.add(start);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(back);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(edit);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(delete);
        buttons.add(Box.createVerticalStrut(10));


        start.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(start)) {
                            try{
                                takeQuizViewModel.getState().resetAll();
                                takeQuizController.start(selectedTitle);
                                takeQuizController.execute(selectedTitle);}
                            catch(NullPointerException error){
                                JOptionPane.showMessageDialog(null, noQuizSelectedMessage);
                            }
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if (e.getSource().equals(back)) {
                            backController.execute();
                        }
                    }
                }
        );

        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            if (e.getSource().equals(delete)){
                            ObjectId quizId = displayQuizzesViewModel.getState().getIds()[table.getSelectedRow()];
                            deleteQuizController.execute(quizId);
                            displayQuizzesController.execute();
                            showDeletePopUp();
                        }}
                        catch (ArrayIndexOutOfBoundsException error){
                            JOptionPane.showMessageDialog(null, noQuizSelectedMessage);
                        }
                    }
                }
        );

        table = new JTable(new DefaultTableModel(new String[0][0], columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        table.setRowSelectionAllowed(true);
        table.setBounds(30, 40, 200, 300);
        JScrollPane scrollbar = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollbar);
        this.add(buttons);
    }

    private void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    /**
     * Handles property change events relating to the DisplayQuizzesView and updates the view accordingly.
     *
     * @param evt The property change event.
     */
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
    private void updateTable(){
        quizData = displayQuizzesViewModel.getState().getQuizzesTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.setRowCount(0);

        for (String[] quizDatum : quizData) {
            tableModel.addRow(quizDatum);
        }

        selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        selectedTitle = table.getValueAt(selectedRow, 0).toString();
                        System.out.println("Selected Row: " + selectedRow);
                    } else {
                        System.out.println("No Row Selected");
                    }
                }
            }
        });
    }

    private void showDeletePopUp() {
        JOptionPane.showMessageDialog(this, "Quiz deleted");
    }
}
