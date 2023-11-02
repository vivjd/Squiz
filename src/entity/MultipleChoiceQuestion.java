package entity;
class MultipleChoiceQuestion extends Question {
    private Map<int, String> answerOptions = new HashMap<>();
    private int correctAnswer;

    public MultipleChoiceQuestion(Map<int, String> answerOptions, int correctAnswer){
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
    }

    public void setQuesion(String answer){
        this.setQuesion(answer);
    }
    public String getQuesion(){
        this.getQuesion();
    }
    public String getanswerOptions() {
        return answerOptions;
    }
    public void setanswerOptions(Map<int, String> ansOps) {
        this.answerOptions = ansOps;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int ans) {
        this.correctAnswer = ans;
    }
}
