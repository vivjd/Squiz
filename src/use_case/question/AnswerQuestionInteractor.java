package use_case.question;

import entity.MultipleChoiceQuestion;
import entity.OpenEndedQuestion;
import entity.Question;

import java.util.Map;

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
//    final QuestionDataAccessInterface questionDataAccessObject;

    /**
     * Presenter for displaying the answer feedback.
     */
    final AnswerQuestionOutputBoundary questionPresenter;

    /**
     * Constructs a new {@code AnswerQuestionInteractor} with the specified dependencies.
     *
     * @param questionPresenter        Presenter for displaying the answer feedback.
     */
    public AnswerQuestionInteractor(AnswerQuestionOutputBoundary questionPresenter) {
        this.questionPresenter = questionPresenter;
    }

    /**
     * Executes the process of answering a question based on the provided input data.
     *
     * @param answerQuestionInputData Input data containing user input to the question as well as info regarding the question itself.
     */
    @Override
    public void execute(AnswerQuestionInputData answerQuestionInputData) {
        String userAnswer = answerQuestionInputData.getUserAnswer();
        Question<?> questionName = answerQuestionInputData.getQuestion();
        String answerFeedback = answerFeedback(questionName, userAnswer);
        AnswerQuestionOutputData answerQuestionOutputData = new AnswerQuestionOutputData(answerFeedback);
        questionPresenter.prepareSuccessView(answerQuestionOutputData);

    }

    private String answerFeedback(Question<?> question, String userAnswer){
        if (isInstanceOfMCQ(question)){
            MultipleChoiceQuestion q = (MultipleChoiceQuestion) question;
            String correctAnswer = getMCQCorrectAnswer(q);
            //TODO: test after QuizGenerator is integrated.
            if (correctAnswer.equals(userAnswer)){
                return "Your answer is correct!";
            } else{
                return "Your answer is incorrect. The correct answer is " + correctAnswer + ".";
            }
        } else {
            OpenEndedQuestion q = (OpenEndedQuestion) question;
            return "AI Feedback: " + q.getCorrectAnswer();
        }
    }

    private boolean isInstanceOfMCQ(Question question){
        return question instanceof MultipleChoiceQuestion;
    }

    private String getMCQCorrectAnswer(MultipleChoiceQuestion q){
        Map<String, String> answerOptions = q.getAnswerOptions();

        return answerOptions.get(q.getCorrectAnswerIndex());
    }
}
