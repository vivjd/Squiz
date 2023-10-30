package view;


import interface_adapter.note.NoteController;
import interface_adapter.note.NoteViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class NoteView extends JPanel implements ActionListener, PropertyChangeListener{
    public final String viewName = "note";

    private final JTextField userInputNote = new JFormattedTextField(30);
    private final JButton save;
    private final JButton edit;
    private final JButton generate_quiz;


    private final NoteController noteController;
    private final NoteViewModel noteViewModel;

    public NoteView(NoteController noteController, NoteViewModel noteViewModel) {
        this.noteController = noteController;
        this.noteViewModel = noteViewModel;
        noteViewModel.addPropertyChangeListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
