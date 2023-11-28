package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionPresenter;
import interface_adapter.question.QuestionViewModel;
import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInteractor;
import use_case.question.AnswerQuestionOutputBoundary;
import use_case.question.QuestionDataAccessInterface;
import view.QuestionView;

public class AnswerQuestionUseCaseFactory {

    private AnswerQuestionUseCaseFactory() {}

    public static QuestionView create(
            ViewManagerModel viewManagerModel,
            QuestionViewModel questionViewModel,
            QuestionDataAccessInterface questionDataAccessInterface) {
        AnswerQuestionController answerQuestionController = createAnswerQuestionController(viewManagerModel, questionViewModel, questionDataAccessInterface);
        return new QuestionView(questionViewModel, answerQuestionController);
    }

    public static AnswerQuestionController createAnswerQuestionController(
            ViewManagerModel viewManagerModel,
            QuestionViewModel questionViewModel,
            QuestionDataAccessInterface questionDataAccessInterface)
    {
        AnswerQuestionOutputBoundary answerQuestionOutputBoundary = new AnswerQuestionPresenter(questionViewModel, viewManagerModel);
        AnswerQuestionInputBoundary answerQuestionInputBoundary = new AnswerQuestionInteractor(questionDataAccessInterface, answerQuestionOutputBoundary);

        return new AnswerQuestionController(answerQuestionInputBoundary);

    }

}
