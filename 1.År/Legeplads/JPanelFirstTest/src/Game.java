import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Game extends JFrame {
    public static void main(String[] args) {
        JFrame f;
        JPanel p;
        JButton b;

        f = new JFrame();
        p = new JPanel();
        b = new JButton("Play");


        p.add(b);
        p.setBackground(Color.red);
        f.add(p);
        f.setSize(800, 600);
        f.show();
    }
}
