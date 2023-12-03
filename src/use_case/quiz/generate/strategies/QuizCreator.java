package use_case.quiz.generate.strategies;

/**
 * this class is responsible for creating maintaining a concrete strategy and executes the strategy
 * via the strategy interface
 */
public class QuizCreator {
    private QuizCreatorStrategy quizCreatorStrategy;

    /**
     * this is the constructor that creates an instance of an object
     * @param quizCreatorStrategy
     */
    public QuizCreator(QuizCreatorStrategy quizCreatorStrategy) {this.quizCreatorStrategy = quizCreatorStrategy;}

    /**
     * this method generates a response to create a quiz
     * @param input is the String of what to generate the quiz with
     * @return a String of a quiz
     * @throws Exception if it cannot generate a quiz
     */
    public String getQuiz(String input) throws Exception {
        return quizCreatorStrategy.getChatAnswer(input);
    }

}
