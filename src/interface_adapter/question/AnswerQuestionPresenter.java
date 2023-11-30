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


    }



    @Override
    public void prepareFailView(String error) {

    }
}
