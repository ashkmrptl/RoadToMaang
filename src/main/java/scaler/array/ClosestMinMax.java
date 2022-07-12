package scaler.array;

/**
 * Problem Description
 * Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
 * and at least one occurrence of the minimum value of the array.
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 2000
 * <p>
 * Input Format
 * First and only argument is vector A
 * <p>
 * Output Format
 * Return the length of the smallest sub-array which has at least one occurrence of minimum and maximum element of the array
 * <p>
 * Example Input
 * Input 1:
 * A = [1, 3]
 * <p>
 * Input 2:
 * A = [2]
 * <p>
 * Example Output
 * Output 1:
 * 2
 * <p>
 * Output 2:
 * 1
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Only choice is to take both elements.
 * Explanation 2:
 * <p>
 * Take the whole array.
 */
public class ClosestMinMax {
    public static void main(String[] args) {
        final int[] array = new int[]{1, 3, 4, 6, 8, 5, 5, 1, 5, 2};

        System.out.println("closest min max length : " + findClosestMinAndMaxBruteForce(array));
        System.out.println("closest min max length optimized : " + findClosestMinAndMaxOptimized(array));

        final int[] array1 = new int[]{5, 5, 5, 5, 5, 5, 5, 5};

        System.out.println("closest min max length : " + findClosestMinAndMaxBruteForce(array1));
        System.out.println("closest min max length optimized : " + findClosestMinAndMaxOptimized(array1));
    }

    private static int findClosestMinAndMaxOptimized(final int[] array) {
        int shortestRange = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int j : array) {
            min = Math.min(j, min);
            max = Math.max(j, max);
        }

        if (min == max) {
            return 1;
        }

        int closestMax = Integer.MAX_VALUE;
        int closestMin = Integer.MAX_VALUE;

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min) {
                if (closestMax != Integer.MAX_VALUE) {
                    shortestRange = Math.min(shortestRange, (closestMax - i + 1));
                }
                closestMin = i;
            } else if (array[i] == max) {
                if (closestMin != Integer.MAX_VALUE) {
                    shortestRange = Math.min(shortestRange, (closestMin - i + 1));
                }
                closestMax = i;
            }

        }

        return shortestRange;
    }

    /**
     * In this approach we iterate the whole array for each min and max of the array.
     * Then if a max found for min, we calculate the length and break
     * if a min found for max, we calculate the length and break
     * Then we take the minimum of shortestRange and the length calculated
     * <p>
     * TC : O(n^2)
     *
     * @param array input array
     * @return length of closest minimum and maximum
     */
    private static int findClosestMinAndMaxBruteForce(final int[] array) {
        int shortestRange = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int j : array) {
            max = Math.max(j, max);
            min = Math.min(j, min);
        }

        if (min == max) {
            return 1;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                for (int j = i; j < array.length; j++) {
                    if (array[j] == max) {
                        shortestRange = Math.min(shortestRange, (j - i + 1));
                        break;
                    }
                }
            } else if (array[i] == max) {
                for (int j = i; j < array.length; j++) {
                    if (array[j] == min) {
                        shortestRange = Math.min(shortestRange, (j - i + 1));
                        break;
                    }
                }
            }
        }

        return shortestRange;
    }
}
