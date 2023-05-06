package scaler.heaps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given N bags, each bag contains Bi chocolates. There is a kid and a magician.
 * In a unit of time, the kid can choose any bag i, and eat Bi chocolates from it, then the magician will fill the ith bag with floor(Bi/2) chocolates.
 *
 * Find the maximum number of chocolates that the kid can eat in A units of time.
 *
 * NOTE:
 *
 * floor() function returns the largest integer less than or equal to a given number.
 * Return your answer modulo 109+7
 */
public class MagicianAndChocolates {
    public static void main(String[] args) {
        ArrayList<Integer> B = new ArrayList<>();
        B.add(6);
        B.add(5);
        System.out.println(solve(3, B));

        B = new ArrayList<>();
        B.add(2);
        B.add(4);
        B.add(6);
        B.add(8);
        B.add(10);
        System.out.println(solve(5, B));
    }

    private static int solve(int A, ArrayList<Integer> B) {
        final int mod = 1000 * 1000 * 1000 + 7;
        long ans = 0;

        final Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        maxHeap.addAll(B);

        for (int i = 0; i < A && !maxHeap.isEmpty(); i++) {
            int num = maxHeap.poll();
            ans += num;

            double chocToAdd = Math.floor(num/2);
            if (chocToAdd > 0) {
                maxHeap.add((int) chocToAdd);
            }
        }

        return (int) (ans % mod);
    }
}
