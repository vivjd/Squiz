package main.java;

import main.java.db.Database;
import main.java.db.MongoDB;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Initialize and use the MongoDB implementation of the Database interface
        Database mongoDB = new MongoDB();
        mongoDB.connect();

        // Example usage:
        mongoDB.saveData("Your data to save");
        List<String> retrievedData = mongoDB.retrieveData();
        System.out.println("Retrieved data: " + retrievedData);

        // Don't forget to disconnect when you're done with the database
        mongoDB.disconnect();
    }
}