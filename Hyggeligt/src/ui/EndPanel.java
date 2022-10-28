package ui;

import model.hgValue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static javax.swing.JOptionPane.showMessageDialog;

public class EndPanel extends JFrame {
    private static final int HEIGHT = 600;
    private static final int WIDTH = 730;
    private JLabel picturePanel;
    private JTextPane message;
    private JButton rePlay;

    private JButton endMassage;

    public EndPanel() {
        super("Hyggeligt");

        endPic();
        add(picturePanel);

        setMessage();
        add(message);

        rePlay = new JButton("Play Again");
        setRePlay();
        add(rePlay);

        endMassage = new JButton("End Message");
        setEndMassage();
        add(endMassage);

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(HEIGHT, WIDTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void endPic() {
        try {
            URL url = getClass().getResource("text5.png");
            BufferedImage myPicture = ImageIO.read(new File(url.getPath()));
            picturePanel = new JLabel(new ImageIcon(myPicture));
            picturePanel.setPreferredSize(new Dimension(500, 500));
        } catch (IOException e) {
            showMessageDialog(null, "unable to add picture");
            System.exit(0);
        }
    }

    private void setMessage() {
        message = new JTextPane();
        message.setText("Det er Hyggeligt!");
        message.setEditable(false);
        Font font = new Font("Segoe Script", Font.BOLD, 60);
        message.setFont(font);
    }

    private void setRePlay() {
        rePlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StartPanel();
                dispose();
            }
        });
    }

    private void setEndMassage() {
        endMassage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EndMessage();
            }
        });
    }
}
