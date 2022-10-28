package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StartPanel extends JFrame {
    private JLabel title;
    private JButton newGame;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    public StartPanel() {
        super("Hyggeligt");
        initializeTitle();
        newGame = new JButton("New Game");
        newGameButton();
        add(title);
        add(newGame);
        setVisible(true);
        setLayout(new FlowLayout());
        setSize(HEIGHT, WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeTitle() {
        Font font = new Font("Segoe Script", Font.BOLD, 110);
        title = new JLabel("Hyggeligt");
        title.setFont(font);
    }

    private void newGameButton() {
        newGame.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartDialogue sd = new StartDialogue();
                dispose();
            }
        });
    }
}
