package app;

import data_access.NoteDataAccessObject;
import interface_adapter.ViewManagerModel;
import use_case.note.NoteDataAccessInterface;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage of the NoteDataAccessObject
        NoteDataAccessInterface noteDataAccess = new NoteDataAccessObject();
//        Note note = new Note();
//        note.setTitle("Example Title");
//        note.setUserPrompt("Example Prompt");
//
//        noteDataAccess.saveNote(note);

        // Retrieve all notes
        List<String> allNotes = noteDataAccess.getAllNotes();
        for (String noteJson : allNotes) {
            System.out.println(noteJson);
        }

        buildInitialPage();
    }

    public static void buildInitialPage() {
        JFrame application = new JFrame("Squiz");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
    }
}