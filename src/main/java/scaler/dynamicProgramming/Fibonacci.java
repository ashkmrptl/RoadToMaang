package scaler.dynamicProgramming;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 44;
        int[] array = new int[n + 1];
        Arrays.fill(array, -1);

        System.out.println(fib(n, array));
        System.out.println(iterative(n, array));
    }

    //Following is the recursive way(Bottom Up approach)
    private static int fib(int n, int[] array) {
        //Step 1: Base condition
        if (n <= 1) {
            return n;
        }

        //Step 2: Check if the result already exists
        if (array[n] != -1) {
            return array[n];
        }

        //Step 3: Calculate the answer for the sub-problem and update the array
        int ans = fib(n - 1, array) + fib(n - 2, array);
        array[n] = ans;

        return ans;
    }

    //Following is the iterative way(Top Down approach)
    private static int iterative(int n, int[] array) {
        if (n <= 1) {
            return n;
        }
        //We know the fibonacci of 0 and 1 are respectively 0 and 1
        array[0] = 0;
        array[1] = 1;

        int a = array[0];
        int b = array[1];

        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;

            array[i] = c;
        }

        return array[n];
    }
}
