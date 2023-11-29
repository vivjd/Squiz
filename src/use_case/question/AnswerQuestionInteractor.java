package use_case.question;

import data_access.QuestionDataAccessObject;
import entity.MultipleChoiceQuestion;
import entity.Question;

import java.util.Map;

public class AnswerQuestionInteractor implements AnswerQuestionInputBoundary{
    final QuestionDataAccessInterface questionDataAccessObject;
    final AnswerQuestionOutputBoundary questionPresenter;

    public AnswerQuestionInteractor(QuestionDataAccessInterface questionDataAccessObject, AnswerQuestionOutputBoundary questionPresenter) {
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

        String userAnswer = answerQuestionInputData.getUserAnswer();
        Question<?> questionName = answerQuestionInputData.getQuestion();
        String answerFeedback = answerFeedback(questionName, userAnswer);
        AnswerQuestionOutputData answerQuestionOutputData = new AnswerQuestionOutputData(answerFeedback);
        questionPresenter.prepareSuccessView(answerQuestionOutputData);

    }

    public String answerFeedback(Question<?> question, String userAnswer){
        if (isInstanceOfMCQ(question)){
            // there's an issue with the way i'm finding out whether a question is a MCQ or Open ended, will look into it
            MultipleChoiceQuestion q = (MultipleChoiceQuestion) question;
            String correctAnswer = getMCQCorrectAnswer(q);
            if (correctAnswer.equals(userAnswer)){
                System.out.println("Yes");
                return "Your answer is correct!";
            } else{
                System.out.println("No");
                return "Your answer is incorrect. The correct answer is " + correctAnswer + ".";
            }
        } else {
            //assume that if question is not a MCQ then it must be a OpenEndedQuestion
            // we need to do some Hugginface API calling here to get feedback
            // code below assumes we've got gained feedback already
            String feedback = "Some feedback from hugginface"; //change this
            return feedback;
        }
    }

    public boolean isInstanceOfMCQ(Question question){
        // TODO: Implementation below assumes that each Question stores as
        return question instanceof MultipleChoiceQuestion;
    }
    public String getMCQCorrectAnswer(MultipleChoiceQuestion q){
        Map<String, String> answerOptions = q.getAnswerOptions();

        return answerOptions.get(q.getCorrectAnswerIndex());
    }
}
