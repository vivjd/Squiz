package use_case.question;

public interface AnswerQuestionOutputBoundary {
    void prepareSuccessView(AnswerQuestionOutputData feedback);

    void prepareFailView(String error);

}
