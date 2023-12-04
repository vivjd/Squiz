package view;

import interface_adapter.note.save.SaveNoteController;
import interface_adapter.note.NoteState;
import interface_adapter.note.NoteViewModel;
import interface_adapter.quiz.generate.GenerateQuizController;
import use_case.quiz.generate.GenerateQuizInteractor;
import use_case.quiz.generate.GenerateQuizOutputBoundary;

import interface_adapter.note.display.DisplayNotesController;
import interface_adapter.note.display.DisplayNotesState;
import interface_adapter.note.display.DisplayNotesViewModel;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

public class NoteView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "note";

    private final JTextArea userInputNote = new JTextArea("");
    private final JTextField userInputTitle = new JTextField("", 30);

    private final JButton save;
    private final JButton allQuizzes;

    private final JButton allNotes;

    private final JButton generateQuiz;

    private final SaveNoteController saveNoteController;
    private final GenerateQuizController generateQuizController;
    private final NoteViewModel noteViewModel;
    private final DisplayQuizzesController displayQuizzesController;
    private final DisplayQuizzesViewModel displayQuizzesViewModel;
    private final DisplayNotesController displayNotesController;
    private final DisplayNotesViewModel displayNotesViewModel;

    public NoteView(SaveNoteController saveNoteController, NoteViewModel noteViewModel,
                    DisplayQuizzesController displayQuizzesController, DisplayQuizzesViewModel displayQuizzesViewModel,
                    DisplayNotesController displayNotesController, DisplayNotesViewModel displayNotesViewModel) {
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
        this.displayQuizzesController = displayQuizzesController;
        this.displayQuizzesViewModel = displayQuizzesViewModel;
        this.displayNotesController = displayNotesController;
        this.displayNotesViewModel = displayNotesViewModel;

        displayQuizzesViewModel.addPropertyChangeListener(this);
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
        allQuizzes = new JButton(NoteViewModel.ALL_QUIZZES_LABEL);
        save = new JButton(NoteViewModel.SAVE_LABEL);
        generateQuiz = new JButton(NoteViewModel.SUBMIT_BUTTON_LABEL);
        allNotes = new JButton(NoteViewModel.ALL_NOTES_LABEL);

        buttons.add(save);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(generateQuiz);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(allNotes);
        buttons.add(Box.createVerticalStrut(10));
        buttons.add(allQuizzes);

        save.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(save)) {
                            NoteState currentState = noteViewModel.getState();
                            String text = userInputNote.getText();
                            String title = userInputTitle.getText();
                            currentState.setTitle(title);
                            currentState.setNote(text);

                            saveNoteController.execute(
                                    currentState.getTitle(),
                                    currentState.getNote());

                            if (!title.isEmpty() && text.length() >= 50) {
                                messagePopUp("Your note has been saved.");
                                refresh();
                            }
                        }
                    }
                }
        );
        generateQuiz.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(generateQuiz)) {
                            NoteState currentState = noteViewModel.getState();
                            String noteText = userInputNote.getText();
                            String titleText = userInputTitle.getText();
                            if (Objects.equals(titleText, "")){
                                messagePopUp("Please enter a title for your note.");
                            }
                            else if (Objects.equals(noteText, "") || noteText.length() < 50){
                                messagePopUp("Please enter a minimum of 50 characters for your note.");
                            }
                            else{
                                try {
                                    messagePopUp("Quiz is being generated. Please wait for the next popup");
                                    generateQuizController.execute(
                                            noteText,
                                            titleText);
                                    messagePopUp("Quiz generated and saved. You can access it in the 'View All Quizzes' Page.");
                                    refresh();
                                } catch (Exception ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                    }
                }
        );
        allQuizzes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(allQuizzes)) {
                            messagePopUp("Showing all quizzes in new page...");
                            DisplayQuizzesState currentState = displayQuizzesViewModel.getState();
                            displayQuizzesController.execute();
                            displayQuizzesViewModel.setState(currentState);
                            refresh();

                        }
                    }
                }
        );

        allNotes.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(allNotes)) {
                            messagePopUp("Showing all notes in new page...");
                            DisplayNotesState currentState = displayNotesViewModel.getState();
                            displayNotesController.execute();
                            displayNotesViewModel.setState(currentState);
                            refresh();
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

    private void messagePopUp(String message) {JOptionPane.showMessageDialog(this, message);}

    private void refresh() {
        NoteState state = noteViewModel.getState();

        userInputNote.setText("");
        userInputTitle.setText("");

        state.setNote("");
        state.setTitle("");

        state.setEmptyNoteError(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        Object newValue = evt.getNewValue();
        if (newValue instanceof DisplayQuizzesState) {
            DisplayQuizzesState state = (DisplayQuizzesState) newValue;
            if (state.getEmptyQuizzesError() != null) {
                JOptionPane.showMessageDialog(this, state.getEmptyQuizzesError());
            }
        } else if (newValue instanceof NoteState) {
            NoteState state = (NoteState) newValue;
            if (state.getEmptyNoteError() != null) {
                JOptionPane.showMessageDialog(this, state.getEmptyNoteError());
            }
        } else if (newValue instanceof  DisplayNotesState) {
            DisplayNotesState state = (DisplayNotesState) newValue;
            if (state.getEmptyNotesError() != null) {
                JOptionPane.showMessageDialog(this, state.getEmptyNotesError());
            }
        }
    }

}
