package ui;

import model.hgValue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StartDialogue extends JFrame {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 150;
    private JTextArea dialogue;
    private JButton startButton;

    public StartDialogue() {
        super("Hyggeligt");
        dialogue = new JTextArea("Det er koldt udenfor...", 1, 30);
        dialogueArea();
        add(dialogue);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(HEIGHT, WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        startButton = new JButton("Hvorfor ikke lave nogle hyggelige ting!");
        setStartButton();
        add(startButton);
    }

    private void dialogueArea() {
        dialogue.setEditable(false);
        Font font = new Font("Segoe Script", Font.BOLD, 16);
        dialogue.setFont(font);
    }

    private void setStartButton() {
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Integer> value = new ArrayList<>();
                new GamePanel(value);
                dispose();
            }
        });
    }
}
