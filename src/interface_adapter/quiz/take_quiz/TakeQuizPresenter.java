package interface_adapter.quiz.take_quiz;

import entity.Question;
import entity.Quiz;
import interface_adapter.ViewManagerModel;
import interface_adapter.question.AnswerQuestionState;
import interface_adapter.question.QuestionViewModel;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;
import use_case.quiz.take_quiz.TakeQuizOutputData;

import java.util.List;

/**
 * Presenter class responsible for preparing and updating views related to quiz-taking.
 */
public class TakeQuizPresenter implements TakeQuizOutputBoundary {

    /**
     * The view model representing the state of the quiz-taking interface.
     */
    private final TakeQuizViewModel takeQuizViewModel;

    /**
     * The model managing the active views in the application.
     */
    private final ViewManagerModel viewManagerModel;

    /**
     * The view model representing the state of the question interface.
     */
    private final QuestionViewModel questionViewModel;

    /**
     * Constructs a new TakeQuizPresenter object with the specified dependencies.
     *
     * @param takeQuizViewModel The view model representing the state of the quiz-taking interface.
     * @param viewManagerModel  The model managing the active views in the application.
     * @param questionViewModel The view model representing the state of the question interface.
     */
    public TakeQuizPresenter(TakeQuizViewModel takeQuizViewModel, ViewManagerModel viewManagerModel, QuestionViewModel questionViewModel) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.viewManagerModel = viewManagerModel;
        this.questionViewModel = questionViewModel;
    }

    /**
     * Prepares the view for a successful execution of the quiz-taking process.
     *
     * @param takeQuizOutputData The output data from the quiz-taking process.
     */
    @Override
    public void prepareExecuteSuccessView(TakeQuizOutputData takeQuizOutputData) {
        List<Question<?>> questions = takeQuizViewModel.getState().getQuestions();
        int currentQuestionIndex = takeQuizViewModel.getState().getCurrentQuestionIndex();
        AnswerQuestionState questionState = new AnswerQuestionState();
        questionState.setQuestion(questions.get(currentQuestionIndex));
        questionViewModel.setState(questionState);
        questionViewModel.firePropertyChanged();
    }

    /**
     * Prepares the view for a successful start of the quiz-taking process.
     *
     * @param takeQuizOutputData The output data from the quiz-taking process.
     */
    @Override
    public void prepareStartSuccessView(TakeQuizOutputData takeQuizOutputData) {
        Quiz quiz = takeQuizOutputData.getQuiz();
        List<Question<?>> questions = quiz.getQuestions();
        TakeQuizState takeQuizState = takeQuizViewModel.getState();
        takeQuizState.setQuestions(questions);
        takeQuizViewModel.setState(takeQuizState);
        takeQuizViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(takeQuizViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    /**
     * Prepares the view for the next question in the quiz or the final score view.
     *
     * @param takeQuizOutputData The output data from the quiz-taking process.
     */
    @Override
    public void prepareNextSuccessView(TakeQuizOutputData takeQuizOutputData) {
        List<Question<?>> questions = takeQuizViewModel.getState().getQuestions();
        int currentQuestionIndex = takeQuizViewModel.getState().getCurrentQuestionIndex();
        if (currentQuestionIndex < questions.size()) {
            AnswerQuestionState questionState = new AnswerQuestionState();
            questionState.setQuestion(questions.get(currentQuestionIndex));
            questionViewModel.setState(questionState);
            questionViewModel.firePropertyChanged();
        } else {
            int score = takeQuizViewModel.getState().getScore();
            viewManagerModel.setActiveView("quiz");
            viewManagerModel.firePropertyChanged();
        }
    }

    /**
     * Prepares the view for a failed execution of the quiz-taking process.
     *
     * @param error The error message describing the cause of the failure.
     */
    @Override
    public void prepareFailView(String error) {
        // Implementation can be added based on the requirements.
    }
}
