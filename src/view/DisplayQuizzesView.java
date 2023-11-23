package view;

import data_access.QuizDataAccessObject;
import interface_adapter.note.NoteState;
import interface_adapter.note.NoteViewModel;
import interface_adapter.quiz.DisplayQuizzesController;
import interface_adapter.quiz.DisplayQuizzesState;
import interface_adapter.quiz.DisplayQuizzesViewModel;
import use_case.quiz.QuizDataAccessInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        quizData = displayQuizzesViewModel.getState().getQuizzesTable();
//        popUpTest();

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
//                        if (e.getSource().equals(back)) {
//                            NoteState currentState = noteViewModel.getState();
//                            noteViewModel.setState(currentState);
//                        }
                    }
                }
        );

        table = populateTable();
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
        }
//        quizData = state.getQuizzesTable();
//        System.out.println(Arrays.deepToString(quizData));
    }

    public void popUpTest(){
        JOptionPane.showMessageDialog(this, quizData);
    }

    public JTable populateTable(){
        // Column Names
        String[] columnNames = {"Quiz Title", "No. Questions", "Time Created" };

        // Initializing the JTable
        //quizData = new String[10000][4]; //this is for testing purposes - getting blank data entries to put on

        //the following two lines works but is not allowed as we pass in a quiz DAO
//        QuizDataAccessInterface quizDAO = new QuizDataAccessObject();
//        quizData = quizDAO.getAllQuizzesTable();

        quizData = displayQuizzesViewModel.getState().getQuizzesTable();
        if (quizData == null) {
            System.out.println("Quiz data is empty so the empty table is displayed");
            quizData = new String[3][3];
        } else {
            System.out.println("Quiz data should display");
            quizData = displayQuizzesViewModel.getState().getQuizzesTable();
        }

        //System.out.println(quizData[0][0]);
        table = new JTable(quizData, columnNames);
        table.setBounds(30, 40, 200, 300);

        return table;
    }
}
