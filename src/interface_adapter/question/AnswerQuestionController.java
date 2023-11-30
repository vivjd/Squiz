package interface_adapter.question;

import entity.Question;
import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInputData;

public class AnswerQuestionController {
    final AnswerQuestionInputBoundary answerQuestionInteractor;

    public AnswerQuestionController(AnswerQuestionInputBoundary answerQuestionInteractor) {
        this.answerQuestionInteractor = answerQuestionInteractor;
    }

    public void execute(String answer, Question<?> question){
        AnswerQuestionInputData answerQuestionInputData = new AnswerQuestionInputData(answer, question);
        answerQuestionInteractor.execute(answerQuestionInputData);
    }
}
