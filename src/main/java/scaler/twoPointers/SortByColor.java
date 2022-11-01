package scaler.twoPointers;

import java.util.Arrays;

public class SortByColor {
    public static void main(String[] args) {
        int[] A = new int[]{0, 1, 2, 0, 1, 2};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(int[] A) {
        int n = A.length;
        int lo = 0;
        int hi = n - 1;
        int mid = 0, temp;

        while (mid <= hi) {
            switch (A[mid]) {
                case 0: {
                    temp = A[lo];
                    A[lo] = A[mid];
                    A[mid] = temp;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = A[mid];
                    A[mid] = A[hi];
                    A[hi] = temp;
                    hi--;
                    break;
                }
            }
        }
        return A;
    }
}
