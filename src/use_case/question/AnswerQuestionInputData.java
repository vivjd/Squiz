package use_case.question;

public class AnswerQuestionInputData implements AnswerQuestionInputBoundary{
    private final String userAnswer;

    public String getUserAnswer() {
        return userAnswer;
    }

    public AnswerQuestionInputData(String userAnswer){
        this.userAnswer = userAnswer;
    }


    @Override
    public void execute(AnswerQuestionInputData answerQuestionInputData) {

    }
}
