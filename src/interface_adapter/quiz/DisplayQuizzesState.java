package interface_adapter.quiz;

public class DisplayQuizzesState {
    private String[][] quizzesTable;

    private String emptyQuizzesError = null;

    public DisplayQuizzesState(){

    }

    public String[][] getQuizzesTable() {
        return quizzesTable;
    }

    public DisplayQuizzesState(DisplayQuizzesState copy){
        this.quizzesTable = copy.quizzesTable;
        this.emptyQuizzesError = copy.emptyQuizzesError;
    }

    public void setEmptyQuizError(String emptyQuizzesError) {
        this.emptyQuizzesError = emptyQuizzesError;
    }
}
