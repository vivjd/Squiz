package interface_adapter.question;

import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInputData;

public class AnswerQuestionController {
    final AnswerQuestionInputBoundary answerQuestionInteractor;

    public AnswerQuestionController(AnswerQuestionInputBoundary answerQuestionInteractor) {
        this.answerQuestionInteractor = answerQuestionInteractor;
    }

    public void execute(String answer){
        AnswerQuestionInputData answerQuestionInputData = new AnswerQuestionInputData(answer);
        answerQuestionInteractor.execute(answerQuestionInputData);
    }
}
