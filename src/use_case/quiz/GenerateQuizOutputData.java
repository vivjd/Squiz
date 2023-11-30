package use_case.quiz;

public class GenerateQuizOutputData {
    String msg;
    public GenerateQuizOutputData(String Title) {
        this.msg = "Quiz is generated. Title: " + Title + " (QUIZ)";
    }
}
