package app;

import data_access.NoteDataAccessObject;
import data_access.QuizDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteViewModel;


import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import view.DisplayQuizzesView;

import view.NoteView;
import view.TakeQuizView;
import view.ViewManager;

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

        //unsure if this is the right DataAccessObject...
        NoteDataAccessObject noteDataAccessObject = new NoteDataAccessObject();
        QuizDataAccessObject quizDataAccessObject = new QuizDataAccessObject();

        NoteViewModel noteViewModel = new NoteViewModel();
        DisplayQuizzesViewModel displayQuizzesViewModel = new DisplayQuizzesViewModel();
        TakeQuizViewModel takeQuizViewModel = new TakeQuizViewModel();

        NoteView noteView = NoteUseCaseFactory.create(viewManagerModel, noteViewModel, noteDataAccessObject,
                displayQuizzesViewModel, quizDataAccessObject);
        views.add(noteView, noteView.viewName);

        DisplayQuizzesView displayQuizzesView = DisplayQuizzesUseCaseFactory.create(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject, takeQuizViewModel);
        views.add(displayQuizzesView, displayQuizzesView.viewName);

        TakeQuizView takeQuizView = TakeQuizUseCaseFactory.create(viewManagerModel, takeQuizViewModel, quizDataAccessObject);
        views.add(takeQuizView, takeQuizView.viewName);

        viewManagerModel.setActiveView(noteView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}