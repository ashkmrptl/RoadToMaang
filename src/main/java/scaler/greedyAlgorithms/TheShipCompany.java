package scaler.greedyAlgorithms;

import java.util.Collections;
import java.util.PriorityQueue;

public class TheShipCompany {
    //Copied from discussion

    private static int[] solve(int A, int B, int[] C) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < B; i++) {
            maxHeap.add(C[i]);
            minHeap.add(C[i]);
        }
        int[] ans = new int[2];
        int maxEarn = 0;
        int minEarn = 0;
        while (A-- > 0 && !maxHeap.isEmpty() && !minHeap.isEmpty()) {
            int a = maxHeap.remove();
            int b = minHeap.remove();
            maxEarn += a;
            minEarn += b;
            if (a - 1 > 0) {
                maxHeap.add(a - 1);
            }
            if (b - 1 > 0) {
                minHeap.add(b - 1);
            }
        }
        ans[0] = maxEarn;
        ans[1] = minEarn;
        return ans;
    }
}
