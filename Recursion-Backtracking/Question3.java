public class Question3 {
    private final int n;
    private final int[] queenCol;
    private final boolean[] usedCol;
    private final boolean[] diagDown; // row - col + n - 1
    private final boolean[] diagUp;   // row + col

    Question3(int n) {
        this.n = n;
        queenCol = new int[n];
        usedCol = new boolean[n];
        diagDown = new boolean[2 * n - 1];
        diagUp = new boolean[2 * n - 1];
    }

    boolean solve(int row) {
        if (row == n) return true; // one solution found

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (usedCol[col] || diagDown[d1] || diagUp[d2]) continue;

            queenCol[row] = col;
            usedCol[col] = true;
            diagDown[d1] = true;
            diagUp[d2] = true;

            if (solve(row + 1)) return true;

            // Undo the placement when this branch fails.
            usedCol[col] = false;
            diagDown[d1] = false;
            diagUp[d2] = false;
        }
        return false;
    }

    void printBoard() {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(queenCol[row] == col ? "Q " : ". ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Question3 solver = new Question3(4);
        if (solver.solve(0)) {
            System.out.println("One solution for N = 4:");
            solver.printBoard();
            System.out.print("Column array: [");
            for (int i = 0; i < solver.n; i++) {
                System.out.print(solver.queenCol[i]);
                if (i < solver.n - 1) System.out.print(", ");
            }
            System.out.println("]");
        } else {
            System.out.println("No solution exists.");
        }
    }
}