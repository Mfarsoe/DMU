using System;

namespace StubSkeletonPattern.Common {

  public static class ConsoleUtils {
    private static readonly object lockObject = new object();

    public static void WriteLine(ConsoleColor color, string line) {
      lock (lockObject) {
        ConsoleColor original = Console.ForegroundColor;
        {
          Console.ForegroundColor = color;
          Console.WriteLine(line);
        }
        Console.ForegroundColor = original;
      }
    }

    public static void WriteLine(string line) {
      lock (lockObject) {
        WriteLine(Console.ForegroundColor, line);
      }
    }
  }
}
