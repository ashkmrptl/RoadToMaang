package scaler.array;

public class MinimumSwapsKTogether {
    public static void main(String[] args) {
        int[] A = new int[]{52, 7, 93, 47, 68, 26, 51, 44, 5, 41, 88, 19, 78, 38, 17, 13, 24, 74, 92, 5, 84, 27, 48, 49, 37, 59, 3, 56, 79, 26, 55, 60, 16, 83, 63, 40, 55, 9, 96, 29, 7, 22, 27, 74, 78, 38, 11, 65, 29, 52, 36, 21, 94, 46, 52, 47, 87, 33, 87, 70};
        int B = 19;
        //System.out.println(solve(A, B));
        //System.out.println(solve1(A, B));

        A = new int[]{1, 12, 10, 3, 14, 10, 5};
        B = 8;
        //System.out.println(solve(A, B));
        //System.out.println(solve1(A, B));

        A = new int[]{5, 17, 100, 11};
        B = 20;
        //System.out.println(solve(A, B));
        System.out.println(solve1(A, B));
    }

    private static int solve(int[] A, int B) {
        int windowSize = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                windowSize++;
            }
        }

        if (windowSize == 0 || windowSize == 1 || windowSize == A.length) {
            return 0;
        }

        //SlidingWindow
        //Counting no of elements <= B in the first window
        int left = 0;
        int right = windowSize - 1;

        int count = 0;
        int i = left;
        while (i <= right) {
            if (A[i] <= B) {
                count++;
            }
            i++;
        }
        left++;
        right++;

        int max = count;
        while (right < A.length) {
            int elementRemoved = A[left - 1];
            int elementAdded = A[right];

            if (elementRemoved <= B && count != 0) {
                count--;
            }

            if (elementAdded <= B) {
                count++;
            }

            left++;
            right++;
            max = Math.max(max, count);
        }

        return windowSize - max;

    }

    public static int solve1(int[] A, int B) {
        int k = 0;//Window size
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= B) {
                k++;
            }
        }

        if (k == 0 || k == 1 || k == A.length) {
            return 0;
        }

        int count = 0;

        int left = 0;
        int right = k - 1;
        for (int i = left; i <= right; i++) {
            if (A[i] <= B) {
                count++;
            }
        }
        left++;
        right++;

        int maxCount = count;

        while (right < A.length) {
            int elemAdded = A[right];
            int eleRemoved = A[left - 1];

            if (elemAdded <= B) {
                count++;
            }

            if (eleRemoved <= B && count != 0) {
                count--;
            }

            maxCount = Math.max(maxCount, count);

            left++;
            right++;
        }

        return k - maxCount;
    }
}
