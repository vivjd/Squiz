package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.question.QuestionViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizPresenter;
import view.AnswerQuestionView;
import view.TakeQuizView;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import use_case.quiz.QuizDataAccessInterface;
import use_case.quiz.take_quiz.TakeQuizInputBoundary;
import use_case.quiz.take_quiz.TakeQuizInteractor;
import use_case.quiz.take_quiz.TakeQuizOutputBoundary;

public class TakeQuizUseCaseFactory {

    private TakeQuizUseCaseFactory() {}

    public static TakeQuizView create(
            ViewManagerModel viewManagerModel,
            TakeQuizViewModel takeQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            AnswerQuestionView answerQuestionView,
            QuestionViewModel questionViewModel
    ) {
        TakeQuizController takeQuizController = createTakeQuizController(viewManagerModel, takeQuizViewModel, quizDataAccessObject, questionViewModel);
        return new TakeQuizView(takeQuizViewModel, takeQuizController, answerQuestionView);
    }

    public static TakeQuizController createTakeQuizController(
            ViewManagerModel viewManagerModel,
            TakeQuizViewModel takeQuizViewModel,
            QuizDataAccessInterface quizDataAccessObject,
            QuestionViewModel questionViewModel
    ) {
        TakeQuizOutputBoundary takeQuizOutputBoundary = new TakeQuizPresenter(takeQuizViewModel, viewManagerModel, questionViewModel);
        TakeQuizInputBoundary takeQuizInputBoundary = new TakeQuizInteractor(quizDataAccessObject, takeQuizOutputBoundary);

        return new TakeQuizController(takeQuizInputBoundary);
    }
}
