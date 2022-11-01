package scaler.array;

import java.util.Arrays;

public class MinimumSwapsToSortArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 0};
        System.out.println(solve(A));
    }

    static class Pair implements Comparable<Pair> {
        Integer val;
        Integer index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.val, o.val);
        }
    }

    public static int solve(int[] A) {
        Pair[] pairs = new Pair[A.length];

        for (int i = 0; i < A.length; i++) {
            pairs[i] = new Pair(A[i], i);
        }

        Arrays.sort(pairs);

        int count = 0;
        int i = 0;
        while (i < A.length) {
            Pair pair = pairs[i];
            if (pair.index != i) {
                //Swap
                int indexToSwap = pair.index;
                pairs[i] = pairs[indexToSwap];
                pairs[indexToSwap] = pair;
                count++;
            } else {
                i++;
            }
        }

        return count;
    }
}
