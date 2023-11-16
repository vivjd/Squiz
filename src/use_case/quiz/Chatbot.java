package use_case.quiz;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Chatbot {
    static Dotenv dotenv = Dotenv.load();



    private static final String OPENAI_API_KEY = dotenv.get("OPENAI_API_KEY");;
    private static final String OPENAI_ENDPOINT = "https://api.openai.com/v1/fine_tuning/jobs";

    public static void main(String[] args) {
        try {
            String userInput = getUserInput();
            String response = getChatGPTResponse(userInput);

            System.out.println("ChatGPT: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getUserInput() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("You: ");
        return reader.readLine();
    }

    private static String getChatGPTResponse(String userInput) throws Exception {
        String apiKey = "Bearer " + OPENAI_API_KEY;
        String data = "{\"messages\": [{\"role\": \"system\", \"content\": \"You are a helpful assistant.\"}, {\"role\": \"user\", \"content\": \"" + userInput + "\"}]}";

        URL url = new URL(OPENAI_ENDPOINT);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Authorization", apiKey);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        byte[] input = data.getBytes(StandardCharsets.UTF_8);
        connection.getOutputStream().write(input);

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        return response.toString();
    }
}