package entity;

/**
 * Represents an open-ended question with a text question and a string answer.
 * Extends the abstract class Question with String as the answer type.
 */
import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

@BsonDiscriminator
public class OpenEndedQuestion extends Question<String> {
    /**
     * The correct answer to the open-ended question.
     * The answer is not comprehensive, meaning that the user's answer DOES NOT and
     * is not possible to follow this given answer.
     */
    private String answer;

    /**
     * The text of the open-ended question.
     */
    @BsonProperty("question")
    private String question;


    /**
     * Constructs an OpenEndedQuestion with the specified question and answer.
     *
     * @param question The text of the open-ended question.
     * @param answer   The correct answer to the open-ended question.
     */

    public OpenEndedQuestion(@BsonProperty("question") String question, @BsonProperty("answer") String answer){
        this.question = question;
        this.answer = answer;
    }

    /**
     * Marks the answer as displayed for the front-end purpose.
     */
    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    /**
     * Sets the text of the open-ended question.
     *
     * @param question The text of the open-ended question.
     */
    public void setQuestion(String question){
        this.question = question;
    }

    /**
     * Retrieves the text of the open-ended question.
     *
     * @return The text of the open-ended question.
     */
    public String getQuestion(){
        return this.question;
    }


    /**
     * Checks the user's response against the correct answer.
     *
     * @param userResponse The user's response to the open-ended question.
     * @return 1 if the user's response is correct, 0 otherwise.
     */
    @Override
    public int checkAnswer(Object userResponse) {
        if (userResponse == answer) return 1;
        return 0;
    }

    /**
     * Retrieves the correct answer to the open-ended question.
     *
     * @return The correct answer to the open-ended question.
     */
    public String getCorrectAnswer() {
        return answer;
    }

    /**
     * Sets the correct answer to the open-ended question.
     *
     * @param answer The correct answer to the open-ended question.
     */
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}