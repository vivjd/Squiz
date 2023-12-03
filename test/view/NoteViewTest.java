package view;

import app.Main;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

public class NoteViewTest {
    private static boolean popUpDiscovered = false;
    private static String message = "";

    public JButton getButton(int num) {
        JFrame app = null;
        Window[] windows = Window.getWindows();

        for (Window window : windows) {
            if (window instanceof JFrame) {
                app = (JFrame) window;
            }
        }

        assertNotNull(app);

        Component root = app.getComponent(0);

        Component cp = ((JRootPane) root).getContentPane();

        JPanel jp = (JPanel) cp;

        JPanel jp2 = (JPanel) jp.getComponent(0);

        NoteView sv = (NoteView) jp2.getComponent(0);

        Box buttons = (Box) sv.getComponent(1);

        JButton button = (JButton) buttons.getComponent(num);

        System.out.println(button.getText());

        return button;
    }

    @Test
    public void saveButtonPresent() {
        Main.main(null);
        JButton button = getButton(0);
        assert(button.getText().equals("Save Note"));
    }

    @Test
    public void saveButtonEmpty() {
        Main.main(null);
        JButton button = getButton(0);
        createCloseTimer().start();

        button.doClick();
        assert(popUpDiscovered);
        assert(message.equals("Please enter a title for your note."));
    }

    @Test
    public void quizzesButtonPresent() {
        Main.main(null);
        JButton button = getButton(2);
        assert(button.getText().equals("View All Quizzes"));
    }

    @Test
    public void notesButtonPresent() {
        Main.main(null);
        JButton button = getButton(4);
        assert(button.getText().equals("View All Notes"));
    }

    @Test
    public void quizButtonPresent() {
        Main.main(null);
        JButton button = getButton(6);
        assert(button.getText().equals("Generate Quiz"));
    }

    private Timer createCloseTimer() {
        ActionListener close = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Window[] windows = Window.getWindows();
                for (Window window : windows) {

                    if (window instanceof JDialog) {

                        JDialog dialog = (JDialog)window;

                        if (dialog.isVisible()) {
                            String s = ((JOptionPane) ((BorderLayout) dialog.getRootPane()
                                    .getContentPane().getLayout()).getLayoutComponent(BorderLayout.CENTER)).getMessage().toString();

                            NoteViewTest.message = s;
                            NoteViewTest.popUpDiscovered = true;

                            window.dispose();
                        }
                    }
                }
            }
        };
        Timer t = new Timer(1000, close);
        t.setRepeats(false);
        return t;
    }


}
