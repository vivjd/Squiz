package interface_adapter.quiz.take_quiz;

import entity.Question;
import entity.Quiz;
import interface_adapter.ViewManagerModel;
import interface_adapter.question.AnswerQuestionState;
import interface_adapter.question.QuestionViewModel;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;
import use_case.quiz.take_quiz.TakeQuizOutputData;

import java.util.List;

public class TakeQuizPresenter implements TakeQuizOutputBoundary {

    private final TakeQuizViewModel takeQuizViewModel;
    private final ViewManagerModel viewManagerModel;
    private final QuestionViewModel questionViewModel;

    public TakeQuizPresenter(TakeQuizViewModel takeQuizViewModel, ViewManagerModel viewManagerModel, QuestionViewModel questionViewModel) {
        this.takeQuizViewModel = takeQuizViewModel;
        this.viewManagerModel = viewManagerModel;
        this.questionViewModel = questionViewModel;
    }

    @Override
    public void prepareExecuteSuccessView(TakeQuizOutputData takeQuizOutputData) {
        List<Question<?>> questions = takeQuizViewModel.getState().getQuestions();
        int currentQuestionIndex = takeQuizViewModel.getState().getCurrentQuestionIndex();
        AnswerQuestionState questionState = new AnswerQuestionState();
        questionState.setQuestion(questions.get(currentQuestionIndex));
        questionViewModel.setState(questionState);
        questionViewModel.firePropertyChanged();
    }

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

    @Override
    public void prepareFailView(String error) {

    }
}
