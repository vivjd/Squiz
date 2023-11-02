package entity;
class OpenEndedQuestion extends Question {
    private String answer;

    public OpenEndedQuestion(String answer){
        this.answer = answer;
    }

    public void setQuesion(String answer){
        this.setQuesion(answer);
    }
    public String getQuesion(){
        this.getQuesion();
    }
    public String getCorrectAnswer() {
        return answer;
    }
    public void setCorrectAnswer(String answer) {
        this.answer = answer;
    }
}