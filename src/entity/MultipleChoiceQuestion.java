package entity;
class MultipleChoiceQuestion extends Question {
    private Map<int, String> answerOptions = new HashMap<>();
    private int correctAnswer;
    private String question;

    public MultipleChoiceQuestion(String question, Map<int, String> answerOptions, int correctAnswer){
        this.question = question;
        this.answerOptions = answerOptions;
        this.correctAnswer = correctAnswer;
    }

    public void setQuesion(String question){
        this.question = question;
    }
    public String getQuesion(){
        return this.question;
    }
    public String getAnswerOptions() {
        return answerOptions;
    }
    public void setAnswerOptions(Map<int, String> ansOps) {
        this.answerOptions = ansOps;
    }
    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public void setCorrectAnswer(int ans) {
        this.correctAnswer = ans;
    }
}
