package scaler.array;

public class SubArrayWithLeastAverage {
    public static void main(String[] args) {
        int B = 9;
        final int[] array = new int[]{20, 3, 13, 5, 10, 14, 8, 5, 11, 9, 1, 11};
        System.out.println(solve(array, B));
        System.out.println(solveOptimized(array, B));
    }

    private static int solveOptimized(int[] A, int B) {
        int currSum = 0;
        int currStartIndex = 0;

        for (int i = 0; i < B; i++) {
            currSum += A[i];
        }

        int minSum = currSum;

        for (int i = B; i < A.length; i++) {
            currSum = currSum + A[i] - A[i - B];
            if (currSum < minSum) {
                minSum = currSum;
                currStartIndex = i - B + 1;
            }
        }
        return currStartIndex;
    }

    public static int solve(int[] A, int B) {
        float avg = Float.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i <= A.length - B; i++) {
            int sum = 0;
            for (int j = i; j < i + B; j++) {
                sum += A[j];
            }
            float currAvg = ((float) sum / B);
            if (currAvg < avg) {
                avg = currAvg;
                minIndex = i;
            }
        }

        return minIndex;
    }
}
