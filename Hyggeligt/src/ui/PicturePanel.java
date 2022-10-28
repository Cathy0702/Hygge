package ui;

import model.hgValue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class PicturePanel extends JPanel {
    private URL url;
    private BufferedImage myPicture;
    private JLabel picLabel;

    public PicturePanel(ArrayList<Integer> hgChoice) {
        if (hgChoice.size() == 0) {
            initialPic();
        } else if (hgChoice.size() == 1) {
            Pic1(hgChoice);
        } else if (hgChoice.size() == 2) {
            Pic2(hgChoice);
        } else {
            endPic();
        }
        picLabel.setPreferredSize(new Dimension(500, 500));
        add(picLabel);
    }

    private void initialPic() {
        try {
            url = getClass().getResource("text1.png");
            myPicture = ImageIO.read(new File(url.getPath()));
            picLabel = new JLabel(new ImageIcon(myPicture));
        } catch (IOException e) {
            showMessageDialog(null, "unable to add picture");
            System.exit(0);
        }
    }

    private void endPic() {
        try {
            url = getClass().getResource("text5.png");
            myPicture = ImageIO.read(new File(url.getPath()));
            picLabel = new JLabel(new ImageIcon(myPicture));
        } catch (IOException e) {
            showMessageDialog(null, "unable to add picture");
            System.exit(0);
        }
    }
    private void Pic1(ArrayList<Integer> hgChoice) {
        // TODO: pictures
        try {
            if (hgChoice.contains(0)) {
                url = getClass().getResource("hg1.png");
                myPicture = ImageIO.read(new File(url.getPath()));
                picLabel = new JLabel(new ImageIcon(myPicture));
            } else if (hgChoice.contains(1)) {
                url = getClass().getResource("hg2.png");
                myPicture = ImageIO.read(new File(url.getPath()));
                picLabel = new JLabel(new ImageIcon(myPicture));
            } else {
                url = getClass().getResource("hg3.png");
                myPicture = ImageIO.read(new File(url.getPath()));
                picLabel = new JLabel(new ImageIcon(myPicture));
            }
        } catch (IOException e) {
            showMessageDialog(null, "unable to add picture");
            System.exit(0);
        }
    }

    private void Pic2(ArrayList<Integer> hgChoice) {
        // TODO: pictures
        try {
            if (hgChoice.contains(0) && hgChoice.contains(1)) {
                url = getClass().getResource("hg12.png");
                myPicture = ImageIO.read(new File(url.getPath()));
                picLabel = new JLabel(new ImageIcon(myPicture));
            } else if (hgChoice.contains(0) && hgChoice.contains(2)) {
                url = getClass().getResource("hg13.png");
                myPicture = ImageIO.read(new File(url.getPath()));
                picLabel = new JLabel(new ImageIcon(myPicture));
            } else {
                url = getClass().getResource("hg23.png");
                myPicture = ImageIO.read(new File(url.getPath()));
                picLabel = new JLabel(new ImageIcon(myPicture));
            }
        } catch (IOException e) {
            showMessageDialog(null, "unable to add picture");
            System.exit(0);
        }
    }


}
