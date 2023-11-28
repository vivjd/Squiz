package view;

import data_access.QuestionDataAccessObject;
import interface_adapter.question.AnswerQuestionController;
import interface_adapter.question.AnswerQuestionPresenter;
import interface_adapter.question.QuestionViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizController;
import interface_adapter.quiz.take_quiz.TakeQuizState;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import use_case.question.AnswerQuestionInputBoundary;
import use_case.question.AnswerQuestionInputData;
import use_case.question.AnswerQuestionInteractor;
import use_case.question.AnswerQuestionOutputBoundary;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TakeQuizView extends JPanel implements PropertyChangeListener {

    public final String viewName = "take_quiz";

    private final TakeQuizViewModel takeQuizViewModel;
    private final TakeQuizController takeQuizController;

    private QuestionView questionView;

    public TakeQuizView(TakeQuizViewModel takeQuizViewModel, TakeQuizController takeQuizController) {

        this.takeQuizViewModel = takeQuizViewModel;
        this.takeQuizController = takeQuizController;
//        QuestionViewModel questionViewModel = new QuestionViewModel();
//        AnswerQuestionOutputBoundary answerQuestionPresenter =  new AnswerQuestionPresenter(questionViewModel, );
//        AnswerQuestionInputBoundary answerQuestionInteractor = new AnswerQuestionInteractor(questionDataAccessObject, answerQuestionPresenter);
//        AnswerQuestionController answerQuestionController = new AnswerQuestionController(answerQuestionInteractor);
//        questionView = new QuestionView(questionViewModel, answerQuestionController);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        TakeQuizState state = (TakeQuizState) evt.getNewValue();
        System.out.println(state);
    }
}
