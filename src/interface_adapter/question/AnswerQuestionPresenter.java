package interface_adapter.question;

import interface_adapter.ViewManagerModel;
import use_case.question.AnswerQuestionOutputBoundary;
import use_case.question.AnswerQuestionOutputData;

public class AnswerQuestionPresenter implements AnswerQuestionOutputBoundary {
    private QuestionViewModel questionViewModel;

    private ViewManagerModel viewManagerModel;

    public AnswerQuestionPresenter(QuestionViewModel questionViewModel, ViewManagerModel viewManagerModel) {
        this.questionViewModel = questionViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(AnswerQuestionOutputData userFeedback) {
        AnswerQuestionState questionState = questionViewModel.getState();
        questionState.setFeedback(userFeedback.getAnswerFeedback());
//        questionState.setQuestionName();
        // TODO: This is not yet complete. Do we need to set the QuestionName again? And do we need to set the user's input?
    }

    @Override
    public void prepareFailView(String error) {

    }
}
