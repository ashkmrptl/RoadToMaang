package scaler.hashing;

import java.util.HashSet;
import java.util.Set;

public class DifferenceKInArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 3};
        int k = 2;
        System.out.println(solve(A, k));

        A = new int[]{34, 63, 64, 38, 65, 83, 50, 44, 18, 34, 71, 80, 22, 28, 20, 96, 33, 70, 0, 25, 64, 96, 18, 2, 53, 100, 24, 47, 98, 69, 60, 55, 8, 38, 72, 94, 18, 68, 0, 53, 18, 30, 86, 55, 13, 93, 15, 43, 73, 68, 29};
        k = 97;
        System.out.println(solve(A, k));

        A = new int[] {77, 28, 19, 21, 67, 15, 53, 25, 82, 52, 8, 94, 50, 30, 37, 39, 9, 43, 35, 48, 82, 53, 16, 20, 13, 95, 18, 67, 77, 12, 93, 0};
        k = 53;
        System.out.println(solve(A, k));

        A = new int[] {95, 97, 52, 51, 98, 41, 88, 12, 61, 32, 78, 9, 51, 39, 28, 28};
        k = 43;
        System.out.println(solve(A, k));

        A = new int[] {11, 85, 100, 44, 3, 32, 96, 72, 93, 76, 67, 93, 63, 5, 10, 45, 99, 35, 13};
        k = 60;
        System.out.println(solve(A, k));

        A = new int[] {75, 99, 92, 86, 38, 17, 11, 57, 91, 19, 19, 70, 97, 47, 55, 70, 23, 97, 100, 21, 60, 81, 94, 61, 81, 63, 89};
        k = 33;
        System.out.println(solve(A, k));
    }

    private static int solve(final int[] A, final int k) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int diff = A[i] - k;
            int sum = A[i] + k;

            if (set.contains(diff) || set.contains(sum)) {
                return 1;
            } else {
                set.add(A[i]);
            }
        }

        return 0;
    }
}
