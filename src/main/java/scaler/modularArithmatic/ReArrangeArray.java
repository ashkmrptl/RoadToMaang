package scaler.modularArithmatic;

import java.util.Arrays;

public class ReArrangeArray {
    public static void main(String[] args) {
        int[] A = new int[]{0, 6, 1, 3, 2, 4, 5};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(int[] A) {
        int n = A.length;
        //Step 1: multiply n to all elements
        for (int i = 0; i < n; i++) {
            A[i] *= n;
        }

        //Step 2: Add remainder to all elements
        for (int i = 0; i < n; i++) {
            int index = A[i] / n;
            int num = A[index] / n;
            A[i] = A[i] + num;
        }

        //Step 3: calculate remainder for each element to get the answer
        for (int i = 0; i < n; i++) {
            A[i] %= n;
        }

        return A;
    }
}
