package scaler.hashing;

import java.util.*;

/**
 * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
 * <p>
 * NOTE:
 * <p>
 * Each element in the result should appear as many times as it appears in both arrays.
 * The result can be in any order.
 */
public class CommonElements {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 2, 1};
        int[] B = new int[]{2, 3, 1, 2};

        System.out.println(Arrays.toString(solve(A, B)));

        A = new int[]{2, 1, 4, 10};
        B = new int[]{3, 6, 2, 10, 10};

        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(int[] A, int[] B) {
        final List<Integer> list = new ArrayList<>();
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                list.add(B[i]);

                if (map.get(B[i]) == 1) {
                    map.remove(B[i]);
                } else {
                    map.put(B[i], map.get(B[i]) - 1);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
