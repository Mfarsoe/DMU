import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Game extends JFrame {
    static int balance;
    static JFrame frame;
    static JButton b1, b2, b3, b4, b5, b6, b7, b8, b9;
    static JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9;

    public static void main(String[] args) {
        frame = new JFrame();
        l1 = new JLabel("John sat in his car, staring at the crumpled", SwingConstants.CENTER);
        l2 = new JLabel("$100 bill in his hand, knowing it was his last chance. ", SwingConstants.CENTER);
        JPanel startPanel = new JPanel();
        startPanel.add(l1);
        startPanel.add(l2);
        frame.add(startPanel);
        frame.setSize(800, 800);
        frame.show();




    }
}
