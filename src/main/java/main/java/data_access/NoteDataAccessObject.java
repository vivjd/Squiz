package main.java.data_access;

import com.mongodb.client.*;
import main.java.entity.Note;
import main.java.usecase.note.NoteDataAccessInterface;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class NoteDataAccessObject implements NoteDataAccessInterface, Database{
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    // NoteDataAccessObject database name
    private final String databaseName = "CSC207CourseProject";
    final String password = "wHobkrGFVf089B3d";

    // NoteDataAccessObject connection string (replace with your NoteDataAccessObject URI)
    final String connectionString = "mongodb+srv://mintunxd:" + password + "@csc207courseproject.w8yhgiq.mongodb.net/?retryWrites=true&w=majority";

    // Codec for MongoDB
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));


    public void connect() {
        // Create a MongoClient with the given connection string
        mongoClient = MongoClients.create(connectionString);

        // Get the database instance
        mongoDatabase = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
    }

    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public void saveNote(Note note) {
        this.connect();

        MongoCollection<Note> collection = mongoDatabase.getCollection("notes", Note.class);
        collection.insertOne(note);
        this.disconnect();
    }

    @Override
    public Note getNote(String title) {
        return null;
    }

    public List<String> getAllNotes() {
        List<String> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Note> notes = mongoDatabase.getCollection("notes", Note.class).find();

        for (Note note : notes) {
            resultList.add(note.toJson()); // Convert retrieved data to the desired format
        }

        return resultList;
    }
}
