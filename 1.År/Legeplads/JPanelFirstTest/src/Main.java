

// Java Program to Create a Simple JPanel 
// and Adding Components to it 

// Importing required classes 
import java.awt.*;
import javax.swing.*;

// Class 1 
// Helper class extending JFrame class 
class Main extends JFrame {

    // JFrame 
    static JFrame f;

    // JButton 
    static JButton b, b1, b2;

    // Label to display text 
    static JLabel l;

    // Main class 
    public static void main(String[] args)
    {
        // Creating a new frame to store text field and 
        // button 
        f = new JFrame("panel");

        // Creating a label to display text 
        l = new JLabel("panel label");

        // Creating a new buttons 
        b = new JButton("button1");
        b1 = new JButton("button2");
        b2 = new JButton("button3");

        // Creating a panel to add buttons 
        JPanel p = new JPanel();

        // Adding buttons and textfield to panel 
        // using add() method 
        p.add(b);
        p.add(b1);
        p.add(b2);
        p.add(l);

        // setbackground of panel 
        p.setBackground(Color.red);

        // Adding panel to frame 
        f.add(p);

        // Setting the size of frame 
        f.setSize(300, 300);

        f.show();
    }
}
