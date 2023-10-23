package main.java.db;

import com.mongodb.client.MongoDatabase;

import java.util.List;

public interface Database {
    // Define methods for your database operations
    void connect();
    void disconnect();
    void saveData(String data);
    List<String> retrieveData();
}
