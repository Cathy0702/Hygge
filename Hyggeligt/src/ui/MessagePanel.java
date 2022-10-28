package ui;

import model.hgValue;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class MessagePanel extends JFrame {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 500;
    private JTextPane title;
    private JTextArea message;
    private JButton go;

    public MessagePanel(ArrayList<Integer> hgChoice) {
        setTitle();
        add(title);

        initializeMessage(hgChoice.get(hgChoice.size() - 1));
        add(message);

        go = new JButton("Continue!");
        setGo(hgChoice);
        add(go);

        setVisible(true);
        setLayout(new FlowLayout());
        setSize(HEIGHT, WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void initializeMessage(int value) {
        if (value == 0) {
            message = new JTextArea(
                    "You want to close the curtains.\n" +
                            "The warmth is probably one of the most important features of hygge. \n" +
                            "Close the windows and draw the curtains, it is like entering a small, isolated world. \n" +
                            "It may be pouring rain or snow outside, but as long as the curtains are closed, \n" +
                            "it will provide you with a strong sense of security and satisfaction.\n", 25,
                    50
            );
        } else if (value == 1) {
            message = new JTextArea(
                    "You want to light the candle.\n" +
                            "A bright overhead light always keeps you too awake, as if you are always working, \n" +
                            "which is not leisurely or \"hyggeligt\" enough. \n" +
                            "Turn off the lights, light the candles and the small bulbs, \n" +
                            "the faint glow is just enough to illuminate the text in the near distance, \n" +
                            "while everything else is shrouded in shadow. \n" +
                            "You feel calm, warm, and all the things that bothered you have disappeared \n" +
                            "for a while.\n", 25,
                    50
            );
        } else if (value == 2) {
            message = new JTextArea(
                    "You want to make yourself a cup of coffee.\n" +
                            "Sweetness and warmth are always the representatives of \"hygge\". \n" +
                            "Coffee, tea and hot cocoa can make you relax quickly and feel warm inside. \n" +
                            "If you can, grab yourself a piece of cake, or pudding, \n" +
                            "and you are allowed to take a break from your daily healthy eating habits for a while. \n" +
                            "The large amount of sugar in desserts stimulates dopamine secretion,\n " +
                            "making you feel happy and relaxed.\n" +
                            "You also want to grab a book for yourself.\n" +
                            "Books always seem to be for studying, and studying always involves grades and competition. \n" +
                            "But for this moment, you're reading just for the story you love, just for yourself. \n" +
                            "Choose an attractive story and laugh and cry along with the characters in the book. \n" +
                            "In this warm cottage enveloped by the aroma of coffee and desserts, \n" +
                            "you seem to experience a different life.\n",
                    25,
                    50
            );
        }
        message.setEditable(false);
        message.setFont(new Font("Verdana", Font.BOLD, 10));
    }

    public void setTitle() {
        title = new JTextPane();
        title.setText("Hygge? Hygge!");
        title.setEditable(false);
        Font font = new Font("Segoe Script", Font.BOLD, 20);
        title.setFont(font);
    }

    public void setGo(ArrayList<Integer> hgChoice) {
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hgChoice.size() != 3) {
                    new GamePanel(hgChoice);
                    dispose();
                } else {
                    new EndPanel();
                    dispose();
                }
            }
        });
    }
}
