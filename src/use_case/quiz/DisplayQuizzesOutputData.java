package use_case.quiz;

public class DisplayQuizzesOutputData {
    private final String[][] quizzes;
//    private List<String> quizTitles;

    private boolean useCaseFailed;

    public DisplayQuizzesOutputData(String[][] quizzes) {this.quizzes = quizzes;}

//    public List<String> getQuizTitles(){
//        return this.quizTitles;
//    }

    public String[][] getQuizzes() {
        return quizzes;
    }

}
