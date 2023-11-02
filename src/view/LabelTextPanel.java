package view;

import javax.swing.*;

public class LabelTextPanel extends JPanel{
    LabelTextPanel(JLabel label, JTextArea text) {
        this.add(label);
        this.add(text);
    }

    LabelTextPanel(JLabel label, JTextField text) {
        this.add(label);
        this.add(text);
    }
}
