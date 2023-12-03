package use_case.quiz.generate;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.quiz.generate.strategies.GPT;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class GPTTest {

    @Test
    void getChatAnswer() throws Exception {
        // Mocking dependencies
        HttpClient httpClient = Mockito.mock(HttpClient.class);
        HttpResponse httpResponse = Mockito.mock(HttpResponse.class);
        HttpEntity httpEntity = Mockito.mock(HttpEntity.class);

        GPT gpt = new GPT();

        // Setting up the mock behavior
        when(httpClient.execute(Mockito.any(HttpPost.class))).thenReturn(httpResponse);
        when(httpResponse.getEntity()).thenReturn(httpEntity);
        when(httpEntity.getContent()).thenReturn(getMockedInputStream());

        // Testing the getChatAnswer method
        String userInput = "Test user input";
        String actualResponse = gpt.getChatAnswer(userInput);

        // Asserting the result
        assertTrue(actualResponse instanceof String);
    }

    private String getMockedResponse() {
        // Provide a sample mocked response as a JSON string
        return "{\"choices\":[{\"message\":{\"content\":\"Mocked GPT response\"}}]}";
    }
    private InputStream getMockedInputStream() {
        // Provide a sample mocked response as an InputStream
        return new ByteArrayInputStream(getMockedResponse().getBytes(StandardCharsets.UTF_8));
    }
}