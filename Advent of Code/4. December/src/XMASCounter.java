public class XMASCounter {
    public static void main(String[] args) {
        String filepath = "input.txt";



        // Define the word to search for
        String targetWord = "XMAS";

        // Count the total occurrences of the target word
        int totalOccurrences = countWordOccurrences(ReadFile.readFileToCharGrid(filepath), targetWord);

        // Output the result
        System.out.println("Total occurrences of '" + targetWord + "': " + totalOccurrences);


    }





/**
 * Counts the total occurrences of a word in the grid in all directions.
 *
 * @param grid       The 2D character array representing the word search grid.
 * @param targetWord The word to search for.
 * @return The total number of occurrences of the target word.
 */
public static int countWordOccurrences(char[][] grid, String targetWord) {
    int rows = grid.length;
    int cols = grid[0].length;
    int wordLength = targetWord.length();
    int totalCount = 0;

    // Define the possible directions to search in the grid
    int[][] directions = {
            {0, 1},   // Right
            {0, -1},  // Left
            {1, 0},   // Down
            {-1, 0},  // Up
            {1, 1},   // Down-right diagonal
            {-1, -1}, // Up-left diagonal
            {1, -1},  // Down-left diagonal
            {-1, 1}   // Up-right diagonal
    };

    // Iterate over every cell in the grid
    for (int row = 0; row < rows; row++) {
        for (int col = 0; col < cols; col++) {
            // Check all directions from this cell
            for (int[] direction : directions) {
                int rowDelta = direction[0];
                int colDelta = direction[1];

                // If the word exists in this direction, increment the count
                if (isWordFound(grid, row, col, rowDelta, colDelta, targetWord)) {
                    totalCount++;
                }
            }
        }
    }
    return totalCount;
}

/**
 * Checks if a word exists starting from a specific cell in a specific direction.
 *
 * @param grid       The 2D character array representing the word search grid.
 * @param startRow   The starting row index.
 * @param startCol   The starting column index.
 * @param rowDelta   The change in row for each step.
 * @param colDelta   The change in column for each step.
 * @param targetWord The word to search for.
 * @return True if the word exists in the specified direction, false otherwise.
 */
public static boolean isWordFound(
        char[][] grid,
        int startRow,
        int startCol,
        int rowDelta,
        int colDelta,
        String targetWord
) {
    int rows = grid.length;
    int cols = grid[0].length;
    int wordLength = targetWord.length();

    // Check each character of the word
    for (int charIndex = 0; charIndex < wordLength; charIndex++) {
        // Calculate the current position
        int currentRow = startRow + charIndex * rowDelta;
        int currentCol = startCol + charIndex * colDelta;

        // Check if the position is out of bounds
        if (currentRow < 0 || currentRow >= rows || currentCol < 0 || currentCol >= cols) {
            return false;
        }

        // Check if the character does not match
        if (grid[currentRow][currentCol] != targetWord.charAt(charIndex)) {
            return false;
        }
    }
    return true; // All characters matched
}
}
