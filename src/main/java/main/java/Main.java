package main.java;

import io.github.cdimascio.dotenv.Dotenv;
import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        final String url = "https://api.notion.com/v1/pages";

        Parent parent = new Parent();
        parent.setPageId(dotenv.get("NOTION_PAGE_ID"));

        Title title = new Title();
        Text text = new Text("created with updated java 2");
        title.setText(text);

        Properties properties = new Properties();
        properties.setTitle(new Title[]{title});

        JSONObject jsonBody = new JSONObject();
        jsonBody.put("parent", parent.toJson());
        jsonBody.put("properties", properties.toJson());

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody requestBody = RequestBody.create(mediaType, jsonBody.toString());
        Request.Builder requestBuilder = new Request.Builder();

        Request request = requestBuilder
                .url(url)
                .addHeader("Authorization", dotenv.get("NOTION_KEY"))
                .addHeader("Content-Type", "application/json")
                .addHeader("Notion-Version", "2022-06-28")
                .method("POST", requestBody)
                .build();

        System.out.println(request.toString());
        try {
            Response response = client.newCall(request).execute();
            System.out.println(response);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}