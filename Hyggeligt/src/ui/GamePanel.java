package ui;

import model.hgValue;
import sun.security.util.ArrayUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class GamePanel extends JFrame {
    private static final int HEIGHT = 700;
    private static final int WIDTH = 700;
    private List<Integer> value;
    //private ValuePanel valuePanel;
    private JTextArea score;
    private PicturePanel picturePanel;
    //private ChoosePanel choosePanel;
    private JTextPane question;
    private JButton choice0;
    private JButton choice1;
    private JButton choice2;
    private JButton no;
    private ArrayList<Integer> hgChoice;

    public GamePanel(ArrayList<Integer> hgChoice) {
        super("Hyggeligt");
        this.hgChoice = hgChoice;

        initializeScore(hgChoice.size());
        score.setEditable(false);
        add(score);

        picturePanel = new PicturePanel(hgChoice);
        add(picturePanel);

        setQuestion();
        add(question);

        choice0 = new JButton("Jeg lukker gardinet");
        choice1 = new JButton("Jeg tænder stearinlys");
        choice2 = new JButton("Jeg henter bøger og kaffe");
        setButton0();
        setButton1();
        setButton2();
        setButtons(hgChoice);

        no = new JButton("Jeg gør ikke noget");
        setNo();
        add(no);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(HEIGHT, WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setButtons(ArrayList<Integer> hgChoice) {
        if (!hgChoice.contains(0)) {
            add(choice0);
        }
        if (!hgChoice.contains(1)) {
            add(choice1);
        }
        if (!hgChoice.contains(2)) {
            add(choice2);
        }
    }

    public void setQuestion() {
        question = new JTextPane();
        question.setText("What do you want to do next?");
        question.setEditable(false);
        Font font = new Font("Verdana", Font.BOLD, 35);
        question.setFont(font);
    }

    public void initializeScore(int value) {
        if (value == 0) {
            score = new JTextArea("YOUR HYGGE SCORE: 0/3", 1, 30);
        } else if (value == 1) {
            score = new JTextArea("YOUR HYGGE SCORE: 1/3", 1, 30);
        } else if (value == 2) {
            score = new JTextArea("YOUR HYGGE SCORE: 2/3", 1, 30);
        }
        Font font = new Font("Segoe Script", Font.BOLD, 16);
        score.setFont(font);
    }

    private void setButton0() {
        choice0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hgChoice.add(0);
                new MessagePanel(hgChoice);
                dispose();
            }
        });
    }

    private void setButton1() {
        choice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hgChoice.add(1);
                new MessagePanel(hgChoice);
                dispose();
            }
        });
    }

    private void setButton2() {
        choice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hgChoice.add(2);
                new MessagePanel(hgChoice);
                dispose();
            }
        });
    }

    private void setNo() {
        no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showMessageDialog(null, "Sure! Why not stay in this stage for a while?");
            }
        });
    }

}
