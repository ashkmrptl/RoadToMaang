package scaler.stack;

import java.util.Stack;

/**
 * Given an array of integers A.
 * value of a array = max(array) - min(array).
 * Calculate and return the sum of values of all possible sub-arrays of A modulo 109+7.
 */
public class MaxAndMin {
    public static void main(String[] args) {
        int[] A = new int[]{4, 7, 3, 8};
        System.out.println(solve(A));

        A = new int[]{5, 4, 5};
        System.out.println(solve(A));

        A = new int[]{994390, 986616, 976849, 979707, 950477, 968402, 992171, 937674, 933065, 960863, 980981, 937319, 951236, 959547, 991052, 991799, 992213, 941294, 978103, 997198, 960759, 988476, 963517, 980366, 921767, 979757, 977912, 983761, 981869, 947454, 930202, 999086, 973538, 999798, 996446, 944001, 974217, 951595, 942688, 975075, 970973, 970130, 897109, 927660, 862233, 997130, 986068, 954098, 978175, 889682, 988973, 996036, 969675, 985751, 977724, 881538, 988613, 924230, 906475, 915565, 986952, 975702, 994316, 964011, 986848, 983699, 949076, 989673, 981788, 929094, 988310, 926471, 994763, 999736, 980762, 973560, 996622, 934475, 998365, 966255, 998697, 998700, 911868, 983245, 996382, 996992, 953142, 994104, 987303, 853837, 960626, 904203, 998063, 977596, 977868, 996012, 946345, 949255, 988138, 996298, 954933, 965036, 886976, 998628, 990878, 953725, 916744, 985233, 919661, 970903, 986066};
        System.out.println(solve(A));
    }

    /**
     * Approach: We have to use Nearest MIN and MAX array.(The following works only with distinct elements)
     * step 1: Calculate the nearest min and nearest max array with index.
     * step 2: Iterate over the elements of the array
     * for every element
     * find the index of the left and right nearest max and min using the nearest min and nearest max array.
     * step 3: count the no of sub-arrays where A[i] is max and A[i] is min by (i - a) * (b - i)
     * a and b are index of the nearest left and right max/min elements respectively
     * step 4: find total sum of max and total sum of min. Then return total sum of max - total sum of min
     * <p>
     * Approach: with duplicate elements
     * The nearest min and nearest max arrays calculations has to be tweaked a bit
     */
    private static int solve(int[] A) {
        int n = A.length;
        int mod = 1000000007;

        int[] leftSmall = new int[n];
        int[] rightSmall = new int[n];

        int[] leftLarge = new int[n];
        int[] rightLarge = new int[n];

        for (int i = 0; i < n; i++) {
            leftSmall[i] = -1;
            leftLarge[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            rightSmall[i] = n;
            rightLarge[i] = n;
        }

        //Calculate leftSmall and leftLarge array
        Stack<Integer> stackSmall = new Stack<>();
        Stack<Integer> stackLarge = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stackSmall.isEmpty() && A[i] <= A[stackSmall.peek()]) {
                stackSmall.pop();
            }
            if (!stackSmall.isEmpty()) {
                leftSmall[i] = stackSmall.peek();
            }

            stackSmall.add(i);

            while (!stackLarge.isEmpty() && A[i] >= A[stackLarge.peek()]) {
                stackLarge.pop();
            }
            if (!stackLarge.isEmpty()) {
                leftLarge[i] = stackLarge.peek();
            }

            stackLarge.add(i);
        }

        //Calculate rightSmall and rightLarge array
        stackSmall = new Stack<>();
        stackLarge = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stackSmall.isEmpty() && A[i] <= A[stackSmall.peek()]) {
                stackSmall.pop();
            }
            if (!stackSmall.isEmpty()) {
                rightSmall[i] = stackSmall.peek();
            }

            stackSmall.add(i);

            while (!stackLarge.isEmpty() && A[i] >= A[stackLarge.peek()]) {
                stackLarge.pop();
            }
            if (!stackLarge.isEmpty()) {
                rightLarge[i] = stackLarge.peek();
            }

            stackLarge.add(i);
        }

        long res = 0;
        for (int i = 0; i < A.length; i++) {
            long max = subArraysWithCurrent(leftLarge[i], i, rightLarge[i]);
            long min = subArraysWithCurrent(leftSmall[i], i, rightSmall[i]);
            long contribution = ((max - min) * A[i]) % mod;
            res = (res + contribution) % mod;
            res = (res + mod) % mod;
        }
        return (int) res;
    }

    private static long subArraysWithCurrent(long leftExclusive, long current, long rightExclusive) {
        return (current - leftExclusive) * (rightExclusive - current);
    }
}
