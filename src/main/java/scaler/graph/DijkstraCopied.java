package scaler.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DijkstraCopied {
    public static void main(String[] args) {
        int[][] B = new int[][]{{0, 4, 9}, {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1}};
        System.out.println(Arrays.toString(new DijkstraCopied().solve(6, B, 4)));

        B = new int[][]{{0, 3, 4}, {2, 3, 3}, {0, 1, 9}, {3, 4, 10}, {1, 3, 8}};
        System.out.println(Arrays.toString(new DijkstraCopied().solve(5, B, 4)));
    }

    public int[] solve(int A, int[][] B, int C) {
        ArrayList<Pair>[] graph = buildAdjList(B, A);
        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[C] = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.weight));
        minHeap.add(new Pair(C, 0)); // node, distance

        while (minHeap.size() > 0) {
            Pair pair = minHeap.poll();
            int u = pair.node;
            int d = pair.weight;
            if (dist[u] == d) {
                for (int i = 0; i < graph[u].size(); i++) {
                    Pair p = graph[u].get(i);
                    int v = p.node;
                    int w = p.weight;
                    if (dist[u] + w < dist[v]) {
                        dist[v] = dist[u] + w;
                        minHeap.add(new Pair(v, dist[v]));
                    }
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }
        return dist;
    }

    private ArrayList<Pair>[] buildAdjList(int[][] matrix, int noOfNodes) {
        ArrayList<Pair>[] graph = new ArrayList[noOfNodes];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < matrix.length; i++) {
            int u = matrix[i][0];
            int v = matrix[i][1];
            int w = matrix[i][2];

            //undirected graph
            Pair p = new Pair(v, w);
            ArrayList<Pair> currList = graph[u];
            currList.add(p);

            Pair p2 = new Pair(u, w);
            ArrayList<Pair> currList2 = graph[v];
            currList2.add(p2);
        }

        return graph;
    }
}

class Pair {
    int node;
    int weight;

    Pair(int n, int w) {
        this.node = n;
        this.weight = w;
    }
}
