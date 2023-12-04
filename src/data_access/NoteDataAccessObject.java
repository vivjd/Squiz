package data_access;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndDeleteOptions;
import entity.Note;
import org.bson.Document;
import org.bson.types.ObjectId;
import use_case.note.NoteDataAccessInterface;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * this class is the DAO of the notes
 * serves as a bridge between entities and data base
 */
public class NoteDataAccessObject implements NoteDataAccessInterface, Database {
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    private final String databaseName = "CSC207CourseProject";
    final String password = "wHobkrGFVf089B3d";

    final String connectionString = "mongodb+srv://mintunxd:" + password + "@csc207courseproject.w8yhgiq.mongodb.net/?retryWrites=true&w=majority";

    // Codec for MongoDB
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    /**
     * method to connect to the data base
     */
    public void connect() {
        mongoClient = MongoClients.create(connectionString);

        mongoDatabase = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
    }

    /**
     * method to disconnect to the data base
     */
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    /**
     * save note to the data base
     * @param note is the note to save to data base
     */
    public void saveNote(Note note) {
        this.connect();

        MongoCollection<Note> collection = mongoDatabase.getCollection("notes", Note.class);
        collection.insertOne(note);
        this.disconnect();
    }

    /**
     * returns the note based on the title given
     * @param title is the title of the note to find
     * @return the note if found, returns null if not found
     */
    @Override
    public Note getNote(String title) {
        return null;
    }

    /**
     * returns all the notes from database
     * @return List<Note> of the notes from database
     */
    @Override
    public List<Note> getAllNotes() {
        List<Note> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Note> notes = mongoDatabase.getCollection("notes", Note.class).find();

        for (Note note : notes) {
            resultList.add(note);
        }
        this.disconnect();

        return resultList;
    }

    /**
     * returns a String[][] representation of all the notes in the database
     * @return String[][] if all the notes in data base
     */
    @Override
    public String[][] getAllNotesTable() {
        List<Note> resultList = getAllNotes();

        String[][] outputTable = new String[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            Note currNote = resultList.get(i);
            outputTable[i][0] = currNote.getTitle();
            outputTable[i][1] = currNote.getUserPrompt();
        }

        this.disconnect();
        return outputTable;
    }

    /**
     * gets all the id of all the notes
     * @return ObjectId[] of all the notes in data base
     */
    @Override
    public ObjectId[] getAllIds() {
        List<Note> resultList = getAllNotes();
        ObjectId[] ids = new ObjectId[resultList.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = resultList.get(i).getId();
        }
        return ids;
    }

    /**
     * deletes the note from the data base
     * @param objectId is the id of the note to delete from the database
     */
    @Override
    public void deleteNote(ObjectId objectId) {

        this.connect();
        FindOneAndDeleteOptions options = new FindOneAndDeleteOptions().projection(Document.parse("{_id: 1}"));
        Note deletedDocument = mongoDatabase
                .getCollection("notes", Note.class)
                .findOneAndDelete(Filters.eq("_id", objectId), options);
        this.disconnect();
        if (deletedDocument != null) {
            return;
        } else {
            throw new RuntimeException("note with objectId " + objectId + " note found");
        }


    }
}
