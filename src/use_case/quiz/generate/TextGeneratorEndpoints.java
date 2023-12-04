package use_case.quiz.generate;

public interface TextGeneratorEndpoints {
    String getUserInput() throws Exception;
    String getChatGPTResponse(String string) throws Exception;
}
