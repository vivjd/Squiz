package interface_adapter.question;

import entity.Question;
import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInputData;

/**
 * The {@code AnswerQuestionController} class serves as an adapter between the user interface layer
 * and the use case layer, specifically for handling user input related to answering questions.
 * It delegates the user's answer and the associated question to the provided {@link AnswerQuestionInputBoundary}
 * for further processing.
 */
public class AnswerQuestionController {
    final AnswerQuestionInputBoundary answerQuestionInteractor;

    /**
     * Constructs an {@code AnswerQuestionController} with the specified {@link AnswerQuestionInputBoundary}.
     *
     * @param answerQuestionInteractor The use case component for handling the execution of answering questions.
     */
    public AnswerQuestionController(AnswerQuestionInputBoundary answerQuestionInteractor) {
        this.answerQuestionInteractor = answerQuestionInteractor;
    }

    /**
     * Executes the process of answering a question based on the provided answer and question.
     *
     * @param answer   The user's answer to the question.
     * @param question The question the user has answered.
     */
    public void execute(String answer, Question<?> question){
        AnswerQuestionInputData answerQuestionInputData = new AnswerQuestionInputData(answer, question);
        answerQuestionInteractor.execute(answerQuestionInputData);
    }
}
