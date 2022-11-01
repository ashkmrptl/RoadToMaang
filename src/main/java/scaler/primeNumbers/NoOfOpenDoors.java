package scaler.primeNumbers;

/**
 * Given an integer A, which denotes the number of doors in a row numbered 1 to A. All the doors are closed initially.
 * <p>
 * A person moves to and fro, changing the states of the doors as follows: the person opens a door that is already closed and closes a door that is already opened.
 * <p>
 * In the first go, he/she alters the states of doors numbered 1, 2, 3, … , A.
 * In the second go, he/she alters the states of doors numbered 2, 4, 6 ….
 * In the third go, he/she alters the states of doors numbered 3, 6, 9 …
 * This continues till the A'th go in, which you alter the state of the door numbered A.
 * <p>
 * Find and return the number of open doors at the end of the procedure.
 */
public class NoOfOpenDoors {
    public static void main(String[] args) {
        System.out.println(solve(5));
        System.out.println(solve(6));
    }

    //Approach: Sieve can be applied
    private static int solve(int A) {
        int n = A + 1;
        int[] doors = new int[n];

        for (int i = 1; i <= A; i++) {
            for (int j = i; j < n; j += i) {
                doors[j] = doors[j] == 1 ? 0 : 1;
            }
        }

        int count = 0;
        for (int i = 1; i < n; i++) {
            if (doors[i] == 1) {
                count++;
            }
        }

        return count;
    }
}
