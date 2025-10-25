import java.util.*;

public class NQueens {

    // Stores all valid board configurations
    static List<List<String>> solutions = new ArrayList<>();

    public static void main(String[] args) {
        int n = 4; // Change N to any size
        solveNQueens(n);

        // Print all solutions
        for (List<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }

    // Main solving function
    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Initialize the board with empty cells
        for (int i = 0; i < n; i++)
            Arrays.fill(board[i], '.');

        backtrack(board, 0, n);
        return solutions;
    }

    // Recursive backtracking function
    private static void backtrack(char[][] board, int row, int n) {
        if (row == n) {
            // Found a valid configuration
            List<String> current = new ArrayList<>();
            for (char[] r : board)
                current.add(new String(r));
            solutions.add(current);
            return;
        }

        // Try placing queen in each column of this row
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, n);
                board[row][col] = '.'; // Backtrack
            }
        }
    }

    // Check if placing a queen at (row, col) is safe
    private static boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }
}
