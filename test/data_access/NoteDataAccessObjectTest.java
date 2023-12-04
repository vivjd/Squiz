package data_access;

import entity.Note;
import org.bson.types.ObjectId;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
public class NoteDataAccessObjectTest {
    private final NoteDataAccessObject noteDataAccessObject = new NoteDataAccessObject();

    @Test
    public void testSaveAndGetNote() {
        // Arrange
        Note noteToSave = createTestNote();
        ObjectId noteId = noteToSave.getId();

        // Act
        noteDataAccessObject.saveNote(noteToSave);
        Note retrievedNote = noteDataAccessObject.getNote("Test Title");

        // Assert
    }

    @Test
    public void testGetAllNotes() {
        // Arrange
        Note note1 = createTestNote();
        Note note2 = createTestNote();
        noteDataAccessObject.saveNote(note1);
        noteDataAccessObject.saveNote(note2);

        // Act
        List<Note> allNotes = noteDataAccessObject.getAllNotes();

        // Assert
        assertNotNull(allNotes);
    }

    @Test
    public void testGetAllNotesTable() {
        // Arrange
        Note note1 = createTestNote();
        Note note2 = createTestNote();
        noteDataAccessObject.saveNote(note1);
        noteDataAccessObject.saveNote(note2);

        // Act
        String[][] allNotesTable = noteDataAccessObject.getAllNotesTable();

        // Assert
        assertNotNull(allNotesTable);
    }

    @Test
    public void testDeleteNote() {
        // Arrange
        Note noteToDelete = createTestNote();
        noteToDelete.setId(new ObjectId("656583e8d05ae3b112ed77c1"));
        noteDataAccessObject.saveNote(noteToDelete);
        ObjectId noteId = noteToDelete.getId();

        // Act
        noteDataAccessObject.deleteNote(new ObjectId("656583e8d05ae3b112ed77c1"));

        // Assert
        List<Note> allNotes = noteDataAccessObject.getAllNotes();
    }

    private Note createTestNote() {
        return new Note("Test Title", "Test User Prompt iurshfukhfdkjhskjrdhfkujsdhrfkjsekfjdhwrasgdfasefawefawefaewfwaf");
    }
}
