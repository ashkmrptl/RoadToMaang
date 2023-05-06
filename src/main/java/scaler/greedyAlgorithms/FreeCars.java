package scaler.greedyAlgorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class FreeCars {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3, 2, 3, 3};
        int[] B = new int[]{5, 6, 1, 3, 9};
        System.out.println(solve(A, B));

        A = new int[]{3, 8, 7, 5};
        B = new int[]{3, 1, 7, 19};
        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int[] B) {
        int N = A.length;
        int mod = 1000 * 1000 * 1000 + 7;

        final Pair[] cars = new Pair[N];
        for (int i = 0; i < N; i++) {
            cars[i] = new Pair(A[i], B[i]);
        }

        Arrays.sort(cars);

        //Min heap to store the profit of cars in ascending order
        final Queue<Integer> minHeap = new PriorityQueue<>();
        int t = 0;
        int maxProfit = 0;

        for (int i = 0; i < N; i++) {
            if (t < cars[i].time) {
                t++;
                minHeap.add(cars[i].profit);
                maxProfit = (maxProfit + cars[i].profit) % mod;
            } else if (minHeap.size() > 0 && cars[i].profit > minHeap.peek()) {
                int bookedProfit = minHeap.poll();
                maxProfit = maxProfit - bookedProfit;
                minHeap.add(cars[i].profit);
                maxProfit = (maxProfit + cars[i].profit) % mod;
            }
        }
        return (maxProfit) % mod;
    }

    private static class Pair implements Comparable<Pair> {
        int time;
        int profit;

        public Pair(int time, int profit) {
            this.time = time;
            this.profit = profit;
        }


        @Override
        public int compareTo(Pair o) {
            return this.time - o.time;
        }
    }
}
