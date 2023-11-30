package view;

import interface_adapter.note.DeleteNoteController;
import interface_adapter.note.back.BackController;
import interface_adapter.note.display_notes.DisplayNotesController;
import interface_adapter.note.display_notes.DisplayNotesState;
import interface_adapter.note.display_notes.DisplayNotesViewModel;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class DisplayNotesView extends JPanel implements PropertyChangeListener{
    public final String viewName = "display_notes";
    private String[] columnNames = {"Note Title", "Note Content"};
    private String[][] notesData;
    private JTable table;
    private final JButton delete = new JButton(DisplayNotesViewModel.DELETE_LABEL);
    private final JButton back = new JButton(DisplayNotesViewModel.BACK_LABEL);
    private final JButton view = new JButton(DisplayNotesViewModel.NOTE_LABEL);
    private final DisplayNotesController displayNotesController;
    private final DeleteNoteController deleteNoteController;
    private final BackController backController;
    private final DisplayNotesViewModel displayNotesViewModel;

    public DisplayNotesView(DisplayNotesViewModel displayNotesViewModel, DisplayNotesController displayNotesController,
                            DeleteNoteController deleteNoteController, BackController backController) {
        this.displayNotesViewModel = displayNotesViewModel;
        this.displayNotesController = displayNotesController;
        this.deleteNoteController = deleteNoteController;
        this.backController = backController;

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
    }

    private Box createButtons() {
        Box buttons = Box.createVerticalBox();
        buttons.add(view);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(delete);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(back);
        buttons.add(Box.createVerticalStrut(10));

        return buttons;
    }

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
