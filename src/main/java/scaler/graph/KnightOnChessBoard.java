package scaler.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given any source point, (C, D) and destination point, (E, F) on a chess board of size A x B, we need to find whether Knight can move to the destination or not.
 * If yes, then what would be the minimum number of steps for the knight to move to the said point. If knight can not move from the source point to the destination point, then return -1.
 * NOTE: A knight cannot go out of the board.
 */
public class KnightOnChessBoard {
    public static void main(String[] args) {
        System.out.println(solve(8, 8, 1, 1, 8, 8));
        System.out.println(solve(2, 4, 2, 1, 4, 4));
    }

    private static int solve(int A, int B, int C, int D, int E, int F) {
        if (C == E && D == F) {
            return 0;
        }

        final Pair[] moves = new Pair[]{
                new Pair(-2, 1),
                new Pair(-1, 2),
                new Pair(1, 2),
                new Pair(2, 1),
                new Pair(2, -1),
                new Pair(1, -2),
                new Pair(-1, -2),
                new Pair(-2, -1)
        };
        int ans = 1;

        final boolean[][] visited = new boolean[A + 1][B + 1];

        //Perform BFS from source
        final Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(C, D));
        visited[C][D] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();

            //Iterating level by level
            while (size-- > 0) {
                final Pair current = queue.poll();

                //If destination reached return ans
                if (current.x == E && current.y == F) {
                    return ans;
                }

                //Next possible moves
                for (final Pair next : moves) {
                    int i = current.x + next.x;
                    int j = current.y + next.y;

                    //Check if valid destination(careful about the 0th row and col(ignore them))
                    if (i >= 1 && i <= A && j >= 1 && j <= B && !visited[i][j]) {
                        queue.add(new Pair(i, j));
                        visited[i][j] = true;
                    }
                }
            }
            ans++;
        }

        return -1;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int rows, cols;
    int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    int dest_x, dest_y;
    int[][] visited;

    //COPIED WORKING
    public int knight(int A, int B, int C, int D, int E, int F) {
        if (A < E || A < C || B < D || B < F) {
            return -1;
        }
        rows = A;
        cols = B;
        dest_x = E;
        dest_y = F;

        visited = new int[rows + 1][cols + 1];

        //used simple BFS to find min distance
        return minMoves(C, D);

    }

    private int minMoves(int x, int y) {
        final Queue<Pair> q = new LinkedList<>();
        //add the source node to queue
        q.add(new Pair(x, y));

        //initialising count for moves
        int count = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            //iterating level by level
            while (size-- > 0) {
                final Pair curr = q.poll();

                //if destination reached return count
                if (curr.x == dest_x && curr.y == dest_y)
                    return count;

                //iterate for all possible positions from current position
                for (int i = 0; i < dx.length; i++) {
                    if (isValidMove(curr.x + dx[i], curr.y + dy[i])) {
                        visited[curr.x + dx[i]][curr.y + dy[i]] = 1;
                        q.add(new Pair(curr.x + dx[i], curr.y + dy[i]));
                    }
                }
            }
            count++;
        }
        if (visited[dest_x][dest_y] == 0)
            return -1;

        return count;
    }

    private boolean isValidMove(int i, int j) {
        return i > 0 && i <= rows && j > 0 && j <= cols && visited[i][j] != 1;
    }
}
