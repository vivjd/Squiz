package use_case.quiz.generate;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.quiz.generate.strategies.GPT;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        when(httpEntity != null ? EntityUtils.toString(httpEntity) : null).thenReturn(getMockedResponse());

        // Testing the getChatAnswer method
        String userInput = "Test user input";
        String actualResponse = gpt.getChatAnswer(userInput);
        String expectedResponse = "Mocked GPT response";

        // Asserting the result
        assertEquals(expectedResponse, actualResponse);
    }

    private String getMockedResponse() {
        // Provide a sample mocked response as a JSON string
        return "{\"choices\":[{\"message\":{\"content\":\"Mocked GPT response\"}}]}";
    }
}