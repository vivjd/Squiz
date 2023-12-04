package use_case.quiz.generate;

import org.apache.http.HttpResponse;

public class RequestMaker implements HttpClientInterface{

    public RequestMaker(){
    }
    @Override
    public HttpResponse executePostRequest(String endpoint, String apiKey, String requestBody) throws Exception {
        return null;
    }
}
