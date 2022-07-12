package scaler.array;

/**
 * A wire connects N light bulbs.
 * Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.
 * Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.
 * You can press the same switch multiple times.
 * <p>
 * Note: 0 represents the bulb is off and 1 represents the bulb is on.
 * <p>
 * Problem Constraints
 * 1 <= N <= 5×105
 * 0 <= A[i] <= 1
 * <p>
 * Input Format
 * The first and the only argument contains an integer array A, of size N.
 * <p>
 * Output Format
 * Return an integer representing the minimum number of switches required.
 * <p>
 * Example Input
 * Input 1:
 * A = [0, 1, 0, 1]
 * <p>
 * Input 2:
 * A = [1, 1, 1, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 4
 * <p>
 * Output 2:
 * 0
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * press switch 0 : [1 0 1 0]
 * press switch 1 : [1 1 0 1]
 * press switch 2 : [1 1 1 0]
 * press switch 3 : [1 1 1 1]
 * Explanation 2:
 * <p>
 * There is no need to turn any switches as all the bulbs are already on.
 */
public class Bubls {
    public static void main(String[] args) {
        final int[][] A = new int[][] {{0, 1, 0, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}, {0, 0, 1, 1}, {1, 1, 0, 0}};
        for(final int[] array : A) {
            System.out.println("Minimum press required = " + findMinimumSwitchPressBruteForce(array));
        }
    }

    private static int findMinimumSwitchPressBruteForce(final int[] array) {
        int minimumPress = 0;

        boolean toggle;
        if (array[0] == 1) {
            toggle = false;
        } else {
            toggle = true;
            minimumPress++;
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] == 1 && toggle) {
                minimumPress++;
                toggle = false;
                continue;
            }

            if (array[i] == 0 && !toggle) {
                minimumPress++;
                toggle = true;
            }
        }

        return minimumPress;
    }
}
