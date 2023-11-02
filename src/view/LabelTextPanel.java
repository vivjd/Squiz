package view;

import javax.swing.*;

public class LabelTextPanel extends JPanel{
    LabelTextPanel(JLabel label, JTextField text) {
        this.add(label);
        this.add(text);
    }
}
