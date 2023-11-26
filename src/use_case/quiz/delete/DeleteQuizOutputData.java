package use_case.quiz.delete;

public class DeleteQuizOutputData {
    private String quizName;
    private int quizLength;

    public DeleteQuizOutputData(String quizName, int quizLength) {
        this.quizName = quizName;
        this.quizLength = quizLength;
    }

    public String getQuizName() {
        return quizName;
    }

    public int getQuizLength() {
        return quizLength;
    }
}
