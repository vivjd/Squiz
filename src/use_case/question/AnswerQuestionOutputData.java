package use_case.question;

public class AnswerQuestionOutputData{
    private String answerFeedback;

    private boolean useCaseFailed;

    public AnswerQuestionOutputData(String answerFeedback){
        this.answerFeedback = answerFeedback;
    }

    public String getAnswerFeedback() {
        return answerFeedback;
    }

}
