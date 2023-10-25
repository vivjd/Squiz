package app;

import data_access.NoteDataAccessObject;
import use_case.note.NoteDataAccessInterface;

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
    }
}