package ui;

import javax.swing.*;

public class ValuePanel extends JPanel {
    private JTextArea score;
    public ValuePanel(int value) {
        initializeScore(value);

    }

    public void initializeScore(int value) {
        if (value == 0) {
            score = new JTextArea("0/4", 1, 30);
        } else if (value == 1) {
            score = new JTextArea("1/4", 1, 30);
        } else if (value == 2) {
            score = new JTextArea("2/4", 1, 30);
        } else {
            score = new JTextArea("3/4", 1, 30);
        }
    }
}
