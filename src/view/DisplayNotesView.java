package view;

import interface_adapter.note.delete.DeleteNoteController;
import interface_adapter.back.BackController;
import interface_adapter.note.display.DisplayNotesController;
import interface_adapter.note.display.DisplayNotesState;
import interface_adapter.note.display.DisplayNotesViewModel;
import interface_adapter.quiz.GenerateQuizController;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

/**
 * Responsible for the final screen when the "Display Notes" use case is executed
 */
public class DisplayNotesView extends JPanel implements PropertyChangeListener{
    public final String viewName = "display_notes";
    private String[] columnNames = {"Note Title", "Note Content"};
    private String[][] notesData;
    private JTable table;
    private final JButton delete = new JButton(DisplayNotesViewModel.DELETE_LABEL);
    private final JButton back = new JButton(DisplayNotesViewModel.BACK_LABEL);
    private final JButton view = new JButton(DisplayNotesViewModel.NOTE_LABEL);
    private final JButton generateQuiz = new JButton(DisplayNotesViewModel.GENERATE_QUIZ_LABEL);
    private final DisplayNotesController displayNotesController;
    private final DeleteNoteController deleteNoteController;
    private final BackController backController;
    private final DisplayNotesViewModel displayNotesViewModel;
    private final GenerateQuizController generateQuizController;

    /**
     * Constructor of the DisplayNotesView
     * Initializes the screen by creating the format of the JPanel
     * @param displayNotesViewModel is the view model for the "Display Notes" Use Case
     * @param displayNotesController is the controller responsible for the "Display Notes"
     *                               Use Case; is executed when the table needs to be updated
     * @param deleteNoteController is the controller responsible for the "Delete Note" Use Case;
     *                             is executed when the delete button is pressed by the user
     * @param backController is the controller responsible for the "Back" use case; is executed
     *                       when the back button is pressed by the user
     */
    public DisplayNotesView(DisplayNotesViewModel displayNotesViewModel, DisplayNotesController displayNotesController,
                            DeleteNoteController deleteNoteController, BackController backController, GenerateQuizController generateQuizController) {
        this.displayNotesViewModel = displayNotesViewModel;
        this.displayNotesController = displayNotesController;
        this.deleteNoteController = deleteNoteController;
        this.backController = backController;
        this.generateQuizController = generateQuizController;

        displayNotesViewModel.addPropertyChangeListener(this);

        Box buttons = createButtons();
        table = new JTable(new DefaultTableModel(new String[0][0], columnNames){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        table.setRowSelectionAllowed(true);
        table.setBounds(30, 40, 200, 300);
        JScrollPane scrollbar = new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollbar);
        this.add(buttons);

        delete.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(delete)) {
                            ObjectId noteId = displayNotesViewModel.getState().getIds()[table.getSelectedRow()];
                            deleteNoteController.execute(noteId);
                            displayNotesController.execute();

                            showDeletePopUp();
                        }
                    }
                }
        );

        back.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(back)) {
                            backController.execute();
                        }
                    }
                }
        );

        view.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(view)) {
                            notImplemented();
                        }
                    }
                }
        );

        generateQuiz.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generateQuiz)){
                            String title = notesData[table.getSelectedRow()][0];
                            String content = notesData[table.getSelectedRow()][1];
                            try {
                                generateQuizController.execute(content, title);
                                JOptionPane.showMessageDialog(null, "Quiz generated and saved. You can access it in the 'View all Quizzes' Page.");
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    }
                }
        );
    }

    private Box createButtons() {
        Box buttons = Box.createVerticalBox();
        buttons.add(view);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(delete);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(back);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(generateQuiz);
        buttons.add(Box.createVerticalStrut(10));

        return buttons;
    }

    /**
     * Method responsible for checking if there is an error in the state
     * If there is, display the error to the user; if not, update the table to ensure
     * the user has the current number of notes found in the data base
     * @param evt A PropertyChangeEvent object describing the event source
     *          and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        DisplayNotesState state = (DisplayNotesState) evt.getNewValue();
        if (state.getEmptyNotesError() != null) {
            JOptionPane.showMessageDialog(this, state.getEmptyNotesError());
        } else {
            updateTable();
        }
    }

    private void updateTable() {
        notesData = displayNotesViewModel.getState().getTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();

        tableModel.setRowCount(0);

        for (String[] note: notesData) {
            tableModel.addRow(note);
        }
    }

    private void notImplemented() {
        JOptionPane.showMessageDialog(this, "not implemented");
    }

    private void showDeletePopUp() {
        JOptionPane.showMessageDialog(this, "note deleted");
    }
}
