package main.java;

import main.java.data_access.NoteDataAccessObject;
import main.java.entity.Note;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage of the NoteDataAccessObject
        NoteDataAccessObject dataAccess = new NoteDataAccessObject();
        Note note = new Note();
        note.setTitle("Example Title");
        note.setUserPrompt("Example Prompt");

        dataAccess.saveNote(note);

        // Retrieve all notes
        List<String> allNotes = dataAccess.getAllNotes();
        for (String noteJson : allNotes) {
            System.out.println(noteJson);
        }
    }
}