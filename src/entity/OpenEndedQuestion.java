package entity;
class OpenEndedQuestion extends Question {
    private String answer;
    private String question;

    public OpenEndedQuestion(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public void setQuestion(String question){
        this.question = question;
    }
    public String getQuestion(){
        return this.question;
    }
    public String getCorrectAnswer() {
        return answer;
    }
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}