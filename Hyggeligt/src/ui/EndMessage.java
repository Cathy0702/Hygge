package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import static javax.swing.JOptionPane.showMessageDialog;

public class EndMessage extends JFrame {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 760;
    private JLabel picturePanel;
    private JTextArea message;
    private JTextArea outputWord;
    private JTextField inputWord;

    public EndMessage() {
        super("hyggeligt");
        pic();
        add(picturePanel);

        setMessage();
        add(message);

        outputWord = new JTextArea("ex. Having dinner with friends \n",15, 50 );
        outputWord.setEditable(false);
        add(outputWord);

        inputWord = new JTextField(50);
        setInputWord();
        add(inputWord);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(HEIGHT, WIDTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void pic() {
        try {
            URL url = getClass().getResource("end.png");
            BufferedImage myPicture = ImageIO.read(new File(url.getPath()));
            picturePanel = new JLabel(new ImageIcon(myPicture));
            picturePanel.setPreferredSize(new Dimension(600, 200));
        } catch (IOException e) {
            showMessageDialog(null, "unable to add picture");
            System.exit(0);
        }
    }

    public void setMessage() {
        message = new JTextArea("As someone who is learning the language, \n" +
                "it is also difficult for me to accurately express the meaning of this untranslatable word, \n" +
                "“hygge”.\n" +
                "\n" +
                "For me, it's drawn curtains, lit candles, warm coffee, and interesting books. \n" +
                "But these all seem to be just expressions of \"hygge\". \n" +
                "Behind them, hygge is about sharing happiness with family and friends, \n" +
                "about rewarding yourself and taking a break from your busy schedule. \n" +
                "It is more like an attitude to appreciate oneself, enjoy life and live in the moment.\n" +
                "\n" +
                "The things mentioned in this program are far from enough. \n" +
                "What is hygge for you? Write it down below!\n");
        message.setEditable(false);
    }

    public void setInputWord() {
        inputWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!inputWord.getText().isEmpty()) {
                    String input = inputWord.getText();
                    String newLine = "\n";
                    String initialInput = "";
                    outputWord.append(input + newLine);
                    inputWord.setText(initialInput);
                } else {
                    showMessageDialog(null, "Cannot enter an empty word!");
                }
            }
        });
    }
}
