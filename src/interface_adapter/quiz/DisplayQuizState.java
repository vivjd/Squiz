package interface_adapter.quiz;

public class DisplayQuizState {
    private String[][] quizzesTable;

    private String emptyQuizzesError = null;

    public DisplayQuizState(){

    }

    public String[][] getQuizzesTable() {
        return quizzesTable;
    }

    public DisplayQuizState(DisplayQuizState copy){
        this.quizzesTable = copy.quizzesTable;
        this.emptyQuizzesError = copy.emptyQuizzesError;
    }

    public void setEmptyQuizError(String emptyQuizzesError) {
        this.emptyQuizzesError = emptyQuizzesError;
    }
}
