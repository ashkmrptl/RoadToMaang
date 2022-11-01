package scaler.hashing;

import java.util.*;

public class CompareSortedSubArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1, 7, 11, 8, 11, 7, 1};
        int[][] B = new int[][]{{0, 2, 4, 6}};

        System.out.println(Arrays.toString(solve_bruteForce(A, B)));
        System.out.println(Arrays.toString(solve(A, B)));
        System.out.println(solve_fromHint(A, B));

        A = new int[]{1, 3, 2};
        B = new int[][]{{0, 1, 1, 2}};

        System.out.println(Arrays.toString(solve_bruteForce(A, B)));
        System.out.println(Arrays.toString(solve(A, B)));
        System.out.println(solve_fromHint(A, B));

        A = new int[]{6, 1, 3, 5, 7, 2, 1, 3, 7, 1, 5, 9};
        B = new int[][]{{1, 4, 7, 10}};

        System.out.println(Arrays.toString(solve_bruteForce(A, B)));
        System.out.println(Arrays.toString(solve(A, B)));
        System.out.println(solve_fromHint(A, B));
    }

    public static ArrayList<Integer> solve_fromHint(int[] A, int[][] B) {
        int n = A.length;
        Random rd = new Random();
        HashMap<Integer, Long> hm = new HashMap<>();
        HashSet<Long> used = new HashSet<>();
        long[] pf = new long[n + 1];
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(A[i])) {
                long hash = rd.nextLong();
                while (used.contains(hash)) {
                    hash = rd.nextLong();
                }
                hm.put(A[i], hash);
                used.add(hash);
            }
            pf[i + 1] = pf[i] + hm.get(A[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int[] tmp : B) {
            long val1 = pf[tmp[1] + 1] - pf[tmp[0]];
            long val2 = pf[tmp[3] + 1] - pf[tmp[2]];
            if (val1 == val2) {
                ans.add(1);
            } else {
                ans.add(0);
            }
        }
        return ans;
    }

    //This doesn't work- the test cases are passing but this is incorrect answer
    private static int[] solve(int[] A, int[][] B) {
        int[] result = new int[B.length];
        int diff;
        int a, b;
        int l1, r1, l2, r2;

        for (int i = 0; i < B.length; i++) {
            l1 = B[i][0];
            r1 = B[i][1];
            l2 = B[i][2];
            r2 = B[i][3];
            diff = r2 - l2 + 1;
            a = 0;
            b = 0;

            for (int j = l1; j <= r1; j++) {
                if (A[l2] == A[j]) {
                    l2++;
                    a++;
                } else if (A[r2] == A[j]) {
                    r2--;
                    b++;
                } else
                    break;
            }
            if (diff == a + b)
                result[i] = 1;
            else
                result[i] = 0;
        }
        return result;
    }

    private static int[] solve_bruteForce(int[] A, int[][] B) {
        int index = 0;
        int[] result = new int[B.length];

        for (int[] arr : B) {
            int l1 = arr[0];
            int r1 = arr[1];
            int l2 = arr[2];
            int r2 = arr[3];

            if (r1 - l1 != r2 - l2) {
                result[index] = 0;
                index++;
                continue;
            }

            final Map<Integer, Integer> map1 = new HashMap<>();
            final Map<Integer, Integer> map2 = new HashMap<>();

            for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
                if (map1.containsKey(A[i])) {
                    map1.put(A[i], map1.get(A[i]) + 1);
                } else {
                    map1.put(A[i], 1);
                }

                if (map2.containsKey(A[j])) {
                    map2.put(A[j], map2.get(A[j]) + 1);
                } else {
                    map2.put(A[j], 1);
                }
            }

            if (map1.size() != map2.size()) {
                result[index] = 0;
                index++;
            } else {
                boolean added = false;
                for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
                    int key = entry.getKey();
                    int value = entry.getValue();

                    if (!map2.containsKey(key) || value != map2.get(key)) {
                        added = true;
                        result[index] = 0;
                        index++;
                        break;
                    }
                }

                if (!added) {
                    result[index] = 1;
                    index++;
                }
            }
        }

        return result;
    }
}
