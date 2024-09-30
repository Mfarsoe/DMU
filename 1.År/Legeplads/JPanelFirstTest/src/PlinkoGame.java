import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PlinkoGame extends JFrame {
    private PlinkoBoard board;
    private JLabel outcomeLabel;

    public PlinkoGame() {
        setTitle("Plinko Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);

        board = new PlinkoBoard();
        outcomeLabel = new JLabel("Outcome: ");
        outcomeLabel.setFont(new Font("Serif", Font.BOLD, 18));

        JButton startButton = new JButton("Drop Ball");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int outcome = board.dropBall();
                outcomeLabel.setText("Outcome: Slot " + outcome);
            }
        });

        JPanel controlPanel = new JPanel();
        controlPanel.add(startButton);
        controlPanel.add(outcomeLabel);

        add(board, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlinkoGame game = new PlinkoGame();
            game.setVisible(true);
        });
    }
}

class PlinkoBoard extends JPanel {
    private static final int PEG_RADIUS = 10;
    private static final int BALL_RADIUS = 15;
    private static final int SLOT_COUNT = 5;
    private int ballX;
    private int ballY;
    private boolean ballDropped;
    private Random random;

    public PlinkoBoard() {
        setPreferredSize(new Dimension(400, 500));
        ballX = getWidth() / 2;
        ballY = 0;
        ballDropped = false;
        random = new Random();
    }

    public int dropBall() {
        ballX = getWidth() / 2;  // Start at the center
        ballY = 0;               // Start at the top
        ballDropped = true;

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ballY < getHeight() - BALL_RADIUS) {
                    // Simulate ball movement and bouncing
                    ballY += 5;  // Move the ball down
                    ballX += random.nextBoolean() ? -5 : 5; // Random left or right
                    repaint();
                } else {
                    ((Timer) e.getSource()).stop(); // Stop the timer
                }
            }
        });
        timer.start();

        // Calculate final slot (simply for demonstration purposes)
        int slotWidth = getWidth() / SLOT_COUNT;
        return ballX / slotWidth;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPegs(g);
        drawSlots(g);

        if (ballDropped) {
            g.setColor(Color.RED);
            g.fillOval(ballX - BALL_RADIUS, ballY - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
        }
    }

    private void drawPegs(Graphics g) {
        g.setColor(Color.BLUE);
        for (int row = 50; row < getHeight() - 100; row += 50) {
            for (int col = 50; col < getWidth(); col += 50) {
                g.fillOval(col - PEG_RADIUS, row - PEG_RADIUS, PEG_RADIUS * 2, PEG_RADIUS * 2);
            }
        }
    }

    private void drawSlots(Graphics g) {
        g.setColor(Color.BLACK);
        int slotWidth = getWidth() / SLOT_COUNT;
        for (int i = 0; i <= SLOT_COUNT; i++) {
            int x = i * slotWidth;
            g.drawLine(x, getHeight() - 100, x, getHeight());
        }
    }
}
