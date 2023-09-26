package main.java;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class NotionApi {
    public static void main(String[] args) {
        final String url = "https://api.notion.com/v1/pages";

        Dotenv dotenv = Dotenv.load();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request.Builder requestBuilder = new Request.Builder();

        MediaType mediaType = MediaType.parse("application/json");
        // Create the "text" JSON object
        JSONObject textObject = new JSONObject();
        textObject.put("content", "created with API on Java");

        // Create the "title" JSON object as an array with the "text" object inside
        JSONArray titleArray = new JSONArray();
        JSONObject titleObject = new JSONObject();
        titleObject.put("text", textObject);
        titleArray.put(titleObject);

        // Create the "properties" JSON object with the "title" array inside
        JSONObject propertiesObject = new JSONObject();
        propertiesObject.put("title", titleArray);

        // Create the "parent" JSON object
        JSONObject parentObject = new JSONObject();
        parentObject.put("page_id", dotenv.get("NOTION_PAGE_ID"));

        // Create the main JSON object with "parent" and "properties" objects
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("parent", parentObject);
        jsonBody.put("properties", propertiesObject);

        // Print the JSON body
        System.out.println(jsonBody.toString());

        RequestBody body = RequestBody.create(mediaType, jsonBody.toString());
        Request request = requestBuilder
                .url(url)
                .addHeader("Authorization", dotenv.get("NOTION_KEY"))
                .addHeader("Content-Type", "application/json")
                .addHeader("Notion-Version", "2022-06-28")
                .method("POST", body)
                .build();
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

