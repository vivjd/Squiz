package use_case.quiz.generate;

import org.apache.http.HttpResponse;

/**
 * The HttpClientInterface provides an abstraction for HTTP client operations.
 */
public interface HttpClientInterface {
    HttpResponse executePostRequest(String endpoint, String apiKey, String requestBody) throws Exception;
}

