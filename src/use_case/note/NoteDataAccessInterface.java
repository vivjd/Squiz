package use_case.note;

import entity.Note;
import org.bson.types.ObjectId;

import java.util.List;

public interface NoteDataAccessInterface {
    void saveNote(Note note);
    Note getNote(String title);
    List<Note> getAllNotes();
    String[][] getAllNotesTable();
    void deleteNote(ObjectId objectId);
}
