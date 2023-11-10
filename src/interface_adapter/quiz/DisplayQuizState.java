package interface_adapter.quiz;

public class DisplayQuizState {
    private String[][] quizzesTable;

    public DisplayQuizState(){

    }

    public String[][] getQuizzesTable() {
        return quizzesTable;
    }

    public DisplayQuizState(DisplayQuizState copy){
        this.quizzesTable = copy.quizzesTable;
    }
}
