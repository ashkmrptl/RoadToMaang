package companies.cisco;

/**
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};

        System.out.println(numIslands(grid));

        grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};

        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        final int[][] directions = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid, directions);
                }
            }
        }

        return count;
    }

    private static void dfs(int i, int j, char[][] grid, int[][] directions) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            for (int[] direction : directions) {
                dfs(i + direction[0], j + direction[1], grid, directions);
            }
        }
    }
}
