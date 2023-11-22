package data_access;

import com.mongodb.client.*;

import com.mongodb.client.model.Filters;
import entity.Question;
import entity.MultipleChoiceQuestion;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import use_case.question.QuestionDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class QuestionDataAccessObject implements QuestionDataAccessInterface, Database {
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
    public void saveQuestion(Question question) {
        this.connect();

        MongoCollection<Question> collection = mongoDatabase.getCollection("questions", Question.class);
        collection.insertOne(question);
        this.disconnect();
    }

    @Override
    public Question getQuestion() {
        return null;
    }

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

    public boolean isInstanceOfMCQ(String questionName){
        // TODO: Implementation below assumes that each Question stores as
        Question q = getQuestionByName(questionName);
        return q instanceof MultipleChoiceQuestion;
    }

    public String answerFeedback(String questionName, String userAnswer){
        if (isInstanceOfMCQ(questionName)){
            // there's an issue with the way i'm finding out whether a question is a MCQ or Open ended, will look into it
            MultipleChoiceQuestion q = (MultipleChoiceQuestion) getQuestionByName(questionName);
            String correctAnswer = getMCQCorrectAnswer(q);
            if (correctAnswer.equals(userAnswer)){
                return "Your answer is correct!";
            } else{
                return "Your answer is incorrect. The correct answer is " + correctAnswer + ".";
            }
        } else {
            //assume that if question is not a MCQ then it must be a OpenEndedQuestion
            // we need to do some Hugginface API calling here to get feedback
            // code below assumes we've got gained feedback already
            String feedback = "Some feedback from hugginface"; //change this
            return feedback;
        }
    }

    public String getMCQCorrectAnswer(MultipleChoiceQuestion q){
        Map<Integer, String> answerOptions = q.getAnswerOptions();
        return answerOptions.get(q.getCorrectAnswerIndex());
    }

    public List<String> getAllQuestionNames(){
        List<String> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Question> questions = mongoDatabase.getCollection("questions", Question.class).find();

        for (Question question : questions) {
            resultList.add(question.toJson());
        }

        return resultList;
    }

    public List<Question> getQuestions(){
        List<Question> resultList = new ArrayList<>();

        this.connect();

        FindIterable<Question> questions = mongoDatabase.getCollection("questions", Question.class).find();

        for (Question question : questions) {
            resultList.add(question);
        }
        return resultList;
    }

//    public boolean getQuestionType(){
//        this.connect();
//
//        // Assuming there is a field in the Question class named "name"
//        Bson filter = Filters.eq("name", questionName);
//
//        MongoCollection<Question> collection = mongoDatabase.getCollection("questions", Question.class);
//        Question question = collection.find(filter).first();
//
//        this.disconnect();
//
//        return question;
//    }
}
