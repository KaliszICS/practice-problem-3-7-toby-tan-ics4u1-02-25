import java.util.*;

public class PracticeProblem {

    public static int searchMazeMoves(String[][] maze) {
        int rows = maze.length;
        int cols = maze[0].length;
        int startRow = rows - 1;
        int startCol = -1;

        // Find 'S' in the bottom row
        for (int col = 0; col < cols; col++) {
            if (maze[startRow][col].equals("S")) {
                startCol = col;
                break;
            }
        }

        if (startCol == -1) return -1; // No start found

        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol, 0});
        visited[startRow][startCol] = true;

        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0], c = current[1], dist = current[2];

            if (maze[r][c].equals("F")) return dist;

            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (inBounds(newR, newC, rows, cols) &&
                    !visited[newR][newC] &&
                    !maze[newR][newC].equals("*")) {
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC, dist + 1});
                }
            }
        }

        return -1; //no freaking path xD - ya boy stylewithrj
    }

    private static boolean inBounds(int r, int c, int rows, int cols) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    public static void main(String[] args) {
        // Optional testing
    }
}
