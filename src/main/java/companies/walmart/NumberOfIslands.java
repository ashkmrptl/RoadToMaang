package companies.walmart;

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
        int count = 0;

        int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != '0') {
                    count++;
                    dfs(grid, directions, i, j);
                }
            }
        }

        return count;
    }

    private static void dfs(char[][] grid, int[][] directions, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        //Else mark the node as visited by changing it to zero
        grid[i][j] = '0';

        for (int[] direction : directions) {
            dfs(grid, directions, i + direction[0], j + direction[1]);
        }
    }
}
