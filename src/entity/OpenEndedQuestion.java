package entity;
class OpenEndedQuestion extends Question {
    private String answer;
    private String question;

    public OpenEndedQuestion(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public void setQuesion(String question){
        this.question = question;
    }
    public String getQuesion(){
        return this.question;
    }
    public String getCorrectAnswer() {
        return answer;
    }
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}