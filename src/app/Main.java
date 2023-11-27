package app;

import data_access.NoteDataAccessObject;
import data_access.QuizDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteViewModel;

import interface_adapter.note.display_notes.DisplayNotesViewModel;
import interface_adapter.quiz.DisplayQuizzesViewModel;
import view.DisplayNotesView;
import view.DisplayQuizzesView;

import view.NoteView;
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

        NoteDataAccessObject noteDataAccessObject = new NoteDataAccessObject();
        QuizDataAccessObject quizDataAccessObject = new QuizDataAccessObject();

        NoteViewModel noteViewModel = new NoteViewModel();
        DisplayQuizzesViewModel displayQuizzesViewModel = new DisplayQuizzesViewModel();
        DisplayNotesViewModel displayNotesViewModel = new DisplayNotesViewModel();

        NoteView noteView = NoteUseCaseFactory.create(viewManagerModel, noteViewModel, noteDataAccessObject,
                displayQuizzesViewModel, quizDataAccessObject, displayNotesViewModel);
        views.add(noteView, noteView.viewName);

        DisplayQuizzesView displayQuizzesView = DisplayQuizzesUseCaseFactory.create(viewManagerModel, displayQuizzesViewModel, quizDataAccessObject);
        views.add(displayQuizzesView, displayQuizzesView.viewName);

        DisplayNotesView displayNotesView = DisplayNotesUseCaseFactory.create(viewManagerModel, displayNotesViewModel, noteDataAccessObject);
        views.add(displayNotesView, displayNotesView.viewName);

        viewManagerModel.setActiveView(noteView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);

    }
}