package entity;
public class OpenEndedQuestion extends Question<String> {
    private String answer;
    private String question;

    public OpenEndedQuestion(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    @Override
    public void displayAnswer() {
        this.answerDisplayed = true;
    }

    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return this.question;
    }

    @Override
    public int checkAnswer(Object userResponse) {
        if (userResponse == answer) return 1;
        return 0;
    }

    public String getCorrectAnswer() {
        return answer;
    }
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}