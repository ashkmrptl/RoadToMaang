package interviewbit.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem Description:
 * Given an array A of positive integers,call a (contiguous,not necessarily distinct) subarray of A good if the number
 * of different integers in that subarray is exactly B.
 * <p>
 * (For example: [1, 2, 3, 1, 2] has 3 different integers 1, 2 and 3)
 * Return the number of good subarrays of A.
 * <p>
 * Problem Constraints:
 * 1 <= |A| <= 40000
 * 1 <= A[i] <= |A|
 * 1 <= B <= |A|
 * <p>
 * Input Format:
 * The first argument given is the integer array A.
 * The second argument given is an integer B.
 * <p>
 * Output Format
 * Return an integer denoting the number of good subarrays of A.
 * <p>
 * Example Input :
 * Input 1:
 * A = [1, 2, 1, 2, 3]
 * B = 2
 * Input 2:
 * A = [1, 2, 1, 3, 4]
 * B = 3
 * <p>
 * Example Output
 * Output 1:
 * 7
 * Output 2:
 * 3
 * <p>
 * Example Explanation
 * Explanation 1:
 * Subarrays formed with exactly 2 different integers: [1, 2], [2, 1], [1, 2], [2, 3], [1, 2, 1], [2, 1, 2], [1, 2, 1, 2].
 * Explanation 2:
 * Subarrays formed with exactly 3 different integers: [1, 2, 1, 3], [2, 1, 3], [1, 3, 4].
 */
public class SubArrayWithDistinctIntegers {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 1, 2, 3};
        int B = 2;

        System.out.println(countSubArraysWithGivenNoOfDistinctIntegers(A, B));
        System.out.println(exactlyK(A, B));

        A = new int[]{1, 1, 1, 1, 1, 1};
        B = 1;

        System.out.println(countSubArraysWithGivenNoOfDistinctIntegers(A, B));
        System.out.println(exactlyK(A, B));

        A = new int[]{1, 2, 3, 4, 5, 6};
        B = 6;

        System.out.println(countSubArraysWithGivenNoOfDistinctIntegers(A, B));
        System.out.println(exactlyK(A, B));
    }

    //Optimized approach - Sliding window
    private static int exactlyK(int[] A, int B) {
        return (solve(A, B) - solve(A, B - 1));
    }

    private static int solve(final int[] A, final int B) {
        int count = 0;
        int n = A.length;

        int left = 0;
        int right = 0;

        final Map<Integer, Integer> map = new HashMap<>();
        while (right < n) {
            // Add element to map
            map.put(A[right], map.getOrDefault(A[right], 0) + 1);

            //Check count
            while (map.size() > B) {
                map.put(A[left], map.get(A[left]) - 1);
                if (map.get(A[left]) == 0) {
                    map.remove(A[left]);
                }
                left++;
            }

            count = count + (right - left + 1);
            right++;

        }

        return count;
    }

    // brute Force approach
    private static int countSubArraysWithGivenNoOfDistinctIntegers(final int[] A, final int B) {
        int n = A.length;

        int count = 0;
        Set<Integer> set;

        for (int i = 0; i < n; i++) {
            set = new HashSet<>();
            set.add(A[i]);
            for (int j = i; j < n; j++) {
                set.add(A[j]);
                if (set.size() > B) {
                    break;
                }

                if (set.size() == B) {
                    count++;
                }
            }
        }

        return count;
    }
}
