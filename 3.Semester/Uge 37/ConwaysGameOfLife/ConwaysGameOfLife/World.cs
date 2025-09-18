using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConwaysGameOfLife
{
    internal class World
    {
        private int Width, Height;
        private int[,] Map;
        public World() : this(15, 15)
        {
        }

        public World(int width, int height)
        {
            Width = width;
            Height = height;
            Map = new int[width, height];
        }

        private int this[int x, int y]
        {
            get
            {
                if (LegalX(x) && LegalY(y))
                {
                    return Map[x, y];
                }
                return 0; 
            }
        }


        private static Random rand = new Random();
        public void Randomize(double freq = 0.5)
        {
            for (int x = 0; x < Width; x++)
            {
                for (int y = 0; y < Height; y++)
                {
                    Map[x, y] = rand.NextDouble() > freq ? 1 : 0; // 1 = alive, 0 = dead
                }
            }
        }

        private bool LegalX(int x)
        {
            return x >= 0 && x < Width;
        }
        private bool LegalY(int y)
        {
            return y >= 0 && y < Height;
        }

        public int Neighbours(int x, int y)
        {
            int count = 0;
            for (int deltaX = -1; deltaX <= 1; deltaX++)
            {
                for (int deltaY = -1; deltaY <= 1; deltaY++)
                {
                    if (deltaX == 0 && deltaY == 0) continue; // Hop over self
                    int nx = x + deltaX; // Neighbor X
                    int ny = y + deltaY; // Neighbor Y
                    if (LegalX(nx) && LegalY(ny))
                    {
                        count += this[nx, ny]; // Add 1 if alive, 0 if dead
                    }
                }
            }
            return count;
        }

        public void Iterate()
        {
            int[,] newMap = new int[Width, Height];
            for (int x = 0; x < Width; x++)
            {
                for (int y = 0; y < Height; y++)
                {
                    int alive = this[x, y];
                    int neighbors = Neighbours(x, y);
                    if (alive == 1)
                    {
                        // Any live cell with two or three live neighbours survives.
                        newMap[x, y] = (neighbors == 2 || neighbors == 3) ? 1 : 0;
                    }
                    else
                    {
                        // Any dead cell with exactly three live neighbours becomes a live cell.
                        newMap[x, y] = (neighbors == 3) ? 1 : 0;
                    }
                }
            }
            Map = newMap;
        }

        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            for (int y = 0; y < Height; y++)
            {
                for (int x = 0; x < Width; x++)
                {
                    sb.Append(Map[x, y] == 1 ? 'X' : '.'); // Alive = X, Dead = .
                }
                sb.AppendLine();
            }
            return sb.ToString();
        }

        
    }
}
