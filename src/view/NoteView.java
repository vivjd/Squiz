package view;


import interface_adapter.note.SaveNoteController;
import interface_adapter.note.NoteState;
import interface_adapter.note.NoteViewModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NoteView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "note";

    private final JTextArea userInputNote = new JTextArea("enter your notes here");
    private final JTextField userInputTitle = new JTextField("enter title here", 30);

    private final JButton save;
    private final JButton generate_quiz;

    private final JButton all_quizzes;

    private final JButton all_notes;


    private final SaveNoteController saveNoteController;
    private final NoteViewModel noteViewModel;

    public NoteView(SaveNoteController saveNoteController, NoteViewModel noteViewModel) {
        this.saveNoteController = saveNoteController;
        this.noteViewModel = noteViewModel;
        noteViewModel.addPropertyChangeListener(this);

        userInputNote.setColumns(50);
        userInputNote.setLineWrap(true);
        userInputNote.setRows(20);
        LabelTextPanel noteInfo = new LabelTextPanel(
                new JLabel(NoteViewModel.NOTE_LABEL), userInputNote);
        LabelTextPanel titleInfo = new LabelTextPanel(
                new JLabel(NoteViewModel.TITLE_LABEL), userInputTitle);

        JScrollPane scrollbar = new JScrollPane(userInputNote,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);


        JPanel buttons = new JPanel();
        all_quizzes = new JButton(NoteViewModel.ALL_QUIZZES_LABEL);
        all_notes = new JButton(NoteViewModel.ALL_NOTES_LABEL);
        save = new JButton(NoteViewModel.SAVE_LABEL);
        generate_quiz = new JButton(NoteViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(save);
        buttons.add(all_quizzes);
        buttons.add(all_notes);
        buttons.add(generate_quiz);

        save.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(save)) {
                            NoteState currentState = noteViewModel.getState();

                            saveNoteController.execute(
                                    currentState.getTitle(),
                                    currentState.getNote());
                            showSavedPopup();
                        }
                    }
                }
        );

        userInputNote.addKeyListener(
                new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {
                        NoteState currentState = noteViewModel.getState();
                        String text = userInputNote.getText() + e.getKeyChar();
                        currentState.setNote(text);
                        noteViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
        );

        userInputTitle.addKeyListener(
                new KeyListener() {

                    @Override
                    public void keyTyped(KeyEvent e) {
                        NoteState currentState = noteViewModel.getState();
                        String text = userInputTitle.getText() + e.getKeyChar();
                        currentState.setTitle(text);
                        noteViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                }
        );

        this.add(titleInfo);
        this.add(noteInfo);
        this.add(scrollbar);
        this.add(buttons);

    }

    private void showSavedPopup(){
        JOptionPane.showMessageDialog(this, "Note Saved.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            NoteState state = (NoteState) evt.getNewValue();
            if (state.getEmptyNoteError() != null) {
                JOptionPane.showMessageDialog(this, state.getEmptyNoteError());
            }
    }
}
