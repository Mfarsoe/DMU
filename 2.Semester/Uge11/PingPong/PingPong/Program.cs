using System;
using System.Threading;

namespace ConsolePingPong {
    class Program {
        static int paddleY = 10;
        static int ballX = 40, ballY = 12;
        static int ballDirX = 1, ballDirY = 1;
        static int score = 0;
        const int width = 80;
        const int height = 24;

        static void Main() {
            Console.CursorVisible = false;
            Console.SetWindowSize(width, height);

            Thread inputThread = new Thread(HandleInput);
            inputThread.Start();

            while (true) {
                Update();
                Render();
                Thread.Sleep(50);
            }
        }

        static void HandleInput() {
            while (true) {
                var key = Console.ReadKey(true).Key;

                if (key == ConsoleKey.W && paddleY > 0)
                    paddleY--;
                else if (key == ConsoleKey.S && paddleY < height - 4)
                    paddleY++;
            }
        }

        static void Update() {
            // Update ball position
            ballX += ballDirX;
            ballY += ballDirY;

            // Ball collision with walls
            if (ballY <= 0 || ballY >= height - 1)
                ballDirY *= -1;

            // Ball collision with paddle
            if (ballX == 2 && ballY >= paddleY && ballY <= paddleY + 3) {
                ballDirX *= -1;
                score++;
            }

            // Ball out of bounds (Game Over)
            if (ballX <= 0 || ballX >= width - 1) {
                Console.Clear();
                Console.SetCursorPosition(width / 2 - 6, height / 2);
                Console.WriteLine("Game Over!");
                Console.SetCursorPosition(width / 2 - 8, height / 2 + 1);
                Console.WriteLine($"Final Score: {score}");
                Thread.Sleep(2000);
                Environment.Exit(0);
            }
        }

        static void Render() {
            Console.Clear();

            // Draw Paddle
            for (int i = 0; i < 4; i++) {
                Console.SetCursorPosition(1, paddleY + i);
                Console.Write("|");
            }

            // Draw Ball
            Console.SetCursorPosition(ballX, ballY);
            Console.Write("O");

            // Draw Score
            Console.SetCursorPosition(width / 2 - 5, 0);
            Console.Write($"Score: {score}");
        }
    }
}
