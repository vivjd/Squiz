package app;

import data_access.NoteDataAccessObject;
//import data_access.QuestionDataAccessObject;
import data_access.QuizDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteViewModel;
import interface_adapter.quiz.GenerateQuizController;
import interface_adapter.quiz.GenerateQuizPresenter;
import use_case.note.NoteDataAccessInterface;
import use_case.quiz.GenerateQuizInteractor;
import use_case.quiz.GenerateQuizOutputBoundary;


import interface_adapter.note.display_notes.DisplayNotesViewModel;
import interface_adapter.question.QuestionViewModel;
//import interface_adapter.quiz.delete.DeleteQuizViewModel;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import view.*;


import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        buildInitialPage();
    }

    public static void buildInitialPage() {
        JFrame application = new JFrame("Squiz");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        NoteDataAccessObject noteDataAccessObject = new NoteDataAccessObject();
        QuizDataAccessObject quizDataAccessObject = new QuizDataAccessObject();
//        QuestionDataAccessObject questionDataAccessObject = new QuestionDataAccessObject();

        NoteViewModel noteViewModel = new NoteViewModel();
        DisplayQuizzesViewModel displayQuizzesViewModel = new DisplayQuizzesViewModel();
        DisplayNotesViewModel displayNotesViewModel = new DisplayNotesViewModel();
//        DeleteQuizViewModel deleteQuizViewModel = new DeleteQuizViewModel();

        TakeQuizViewModel takeQuizViewModel = new TakeQuizViewModel();
        QuestionViewModel questionViewModel = new QuestionViewModel();


        NoteView noteView = NoteUseCaseFactory.create(viewManagerModel, noteViewModel, noteDataAccessObject,
                displayQuizzesViewModel, quizDataAccessObject, displayNotesViewModel);
        views.add(noteView, noteView.viewName);

        DisplayNotesView displayNotesView = DisplayNotesUseCaseFactory.create(viewManagerModel, displayNotesViewModel, noteDataAccessObject, noteViewModel);
        views.add(displayNotesView, displayNotesView.viewName);

        DisplayQuizzesView displayQuizzesView = DisplayQuizzesUseCaseFactory.create(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject, takeQuizViewModel, questionViewModel, noteViewModel);
        views.add(displayQuizzesView, displayQuizzesView.viewName);

        AnswerQuestionView answerQuestionView = AnswerQuestionUseCaseFactory.create(viewManagerModel, questionViewModel);
        views.add(displayQuizzesView, displayQuizzesView.viewName);

        TakeQuizView takeQuizView = TakeQuizUseCaseFactory.create(viewManagerModel, takeQuizViewModel, quizDataAccessObject, answerQuestionView, questionViewModel);
        views.add(takeQuizView, takeQuizView.viewName);

        answerQuestionView.setAnswerQuestionListener(takeQuizView);


        viewManagerModel.setActiveView(noteView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}