package companies.intuit;

/**
 * You are given with a MxN matrix grid. And island is a group of 1's(representing land) connected 4-directionally(horizontal or vertical).
 * You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 on the island.
 * Return the maximum area of an island in the gris. If there is no island, return 0.
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        //System.out.println(maxAreaOfIsland(grid));
        System.out.println(solve(grid));

        grid = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
        //System.out.println(maxAreaOfIsland(grid));
        System.out.println(solve(grid));
    }

    private static int solve(int[][] grid) {
        int max = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }

        return max;
    }

    private static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int count = 1;
        count += dfs(grid, i + 1, j);
        count += dfs(grid, i - 1, j);
        count += dfs(grid, i, j + 1);
        count += dfs(grid, i, j - 1);
        return count;
    }

    static int area = 0;
    static int maxArea = Integer.MIN_VALUE;

    private static int maxAreaOfIsland(int[][] grid) {
        area = 0;
        maxArea = Integer.MIN_VALUE;

        final int[][] directions = new int[][]{{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int current = grid[i][j];
                if (current == 1) {
                    moveRecursively(grid, directions, i, j);
                    maxArea = Math.max(maxArea, area);
                    area = 0;
                }
            }
        }

        return maxArea;
    }

    private static void moveRecursively(int[][] grid, int[][] directions, int row, int col) {
        area++;
        grid[row][col] = -1;
        for (int i = 0; i < directions.length; i++) {
            if (canMove(grid, directions[i], row, col, grid.length, grid[0].length)) {
                moveRecursively(grid, directions, row + directions[i][0], col + directions[i][1]);
            }
        }
    }

    private static boolean canMove(int[][] grid, int[] direction, int row, int col, int m, int n) {
        return row + direction[0] < m && row + direction[0] >= 0 && col + direction[1] < n && col + direction[1] >= 0 && grid[row + direction[0]][col + direction[1]] == 1;
    }
}
