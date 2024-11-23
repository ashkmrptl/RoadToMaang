package companies.walmart;

import java.util.*;

public class FindKPairsWithSmallestSums {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 5, 6};
        int[] nums2 = new int[]{3, 5, 7, 9};
        System.out.println(kSmallestPairs(nums1, nums2, 20));

        nums1 = new int[]{1, 1, 2};
        nums2 = new int[]{1, 2, 3};
        System.out.println(kSmallestPairs(nums1, nums2, 2));
    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        final List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        // Min-heap to store elements in the form (sum, i, j)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize the heap with pairs (nums1[0] + nums2[j], 0, j)
        for (int j = 0; j < Math.min(nums2.length, k); j++) {
            minHeap.offer(new int[]{nums1[0] + nums2[j], 0, j});
        }

        // Extract the k smallest pairs
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int i = curr[1], j = curr[2];
            result.add(Arrays.asList(nums1[i], nums2[j]));

            // If there's a next element in nums1, push the new pair (nums1[i + 1] + nums2[j], i + 1, j)
            if (i + 1 < nums1.length) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
            }
        }

        return result;
    }
}
