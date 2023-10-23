package main.java.db;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MongoDB implements Database {
    private MongoClient mongoClient;
    private MongoDatabase mongoDatabase;


    private final String password = "wHobkrGFVf089B3d";
    // MongoDB connection string (replace with your MongoDB URI)
    private final String connectionString = "mongodb+srv://mintunxd:" + password +"@csc207courseproject.w8yhgiq.mongodb.net/?retryWrites=true&w=majority";

    // MongoDB database name
    private final String databaseName = "CSC207CourseProject";

    @Override
    public void connect() {
        // Create a MongoClient with the given connection string
        mongoClient = MongoClients.create(connectionString);

        // Get the database instance
        mongoDatabase = mongoClient.getDatabase(databaseName);
    }

    @Override
    public void disconnect() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    @Override
    public void saveData(String data) {
        // Implement the saveData method using MongoDB
        // You can use the `mongoDatabase` instance to perform MongoDB operations
        // For example:
         mongoDatabase.getCollection("yourCollectionName").insertOne(new Document("key", "value"));
    }

    @Override
    public List<String> retrieveData() {
        // Implement the retrieveData method using MongoDB
        // You can use the `mongoDatabase` instance to query and retrieve data
        // For example:
        List<String> resultList = new ArrayList<>();

        FindIterable<Document> documents = mongoDatabase.getCollection("yourCollectionName").find();

        for (Document document : documents) {
            resultList.add(document.toJson()); // Convert retrieved data to the desired format
        }

        return resultList;
    }
}
