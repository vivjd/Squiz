package view;

import app.Main;
import interface_adapter.note.NoteViewModel;
import interface_adapter.quiz.display.DisplayQuizzesController;
import interface_adapter.quiz.display.DisplayQuizzesViewModel;
import interface_adapter.note.display.DisplayNotesController;
import interface_adapter.note.display.DisplayNotesViewModel;
import interface_adapter.note.save.SaveNoteController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class NoteViewTest {
    @Mock
    private SaveNoteController saveNoteController;

    @Mock
    private NoteViewModel noteViewModel;

    @Mock
    private DisplayQuizzesController displayQuizzesController;

    @Mock
    private DisplayQuizzesViewModel displayQuizzesViewModel;

    @Mock
    private DisplayNotesController displayNotesController;

    @Mock
    private DisplayNotesViewModel displayNotesViewModel;

    private NoteView noteView;

    static boolean popUpDiscovered = false;

    static String message = "";

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        noteView = new NoteView(
                saveNoteController,
                noteViewModel,
                displayQuizzesController,
                displayQuizzesViewModel,
                displayNotesController,
                displayNotesViewModel
        );
    }

    public JButton getButton() {
        JFrame app = null;
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app); // found the window?

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        NoteView sv = (NoteView) jp2.getComponent(0);

        JPanel buttons = (JPanel) sv.getComponent(4);

        return (JButton) buttons.getComponent(2); // this should be the clear button
    }

    @Test
    void saveButtonActionListener() {
        // Mocking the necessary components
        NoteView spyNoteView = spy(noteView);
        doNothing().when(spyNoteView).showSavedPopup();
        when(noteViewModel.getState()).thenReturn(mock(interface_adapter.note.NoteState.class));
        when(noteViewModel.getState().getTitle()).thenReturn("Test Title");
        when(noteViewModel.getState().getNote()).thenReturn("Test Note");
        when(noteViewModel.getState().getEmptyNoteError()).thenReturn(null);

        popUpDiscovered = false;

        Main.main(null);
        JFrame app = null;

        JButton button = getButton();


        // since clicking the button should end up displaying a JDialog to the user to report the
        // result, we set a timer, which will execute code necessary to complete the testing.
        createCloseTimer().start();

        //click the button
        button.doClick();

        // will continue execution here after the JDialog is closed

        // confirm a popUp was discovered
        assert (popUpDiscovered);

//        // Use SwingUtilities.invokeLater to execute the button click on the EDT
//        SwingUtilities.invokeLater(() -> spyNoteView.save.doClick());
//
//        // Pause the test to allow Swing to process the event on the EDT
//        try {
//            Thread.sleep(1000); // Adjust this delay if needed
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        // Verify that the saveNoteController.execute method is called
//        verify(saveNoteController).execute("Test Title", "Test Note");
//
//        // Verify that showSavedPopup is called
//        verify(spyNoteView).showSavedPopup();
    }

    @Test
    void generateQuizButtonActionListener() throws Exception {
        // Mocking the necessary components
        NoteView spyNoteView = spy(noteView);
        doNothing().when(spyNoteView).waitUntilGeneratedPopup();
        doNothing().when(spyNoteView).generateQuizController.execute(any(), any());
        when(noteViewModel.getState()).thenReturn(mock(interface_adapter.note.NoteState.class));
        when(noteViewModel.getState().getTitle()).thenReturn("Test Title");
        when(noteViewModel.getState().getNote()).thenReturn("Test Note");
        when(noteViewModel.getState().getEmptyNoteError()).thenReturn(null);

        // Simulate the generateQuiz button click
        spyNoteView.generateQuiz.doClick();

        // Verify that waitUntilGeneratedPopup is called
        verify(spyNoteView).waitUntilGeneratedPopup();

        // Verify that generateQuizController.execute is called
        verify(spyNoteView.generateQuizController).execute("Test Note", "Test Title");

        // Verify that quizGeneratedPopup is called
        verify(spyNoteView).quizGeneratedPopup();
    }

    private Timer createCloseTimer() {
        ActionListener close = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Window[] windows = Window.getWindows();
                for (Window window : windows) {

                    if (window instanceof JDialog) {

                        JDialog dialog = (JDialog) window;

                        // this ignores old dialogs
                        if (dialog.isVisible()) {
                            String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                                    .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();
                            System.out.println("message = " + s);

                            // store the information we got from the JDialog
                            NoteViewTest.message = s;
                            NoteViewTest.popUpDiscovered = true;

                            System.out.println("disposing of..." + window.getClass());
                            window.dispose();
                        }
                    }
                }
            }

        };

        Timer t = new Timer(1000, close);
        t.setRepeats(false);
        return t;
//    @BeforeEach
//    public void setUp(){
//
//    }
//
//    @Test
//    public void textInputJTextField(){
//        NoteView noteView;
//        JTextField inputText;
//        String expResult;
//
//        noteView = new NoteView();
//
//        inputTest = (JTextField)TestUtils.getChildNamed(frame, "input");
//    }
    }
}
