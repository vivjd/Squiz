package app;

import data_access.NoteDataAccessObject;
import data_access.QuizDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteViewModel;

import interface_adapter.quiz.DisplayQuizzesController;
import interface_adapter.quiz.DisplayQuizzesViewModel;
import view.DisplayQuizzesView;

import use_case.note.NoteDataAccessInterface;
import view.NoteView;
import view.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // showQuizzesPage();
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

        NoteView noteView = NoteUseCaseFactory.create(viewManagerModel, noteViewModel, noteDataAccessObject,
                displayQuizzesViewModel, quizDataAccessObject);
        views.add(noteView, noteView.viewName);

        viewManagerModel.setActiveView(noteView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }

    // TODO: Delete after UseCase is Done
    public static void showQuizzesPage() {
        JFrame application = new JFrame("test");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);
        DisplayQuizzesView quizzesView = new DisplayQuizzesView(new DisplayQuizzesViewModel(), new DisplayQuizzesController());

        views.add(quizzesView, quizzesView.viewName);
        viewManagerModel.setActiveView(quizzesView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}