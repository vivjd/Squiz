package main.java;

import main.java.data_access.NoteDataAccessObject;
import main.java.entity.Note;
import main.java.usecase.note.NoteDataAccessInterface;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Example usage of the NoteDataAccessObject
        NoteDataAccessInterface noteDataAccess = new NoteDataAccessObject();
        Note note = new Note();
        note.setTitle("Example Title");
        note.setUserPrompt("Example Prompt");

        noteDataAccess.saveNote(note);

        // Retrieve all notes
        List<String> allNotes = noteDataAccess.getAllNotes();
        for (String noteJson : allNotes) {
            System.out.println(noteJson);
        }
    }
}