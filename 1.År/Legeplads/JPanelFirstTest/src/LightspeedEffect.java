import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class LightspeedEffect extends JPanel {

    private final ArrayList<Star> stars = new ArrayList<>();
    private final Random random = new Random();
    private int centerX, centerY;

    public LightspeedEffect(int numberOfStars) {
        setBackground(Color.BLACK);
        centerX = 400;  // Initial center position (can be changed dynamically)
        centerY = 400;

        // Create stars with random initial positions
        for (int i = 0; i < numberOfStars; i++) {
            stars.add(new Star(random.nextInt(800), random.nextInt(800), random.nextInt(10) + 1));
        }

        // Timer to repaint and update the position of stars
        Timer timer = new Timer(20, e -> updateStars());
        timer.start();
    }

    private void updateStars() {
        for (Star star : stars) {
            star.updatePosition(centerX, centerY);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);

        for (Star star : stars) {
            // Draw each star
            g2d.drawLine(star.x, star.y, star.previousX, star.previousY);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Lightspeed Effect");
        LightspeedEffect panel = new LightspeedEffect(200);  // 200 stars
        frame.add(panel);
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class Star {
    int x, y;            // Current position
    int previousX, previousY; // Previous position
    int speed;           // Speed at which the star moves

    public Star(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.previousX = x;
        this.previousY = y;
        this.speed = speed;
    }

    public void updatePosition(int centerX, int centerY) {
        // Save the current position as the previous position
        previousX = x;
        previousY = y;

        // Move the star outwards relative to the center of the screen
        int deltaX = x - centerX;
        int deltaY = y - centerY;

        x += deltaX * speed / 10;
        y += deltaY * speed / 10;

        // If the star goes out of bounds, reset it
        if (x < 0 || x > 800 || y < 0 || y > 800) {
            x = centerX + (int) (Math.random() * 200 - 100);
            y = centerY + (int) (Math.random() * 200 - 100);
            previousX = x;
            previousY = y;
        }
    }
}
