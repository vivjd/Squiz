package use_case.quiz.generate.strategies;

/**
 * this interface is responsible for declaring a common method to
 * execute a certain strategy
 */
public interface QuizCreatorStrategy {
    String getUserInput() throws Exception;

    String getChatAnswer(String input) throws Exception;
}
