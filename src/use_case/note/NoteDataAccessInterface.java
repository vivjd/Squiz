package use_case.note;

import entity.Note;

import java.util.List;

public interface NoteDataAccessInterface {
    void saveNote(Note note);
    Note getNote(String title);
    List<String> getAllNotes();
}
