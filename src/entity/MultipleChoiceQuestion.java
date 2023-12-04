package entity;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.Map;

/**
 * this class is the child class of Question
 * represents multiple choice question
 *
 * @see Question
 */
@BsonDiscriminator
public class MultipleChoiceQuestion extends Question<String> {
    private Map<String, String> answerOptions;

    private String correctAnswerIndex;

    @BsonProperty("question")
    private String question;


    /**
     * creates empty MCQ
     */
    public MultipleChoiceQuestion() {
    }

    /**
     * creates MCQ based on the question, the options and the correct answer
     * @param question is the question
     * @param answerOptions is a Map<String> of the answer were the keys are the options
     *                      and the values are the potential answers
     * @param correctAnswerIndex is the correct option
     */
    public MultipleChoiceQuestion(@BsonProperty("question") String question,
                                  @BsonProperty("answerOptions") Map<String, String> answerOptions,
                                  @BsonProperty("correctAnswerIndex") String correctAnswerIndex) {

        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /**
     * returns the question
     * @return String question
     */
    public String getQuestion() {
        return this.question;
    }


    /**
     * checks if the user selects the right answer
     * @param userResponse The user's response to the question.
     * @return 1 if it is right, 0 otherwise
     */
    @Override
    public int checkAnswer(Object userResponse) {
        String userResponseInt = (String) userResponse;
        if (userResponseInt == correctAnswerIndex) return 1;
        return 0;
    }

    /**
     * this method is to know when to show the answer
     */
    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    /**
     * sets the question
     * @param question The text of the question.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * returns all the answer options
     * @return Map<String, String> of the answer options
     */
    public Map<String, String> getAnswerOptions() {

        return answerOptions;
    }

    /**
     * sets the Answer options
     * @param ansOps Map<String, String> of the answer options
     */
    public void setAnswerOptions(Map<String, String> ansOps) {
        this.answerOptions = ansOps;
    }

    /**
     * returns the correct answer to the MCQ
     * @return the correct answer
     */
    public String getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    /**
     * sets the correct answer to the MCQ
     * @param correctAnswer is the String of the correctAnswer
     */
    public void setCorrectAnswerIndex(String correctAnswer) {
        this.correctAnswerIndex = correctAnswer;
    }
}