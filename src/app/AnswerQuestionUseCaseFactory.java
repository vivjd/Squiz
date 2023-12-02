package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionPresenter;
import interface_adapter.question.QuestionViewModel;
import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInteractor;
import use_case.question.AnswerQuestionOutputBoundary;
import view.AnswerQuestionView;

public class AnswerQuestionUseCaseFactory {

    private AnswerQuestionUseCaseFactory() {}

    public static AnswerQuestionView create(
            ViewManagerModel viewManagerModel,
            QuestionViewModel questionViewModel) {
        AnswerQuestionController answerQuestionController = createAnswerQuestionController(viewManagerModel, questionViewModel);
        return new AnswerQuestionView(questionViewModel, answerQuestionController);
    }

    public static AnswerQuestionController createAnswerQuestionController(
            ViewManagerModel viewManagerModel,
            QuestionViewModel questionViewModel)
    {
        AnswerQuestionOutputBoundary answerQuestionOutputBoundary = new AnswerQuestionPresenter(questionViewModel, viewManagerModel);
        AnswerQuestionInputBoundary answerQuestionInputBoundary = new AnswerQuestionInteractor(answerQuestionOutputBoundary);

        return new AnswerQuestionController(answerQuestionInputBoundary);

    }

}
