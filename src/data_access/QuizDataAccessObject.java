package data_access;

import com.mongodb.client.*;
import entity.Quiz;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import use_case.quiz.QuizDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class QuizDataAccessObject implements QuizDataAccessInterface, Database {
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    private final String databaseName = "CSC207CourseProject";
    final String password = "wHobkrGFVf089B3d";

    final String connectionString = "mongodb+srv://mintunxd:" + password + "@csc207courseproject.w8yhgiq.mongodb.net/?retryWrites=true&w=majority";

    // Codec for MongoDB
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    @Override
    public void connect() {
        mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
    }

    @Override
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    public void saveQuiz(Quiz quiz) {
        this.connect();

        MongoCollection<Quiz> collection = mongoDatabase.getCollection("quizzes", Quiz.class);
        collection.insertOne(quiz);
        this.disconnect();
    }

    @Override
    public Quiz getQuiz(String title) {
        return null;
    }

    @Override
    public List<String> getAllQuizzes() {
        List<String> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Quiz> quizzes = mongoDatabase.getCollection("quizzes", Quiz.class).find();

        for (Quiz quiz : quizzes) {
            resultList.add(quiz.toJson());
        }

        return resultList;
    }
}
