package view;

import interface_adapter.note.SaveNoteController;
import interface_adapter.note.NoteState;
import interface_adapter.note.NoteViewModel;
import interface_adapter.quiz.GenerateQuizController;
import use_case.quiz.GenerateQuizInteractor;
import use_case.quiz.GenerateQuizOutputBoundary;

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
    private final JButton edit;
    private final JButton generate_quiz;


    private final SaveNoteController saveNoteController;
    private final GenerateQuizController generateQuizController;
    private final NoteViewModel noteViewModel;

    public NoteView(SaveNoteController saveNoteController, NoteViewModel noteViewModel) {
        this.saveNoteController = saveNoteController;
        this.noteViewModel = noteViewModel;
        GenerateQuizOutputBoundary quizPresenter = new GenerateQuizOutputBoundary() {
            @Override
            public void prepareSuccessView(String quiz) {

            }

            @Override
            public void prepareFailView(String error) {

            }
        };
        GenerateQuizInteractor generateQuizInteractor = new GenerateQuizInteractor(quizPresenter);
        this.generateQuizController = new GenerateQuizController(generateQuizInteractor);
        noteViewModel.addPropertyChangeListener(this);

        //creating title and note box
        Box textPanes = Box.createVerticalBox();
        userInputNote.setColumns(50);
        userInputNote.setLineWrap(true);
        userInputNote.setRows(20);
        LabelTextPanel noteInfo = new LabelTextPanel(
                new JLabel(NoteViewModel.NOTE_LABEL), userInputNote);
        LabelTextPanel titleInfo = new LabelTextPanel(
                new JLabel(NoteViewModel.TITLE_LABEL), userInputTitle);

        JScrollPane scrollbar = new JScrollPane(userInputNote,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        textPanes.add(titleInfo);
        textPanes.add(Box.createVerticalStrut(10));
        textPanes.add(noteInfo);
        textPanes.add(scrollbar);

        //creating buttons
        Box buttons = Box.createVerticalBox();
        edit = new JButton(NoteViewModel.EDIT_LABEL);
        save = new JButton(NoteViewModel.SAVE_LABEL);
        generate_quiz = new JButton(NoteViewModel.SUBMIT_BUTTON_LABEL);
        buttons.add(edit);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(save);
        buttons.add(Box.createVerticalStrut(10));
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

        generate_quiz.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generate_quiz)) {
                            NoteState currentState = noteViewModel.getState();
                            try {
                                generateQuizController.execute(
                                        currentState.getNote(),
                                        currentState.getTitle());
                            } catch (Exception ex) {
                                throw new RuntimeException(ex);
                            }
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

        this.add(textPanes);
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
