package use_case.quiz;

import interface_adapter.quiz.DisplayQuizController;

import java.util.List;

public class DisplayQuizOutputData {
    private final String[][] quizzes;
//    private List<String> quizTitles;

    private boolean useCaseFailed;

    public DisplayQuizOutputData(String[][] quizzes) {this.quizzes = quizzes;}

//    public List<String> getQuizTitles(){
//        return this.quizTitles;
//    }

}
