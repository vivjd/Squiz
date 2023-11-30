package entity;

import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Represents a multiple-choice question with a set of answer options and a correct answer index.
 * Extends the abstract class Question with Integer as the answer type.
 */

public class MultipleChoiceQuestion extends Question<Integer> {

    /**
     * Map containing answer options where the key is the option index, and the value is the option text.
     */
    private Map<Integer, String> answerOptions;
@BsonDiscriminator
public class MultipleChoiceQuestion extends Question<String> {
    private Map<String, String> answerOptions;

    /**
     * Index representing the correct answer among the answer options.
     */
    private int correctAnswerIndex;

    /**
     * The text of the multiple-choice question.
     */
    private String correctAnswerIndex;

    @BsonProperty("question")
    private String question;


    /**
     * Constructs a MultipleChoiceQuestion with the specified question, answer options, and correct answer index.
     *
     * @param question           The text of the multiple-choice question.
     * @param answerOptions      Map containing answer options where the key is the option index,
     *                           and the value is the option text.
     * @param correctAnswerIndex Index representing the correct answer among the answer options.
     */
    public MultipleChoiceQuestion(String question, Map<Integer, String> answerOptions, int correctAnswerIndex){

    public MultipleChoiceQuestion() {
    }

    public MultipleChoiceQuestion(@BsonProperty("question") String question,
                                  @BsonProperty("answerOptions") Map<String, String> answerOptions,
                                  @BsonProperty("correctAnswerIndex") String correctAnswerIndex) {

        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    /**
     * Retrieves the text of the multiple-choice question.
     *
     * @return The text of the multiple-choice question.
     */
    public String getQuestion(){

    public String getQuestion() {
        return this.question;
    }

    /**
     * Checks the user's response against the correct answer index.
     *
     * @param userResponse The user's response to the multiple-choice question.
     * @return 1 if the user's response is correct, 0 otherwise.
     */

    @Override
    public int checkAnswer(Object userResponse) {
        String userResponseInt = (String) userResponse;
        if (userResponseInt == correctAnswerIndex) return 1;
        return 0;
    }

    /**
     * Marks the answer as displayed.
     */
    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }


    /**
     * Sets the text of the multiple-choice question.
     *
     * @param question The text of the multiple-choice question.
     */public void setQuestion(String question){
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Retrieves the answer options for the multiple-choice question.
     *
     * @return Map containing answer options where the key is the option index, and the value is the option text.
     */
    public Map<Integer, String> getAnswerOptions() {
    public Map<String, String> getAnswerOptions() {

        return answerOptions;
    }

    /**
     * Sets the answer options for the multiple-choice question.
     *
     * @param ansOps Map containing answer options where the key is the option index, and the value is the option text.
     */
    public void setAnswerOptions(HashMap<Integer, String> ansOps) {

    public void setAnswerOptions(Map<String, String> ansOps) {
        this.answerOptions = ansOps;
    }

    /**
     * Retrieves the index representing the correct answer among the answer options.
     *
     * @return Index representing the correct answer among the answer options.
     */
    public int getCorrectAnswerIndex() {

    public String getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }

    /**
     * Sets the index representing the correct answer among the answer options.
     *
     * @param correctAnswer Index representing the correct answer among the answer options.
     */
    public void setCorrectAnswerIndex(int correctAnswer){

    public void setCorrectAnswerIndex(String correctAnswer) {
        this.correctAnswerIndex = correctAnswer;
    }
}