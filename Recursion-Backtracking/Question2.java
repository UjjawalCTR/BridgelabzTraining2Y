import java.util.ArrayList;
import java.util.List;

public class Question2 {
    static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean search(char[][] grid, String word, int r, int c,
                          int index, boolean[][] visited) {
        if (index == word.length()) return true;

        if (r < 0 || r >= grid.length ||
            c < 0 || c >= grid[0].length ||
            visited[r][c] || grid[r][c] != word.charAt(index)) {
            return false;
        }

        visited[r][c] = true;
        for (int k = 0; k < 8; k++) {
            if (search(grid, word, r + DR[k], c + DC[k],
                       index + 1, visited)) {
                visited[r][c] = false;
                return true;
            }
        }
        visited[r][c] = false; // undo this choice
        return false;
    }

    static boolean exists(char[][] grid, String word) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == word.charAt(0) &&
                    search(grid, word, r, c, 0, visited)) return true;
            }
        }
        return false;
    }

    static void findAll(char[][] grid, String word, int r, int c, int index,
                        boolean[][] visited, List<String> path,
                        List<List<String>> answers) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
            visited[r][c] || grid[r][c] != word.charAt(index)) return;

        visited[r][c] = true;
        path.add("(" + r + "," + c + ") " + grid[r][c]);

        if (index == word.length() - 1) {
            answers.add(new ArrayList<>(path));
        } else {
            for (int k = 0; k < 8; k++) {
                findAll(grid, word, r + DR[k], c + DC[k], index + 1,
                        visited, path, answers);
            }
        }
        path.remove(path.size() - 1);
        visited[r][c] = false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'C', 'A', 'T', 'S'},
            {'O', 'R', 'E', 'A'},
            {'D', 'E', 'A', 'M'},
            {'E', 'L', 'L', 'S'}
        };
        System.out.println("DREAM exists: " + exists(grid, "DREAM"));

        List<List<String>> answers = new ArrayList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 'D') {
                    findAll(grid, "DREAM", r, c, 0, visited,
                            new ArrayList<>(), answers);
                }
            }
        }
        System.out.println("Number of paths found: " + answers.size());
        for (List<String> path : answers) System.out.println(path);
    }
}