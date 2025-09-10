using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConwaysGameOfLife
{
    internal class World
    {
        public int Width { get; }
        public int Height { get; }
        public bool[,] Map { get; }
        
        public World() : this(15, 15)
        {
        }

        public World(int width, int height)
        {
            Width = width;
            Height = height;
            Map = new bool[width, height];
        }

        public void Randomize(double freq=0.5)
        {
            var rand = new Random();
            for (int x = 0; x < Width; x++)
            {
                for (int y = 0; y < Height; y++)
                {
                    Map[x, y] = rand.NextDouble() > freq;
                }
            }
        }
        public void Print()
        {
            for (int y = 0; y < Height; y++)
            {
                for (int x = 0; x < Width; x++)
                {
                    Console.Write(Map[x, y] ? "O" : ".");
                }
                Console.WriteLine();
            }
        }

        public void Step()
        {
            var newMap = new bool[Width, Height];
            for (int x = 0; x < Width; x++)
            {
                for (int y = 0; y < Height; y++)
                {
                    int aliveNeighbors = CountAliveNeighbors(x, y);
                    if (Map[x, y])
                    {
                        // Any live cell with two or three live neighbours survives.
                        newMap[x, y] = aliveNeighbors == 2 || aliveNeighbors == 3;
                    }
                    else
                    {
                        // Any dead cell with three live neighbours becomes a live cell.
                        newMap[x, y] = aliveNeighbors == 3;
                    }
                }
            }
            Array.Copy(newMap, Map, Width * Height);
        }

        private int CountAliveNeighbors(int x, int y)
        {
            int count = 0;
            for (int dx = -1; dx <= 1; dx++)
            {
                for (int dy = -1; dy <= 1; dy++)
                {
                    if (dx == 0 && dy == 0) continue; // Skip the cell itself
                    int nx = x + dx;
                    int ny = y + dy;
                    if (nx >= 0 && nx < Width && ny >= 0 && ny < Height)
                    {
                        if (Map[nx, ny]) count++;
                    }
                }
            }
            return count;
        }
    }
}
