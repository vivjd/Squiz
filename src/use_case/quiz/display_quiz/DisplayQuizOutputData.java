package use_case.quiz.display_quiz;

public class DisplayQuizOutputData {
    private final String[][] quizzes;
//    private List<String> quizTitles;

    private boolean useCaseFailed;

    public DisplayQuizOutputData(String[][] quizzes) {this.quizzes = quizzes;}

//    public List<String> getQuizTitles(){
//        return this.quizTitles;
//    }

}
