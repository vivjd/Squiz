package use_case.question;

import data_access.QuestionDataAccessObject;

public class AnswerQuestionInteractor implements AnswerQuestionInputBoundary{
    final QuestionDataAccessObject questionDataAccessObject;
    final AnswerQuestionOutputBoundary questionPresenter;

    public AnswerQuestionInteractor(QuestionDataAccessObject questionDataAccessObject, AnswerQuestionOutputBoundary questionPresenter) {
        this.questionDataAccessObject = questionDataAccessObject;
        this.questionPresenter = questionPresenter;
    }

    @Override
    public void execute(AnswerQuestionInputData answerQuestionInputData) {
        // TODO: Double check implementation. See notes below.
        // how do we get the question we have outputted to the user previously? how do we pass this in?
        // After discussion, it seems like that should be provided by the TakeQuiz use case, how do we pass it in?
        // code below assumes that we have already passed this in through some previous step
        // we will have access to the question name?
//        if (questionDataAccessObject.isInstanceOfMCQ("What is today's date?")){
//            String correct = ques
//            AnswerQuestionOutputData answerQuestionOutputData = new AnswerQuestionOutputData();
//            questionPresenter.prepareSuccessView();
//        }

        String userAnswer = answerQuestionInputData.getUserAnswer();
        String questionName = "What is today's date";
        String answerFeedback = questionDataAccessObject.answerFeedback(questionName, userAnswer);
        AnswerQuestionOutputData answerQuestionOutputData = new AnswerQuestionOutputData(answerFeedback);
        questionPresenter.prepareSuccessView(answerQuestionOutputData);

    }
}
