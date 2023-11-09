package interface_adapter.quiz;

public class QuizState {
    private String title = "";

    private int questionNo;

    private String emptyQuizError = null;

    public QuizState(){

    }

    public QuizState(QuizState copy){
        this.title = copy.title;
        this.questionNo = copy.questionNo;
        this.emptyQuizError = copy.emptyQuizError;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public String getEmptyQuizError() {
        return emptyQuizError;
    }

    public void setEmptyQuizError(String emptyQuizError) {
        this.emptyQuizError = emptyQuizError;
    }
}
