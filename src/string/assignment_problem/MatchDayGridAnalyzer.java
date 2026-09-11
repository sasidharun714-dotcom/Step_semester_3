package string.assignment_problem;

public class MatchDayGridAnalyzer {

    static void analyzeGrid(int[][] grid) {

        int highest = grid[0][0];
        int row = 0;
        int column = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] > highest) {
                    highest = grid[i][j];
                    row = i;
                    column = j;
                }
            }
        }

        System.out.println("Highest Score: " + highest);
        System.out.println("Position: Row " + (row + 1)
                + ", Column " + (column + 1));
    }

    public static void main(String[] args) {

        int[][] grid = {
                {10, 25, 15},
                {30, 20, 40},
                {18, 35, 22}
        };

        analyzeGrid(grid);
    }
}