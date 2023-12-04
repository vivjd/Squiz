package entity;


import org.bson.codecs.pojo.annotations.BsonDiscriminator;
import org.bson.codecs.pojo.annotations.BsonProperty;

/**
 * this class is a child of the Quiz
 * represents an open-ended question
 * @see Question
 */
@BsonDiscriminator
public class OpenEndedQuestion extends Question<String> {

    private String answer;
    @BsonProperty("question")
    private String question;

    /**
     * empty constructor that creates and empty open ended question
     */
    public OpenEndedQuestion() {
    }

    /**
     * creates an open-ended question object given the question and the answer
     * @param question is the String question
     * @param answer is the String answer
     */
    public OpenEndedQuestion(@BsonProperty("question") String question, @BsonProperty("answer") String answer){
        this.question = question;
        this.answer = answer;
    }

    /**
     * this method changes when the answer needs to be displayed
     */
    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    /**
     * this method is responsible for setting the question
     * @param question The text of the question.
     */
    public void setQuestion(String question){
        this.question = question;
    }

    /**
     * returns the question
     * @return String of the question
     */
    public String getQuestion(){
        return this.question;
    }

    /**
     * checks if the user answered the question, and it matches the answer stored
     * @param userResponse The user's response to the question.
     * @return 1 if it matches, 0 otherwise
     */
    @Override
    public int checkAnswer(Object userResponse) {
        if (userResponse == answer) return 1;
        return 0;
    }

    /**
     * returns the correct answer
     * @return String of the correct answer
     */
    public String getCorrectAnswer() {
        return answer;
    }

    /**
     * sets the correct asnwer
     * @param answer String of the correct answer
     */
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}
