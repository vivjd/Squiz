package interface_adapter.quiz.display_quizzes;

public class DisplayQuizzesState {
    private String[][] quizzesTable;

    private String emptyQuizzesError = null;

    public DisplayQuizzesState(){

    }

//    public DisplayQuizzesState(DisplayQuizzesState copy){
//        this.quizzesTable = copy.quizzesTable;
//        this.emptyQuizzesError = copy.emptyQuizzesError;
//    }

    public void setQuizzesTable(String[][] quizzesTable){
        this.quizzesTable = quizzesTable;
    }

    public String[][] getQuizzesTable() {
        return quizzesTable;
    }

    public void setEmptyQuizError(String emptyQuizzesError) {
        this.emptyQuizzesError = emptyQuizzesError;
    }

    public String getEmptyQuizzesError(){return emptyQuizzesError;}
}
