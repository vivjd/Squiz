package use_case.question;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;

/**
 * The {@code AnswerQuestionInteractor} class is responsible for executing the logic of
 * answering a question based on the provided input data. It interacts with the specified
 * data access object and presents the answer feedback through the
 * {@link AnswerQuestionOutputBoundary} output boundary.
 *
 * <p>This class implements the {@link AnswerQuestionInputBoundary} interface.</p>
 */
public class AnswerQuestionInteractor implements AnswerQuestionInputBoundary{
    /**
     * Data access object for retrieving question data.
     */
    final QuestionDataAccessInterface questionDataAccessObject;

    /**
     * Presenter for displaying the answer feedback.
     */
    final AnswerQuestionOutputBoundary questionPresenter;

    /**
     * Constructs a new {@code AnswerQuestionInteractor} with the specified dependencies.
     *
     * @param questionPresenter        Presenter for displaying the answer feedback.
     */
    public AnswerQuestionInteractor(QuestionDataAccessInterface questionDataAccessObject, AnswerQuestionOutputBoundary questionPresenter) {
        this.questionDataAccessObject = questionDataAccessObject;
        this.questionPresenter = questionPresenter;
    }

    /**
     * Executes the process of answering a question based on the provided input data.
     *
     * @param answerQuestionInputData Input data containing user input to the question as well as info regarding the question itself.
     */
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
            MultipleChoiceQuestion q = (MultipleChoiceQuestion) question;
            String correctAnswer = getMCQCorrectAnswer(q);
            return correctAnswer;
        } else {

            OpenEndedQuestion q = (OpenEndedQuestion) question;
            String feedback = q.getCorrectAnswer();
            return feedback;
        }
    }

    public boolean isInstanceOfMCQ(Question question){
        // TODO: Implementation below assumes that each Question stores as
        return question instanceof MultipleChoiceQuestion;
    }
    public String getMCQCorrectAnswer(MultipleChoiceQuestion q){

        return q.getCorrectAnswerIndex();
    }
}
