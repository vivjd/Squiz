package use_case.quiz;

import io.github.cdimascio.dotenv.Dotenv;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Chatbot {
    static Dotenv dotenv = Dotenv.load();
    private static final String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");
    private static final String OPENAI_ENDPOINT = "https://api.openai.com/v1/chat/completions";

    public static void main(String[] args) {
        try {
            Chatbot gpt = new Chatbot();
            String userInput = gpt.getUserInput();
            String response = gpt.getChatGPTResponse(userInput);

            System.out.println("ChatGPT: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Chatbot(){
    }

    public String getUserInput() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("You: ");
        return reader.readLine();
    }

    public static String getChatGPTResponse(String userInput) throws Exception {
        String apiKey = OPENAI_API_KEY;
        String model = "gpt-4-1106-preview";
        String prompt = "[{\"role\": \"user\", \"content\": \"" + userInput + "\"}]";
        int maxTokens = 3000;

        String requestBody = "{\"model\": \"" + model + "\", \"messages\": " + prompt + ", \"max_tokens\": " + maxTokens + "}";

        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(OPENAI_ENDPOINT);

        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        httpPost.setEntity(new StringEntity(requestBody));

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity responseEntity = httpResponse.getEntity();

        if (responseEntity != null) {

            String response = EntityUtils.toString(responseEntity);
            String apiResponse = response;
            JSONObject jsonResponse = new JSONObject(apiResponse);
            EntityUtils.consume(responseEntity);
            JSONArray choices = jsonResponse.getJSONArray("choices");
            JSONObject firstChoice = choices.getJSONObject(0);
            JSONObject message = firstChoice.getJSONObject("message");
            String content = message.getString("content");
            return content;
        } else {
            throw new IllegalStateException("Empty response entity");
        }
    }
}