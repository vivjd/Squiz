package use_case.quiz.generate;


import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.util.EntityUtils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.io.ByteArrayInputStream;

import java.io.InputStream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class ChatbotTest {

    @Mock
    private HttpClient httpClient;

    @Mock
    private HttpPost httpPost;

    @Mock
    private HttpResponse httpResponse;

    @InjectMocks
    private Chatbot chatbot;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserInput() throws Exception {
        // Arrange
        String testInput = "Test input";
        provideSystemInput(testInput);

        // Act
        String userInput = chatbot.getUserInput();

        // Assert
        assertEquals(testInput, userInput);
    }
    @Test
    void testGetChatGPTResponse() throws Exception {
        // Arrange
        String userInput = "Test user input";
        String expectedResponse = "Test GPT response";

        when(httpClient.execute(any())).thenReturn(httpResponse);
        when(httpResponse.getEntity()).thenReturn(null);
        when(EntityUtils.toString(httpResponse.getEntity())).thenReturn("{\"choices\":[{\"message\":{\"content\":\"" + expectedResponse + "\"}}]}");

        // Allow real method invocation for createHttpClient()
        doNothing().when(chatbot);
        Chatbot.getChatGPTResponse(userInput);

        // Act
        String actualResponse = Chatbot.getChatGPTResponse(userInput);

        // Assert
        assertEquals(expectedResponse, actualResponse);
    }
    private void provideSystemInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
    }
}

