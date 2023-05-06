package scaler.graph;

import java.util.*;

/**
 * Given a undirected weighted graph with A nodes labelled from 1 to A with M edges given in a form of 2D-matrix B
 * of size M * 3 where B[i][0] and B[i][1] denotes the two nodes connected by an edge of weight B[i][2].
 * For each edge check whether it belongs to any of the possible minimum spanning tree or not , return 1 if it belongs else return 0.
 * Return an one-dimensional binary array of size M denoting answer for each edge.
 */
public class EdgeInMST {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = new int[][]{{1, 2, 2}, {1, 3, 2}, {2, 3, 3}};
        System.out.println(Arrays.toString(solve(A, B)));

        A = 7;
        B = new int[][]{{1, 2, 468}, {2, 3, 335}, {3, 1, 501}, {2, 4, 170}, {2, 5, 725}, {2, 7, 479}, {4, 6, 359}, {5, 6, 963}};
        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(int A, int[][] B) {
        //Create parent array for Disjoint subset tree
        int[] parent = new int[A + 1];
        // Initially assign self loop for parent
        for (int i = 1; i <= A; i++)
            parent[i] = i;
        // Creates a new array C that will also have the index of the pair after sorting
        int[][] C = new int[B.length][4];
        for (int i = 0; i < B.length; i++) {
            C[i][0] = B[i][0];
            C[i][1] = B[i][1];
            C[i][2] = B[i][2];
            C[i][3] = i;
        }
        // Sort the newly Created array with weights
        Arrays.parallelSort(C, Comparator.comparingInt(c -> c[2]));
        int[] res = new int[B.length];
        int i = 0, j = 0;
        while (i < B.length) {
            j = i;
            // Checks for the same weighted nodes that can they be part of spanning tree
            while (j < B.length && C[i][2] == C[j][2]) {
                if (root(C[j][0], parent) != root(C[j][1], parent))
                    res[C[j][3]] = 1;
                j++;
            }
            j = i;
            // Merge the same weighted edges in a union if required
            while (j < B.length && C[i][2] == C[j][2]) {
                makeUnion(C[j][0], C[j][1], parent);
                j++;
            }
            i = j;
        }
        return res;
    }

    static int root(int x, int[] parent) {
        if (x == parent[x])
            return x;
        parent[x] = root(parent[x], parent);
        return parent[x];
    }

    static boolean makeUnion(int x, int y, int[] parent) {
        int xx = root(x, parent);
        int yy = root(y, parent);
        if (xx == yy)
            return false;
        parent[yy] = xx;
        return true;
    }
}
