package data_access;

import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import entity.MultipleChoiceQuestion;
import entity.Question;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import use_case.question.QuestionDataAccessInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * this class serves as our DAO for Questions
 * serves as a bridge between entities and data base
 */
public class QuestionDataAccessObject implements QuestionDataAccessInterface, Database {
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
    @Override
    public void connect() {
        mongoClient = MongoClients.create(connectionString);
        mongoDatabase = mongoClient.getDatabase(databaseName).withCodecRegistry(pojoCodecRegistry);
    }

    /**
     * method to disconnect to the data base
     */
    @Override
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }


    /**
     * saves the question to the database
     * @param question is the question to save
     */
    @Override
    public void saveQuestion(Question question) {
        this.connect();

        MongoCollection<Question> collection = mongoDatabase.getCollection("questions", Question.class);
        collection.insertOne(question);
        this.disconnect();
    }

    /**
     * returns the Question
     * @return question
     */
    @Override
    public Question getQuestion() {
        return null;
    }

    /**
     * returns a question based on its name
     * @param questionName is the String of the name of the question
     * @return Question with the name given
     */
    @Override
    public Question getQuestionByName(String questionName) {
        this.connect();

        // Assuming there is a field in the Question class named "name"
        Bson filter = Filters.eq("name", questionName);

        MongoCollection<Question> collection = mongoDatabase.getCollection("questions", Question.class);
        Question question = collection.find(filter).first();

        this.disconnect();

        return question;
    }

    /**
     * checks if the name of the question is MCQ
     * @param questionName is the name of the question
     * @return True if yes, False otherwise
     */
    public boolean isInstanceOfMCQ(String questionName){
        // TODO: Implementation below assumes that each Question stores as
        Question q = getQuestionByName(questionName);
        return q instanceof MultipleChoiceQuestion;
    }


    /**
     * returns the correct answer of MCQ
     * @param q is the question
     * @return the answer to the question given
     */
    public String getMCQCorrectAnswer(MultipleChoiceQuestion q){
        Map<String, String> answerOptions = q.getAnswerOptions();

        return answerOptions.get(q.getCorrectAnswerIndex());
    }

    /**
     * returns all the questions
     * @return List<String> questions
     */
    public List<String> getAllQuestionNames(){
        List<String> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Question> questions = mongoDatabase.getCollection("questions", Question.class).find();

        for (Question question : questions) {
            resultList.add(question.toJson());
        }

        return resultList;
    }

    /**
     * returns all the Questions
     * @return List<Question> Questions
     */
    public List<Question> getQuestions(){
        List<Question> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Question> questions = mongoDatabase.getCollection("questions", Question.class).find();

        for (Question question : questions) {
            resultList.add(question);
        }
        return resultList;
    }
}
