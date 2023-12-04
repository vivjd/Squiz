package factories;

import app.*;
import interface_adapter.ViewManagerModel;
import interface_adapter.note.NoteViewModel;
import interface_adapter.note.display.DisplayNotesViewModel;
import interface_adapter.question.QuestionViewModel;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.quiz.take_quiz.TakeQuizViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.note.NoteDataAccessInterface;
import use_case.question.QuestionDataAccessInterface;
import use_case.quiz.QuizDataAccessInterface;
import view.*;

import static org.mockito.Mockito.*;

public class UseCaseFactoryTest {
    private ViewManagerModel viewManagerModel;
    private QuestionViewModel questionViewModel;
    private QuestionDataAccessInterface questionDAO;
    private DisplayNotesViewModel displayNotesViewModel;
    private NoteDataAccessInterface dataAccessObject;
    private NoteViewModel noteViewModel;
    private DisplayQuizzesViewModel displayQuizzesViewModel;
    private QuizDataAccessInterface quizDAO;
    private TakeQuizViewModel takeQuizViewModel;
    private NoteDataAccessInterface noteDAO;

    @BeforeEach
    public void create_initial() {
        this.viewManagerModel = mock(ViewManagerModel.class);
        this.questionDAO = mock(QuestionDataAccessInterface.class);
        this.questionViewModel = new QuestionViewModel();
        this.displayNotesViewModel = new DisplayNotesViewModel();
        this.dataAccessObject = mock(NoteDataAccessInterface.class);
        this.noteViewModel = new NoteViewModel();
        this.displayQuizzesViewModel = new DisplayQuizzesViewModel();
        this.takeQuizViewModel = new TakeQuizViewModel();
        this.noteDAO = mock(NoteDataAccessInterface.class);
    }

    @Test
    public void display_notes_view() {
        DisplayNotesView view = DisplayNotesUseCaseFactory.create(viewManagerModel, displayNotesViewModel, dataAccessObject, noteViewModel);
        assert(view.viewName == "display_notes");
    }

    @Test
    public void display_quizzes_view() {
        DisplayQuizzesView view = DisplayQuizzesUseCaseFactory.create(viewManagerModel,
                displayQuizzesViewModel, quizDAO, takeQuizViewModel, questionViewModel, noteViewModel);
        assert (view.viewName == "quiz");
    }

    @Test
    public void note_view() {
        NoteView view = NoteUseCaseFactory.create(viewManagerModel, noteViewModel, noteDAO,
                displayQuizzesViewModel, quizDAO, displayNotesViewModel);
        assert (view.viewName == "note");
    }

    @Test
    public void take_quiz_view() {
        AnswerQuestionView answerQuestionView = answer_question_view();
        TakeQuizView view = TakeQuizUseCaseFactory.create(viewManagerModel, takeQuizViewModel, quizDAO,
                answerQuestionView, questionViewModel);
        assert (view.viewName == "take_quiz");
    }

    private AnswerQuestionView answer_question_view() {
        AnswerQuestionView view = AnswerQuestionUseCaseFactory.create(viewManagerModel,
                questionViewModel, questionDAO);
        return view;
    }
}
