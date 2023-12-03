package use_case.quiz.generate.strategies;

/**
 * this class is responsible for creating a Quiz through Google Search
 */
public class GoogleSearch implements QuizCreatorStrategy {
    /**
     * this method generates a response to create a quiz
     * @param input is the String of what to generate the quiz with
     * @return a String of a quiz
     * @throws Exception if it cannot generate a quiz
     */
    @Override
    public String getChatAnswer(String input) throws Exception {
        return null;
    }
}
