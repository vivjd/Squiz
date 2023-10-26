package data_access;

import com.mongodb.client.*;
import entity.Note;
import use_case.note.NoteDataAccessInterface;
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

    private final String databaseName = "CSC207CourseProject";
    final String password = "wHobkrGFVf089B3d";

    final String connectionString = "mongodb+srv://mintunxd:" + password + "@csc207courseproject.w8yhgiq.mongodb.net/?retryWrites=true&w=majority";

    // Codec for MongoDB
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));


    public void connect() {
        mongoClient = MongoClients.create(connectionString);

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
            resultList.add(note.toJson());
        }

        return resultList;
    }
}
