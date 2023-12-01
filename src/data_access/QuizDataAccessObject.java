package data_access;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndDeleteOptions;

import entity.Quiz;
import org.bson.Document;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.types.ObjectId;
import use_case.quiz.QuizDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * The {@code QuizDataAccessObject} class implements the {@link QuizDataAccessInterface}
 * and {@link Database} interfaces to provide data access operations for quizzes using MongoDB.
 * It establishes a connection to a MongoDB database, saves, retrieves, and manipulates quiz data.
 * //TODO: edit this after project finishes
 * <p><b>Note:</b> The implementation includes methods for connecting to and disconnecting
 * from the MongoDB database, saving a quiz, retrieving all quizzes, retrieving a quiz by
 * its unique identifier, and obtaining quiz information in a tabular format.</p>
 *
 * @see QuizDataAccessInterface
 * @see Database
 */
public class QuizDataAccessObject implements QuizDataAccessInterface, Database {
    /** The number of columns in the quiz table. */
    public static final int COLUMN_NUM = 3;
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;

    private final String databaseName = "CSC207CourseProject";
    final String password = "wHobkrGFVf089B3d";

    final String connectionString = "mongodb+srv://mintunxd:" + password + "@csc207courseproject.w8yhgiq.mongodb.net/?retryWrites=true&w=majority";

    // Codec for MongoDB
    CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
    CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));

    /**
     * Establishes a connection to the MongoDB database.
     */
    @Override
    public void connect() {
        mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
    }

    /**
     * Disconnects from the MongoDB database.
     */
    @Override
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    /**
     * Saves the given quiz to the MongoDB database.
     *
     * @param quiz The quiz to be saved.
     */
    @Override
    public void saveQuiz(Quiz quiz) {
        this.connect();

        MongoCollection<Quiz> collection = mongoDatabase.getCollection("quizzes", Quiz.class);
        collection.insertOne(quiz);
        this.disconnect();
    }

    /**
     * Retrieves a quiz from the MongoDB database based on its title.
     *
     * @param title The title of the quiz to retrieve.
     * @return The retrieved quiz.
     */
    @Override
    public Quiz getQuiz(String title) {
        this.connect();

        Quiz quiz = mongoDatabase.getCollection("quizzes", Quiz.class)
                .find(Filters.eq("title", title))
                .first();

        this.disconnect();

        return quiz;
    }

    /**
     * Retrieves a list of all quizzes from the MongoDB database.
     *
     * @return A list containing all quizzes in the database.
     */
    @Override
    public List<Quiz> getAllQuizzes() {
        List<Quiz> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Quiz> quizzes = mongoDatabase.getCollection("quizzes", Quiz.class).find();
        for (Quiz quiz : quizzes) {
            resultList.add(quiz);
        }

        return resultList;
    }

    /**
     * Retrieves information about all quizzes in a tabular format from the MongoDB database.
     *
     * @return A 2D array representing quiz information in a tabular format.
     */
    @Override
    public String[][] getAllQuizzesTable(){
        List<Quiz> resultList = getAllQuizzes();

        String[][] outputTableData = new String[resultList.size()][COLUMN_NUM];
        for (int i = 0; i < resultList.size(); i++) {
            Quiz currentQuiz = resultList.get(i);
            outputTableData[i][0] = currentQuiz.getTitle();
            outputTableData[i][1] = Integer.toString(currentQuiz.getQuizLength());
            outputTableData[i][2] = currentQuiz.getCreationTime();
        }

        this.disconnect();

        return outputTableData;
    }

    /**
     * Retrieves a quiz from the MongoDB database based on its unique identifier.
     * Assumes the quizId is a valid id.
     *
     * @param quizId The unique identifier of the quiz to retrieve.
     * @return The retrieved quiz.
     */
    @Override
    public Quiz getQuizById(ObjectId quizId) {
        this.connect();

        Quiz quiz = mongoDatabase.getCollection("quizzes", Quiz.class)
                .find(new Document("_id", quizId))
                .first();

        this.disconnect();

        return quiz;
    }

    /**
     * Deletes a quiz from the MongoDB database based on its unique identifier.
     *
     * @param quizId The unique identifier of the quiz to delete.
     */
    @Override
    public void deleteQuizById(ObjectId quizId){
        this.connect();
        FindOneAndDeleteOptions options = new FindOneAndDeleteOptions().projection(Document.parse("{_id: 1}"));
        Quiz deletedDocument = mongoDatabase
                .getCollection("quizzes", Quiz.class)
                .findOneAndDelete(Filters.eq("_id", quizId), options);
        this.disconnect();
        if (deletedDocument != null) {
            return;
        } else {
            throw new RuntimeException("Quiz with objectId: " + quizId + " not found.");
        }
    }

    /**
     * Retrieves all unique identifiers (ObjectIds) of quizzes in the MongoDB database.
     *
     * @return An array of ObjectIds representing all quizzes in the database.
     */
    @Override
    public ObjectId[] getAllIds() {
        List<Quiz> resultList = getAllQuizzes();
        ObjectId[] ids = new ObjectId[resultList.size()];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = resultList.get(i).getId();
        }
        return ids;
    }
}
