package interface_adapter.question;

import entity.Question;
import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInputData;

/**
 * Controller class responsible for handling user interactions related to answering a question.
 */
public class AnswerQuestionController {

    /**
     * The interactor responsible for processing question-answering operations.
     */
    final AnswerQuestionInputBoundary answerQuestionInteractor;

    /**
     * Constructs a new AnswerQuestionController object with the specified interactor.
     *
     * @param answerQuestionInteractor The interactor responsible for processing question-answering operations.
     */
    public AnswerQuestionController(AnswerQuestionInputBoundary answerQuestionInteractor) {
        this.answerQuestionInteractor = answerQuestionInteractor;
    }

    /**
     * Executes the question-answering process with the specified answer and question.
     *
     * @param answer   The user's answer to the question.
     * @param question The question being answered.
     */
    public void execute(String answer, Question<?> question) {
        AnswerQuestionInputData answerQuestionInputData = new AnswerQuestionInputData(answer, question);
        answerQuestionInteractor.execute(answerQuestionInputData);
    }
}
