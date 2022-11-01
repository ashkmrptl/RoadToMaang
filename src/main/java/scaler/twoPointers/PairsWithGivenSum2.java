package scaler.twoPointers;

public class PairsWithGivenSum2 {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 1};
        System.out.println(solve(A, 2));

        A = new int[]{2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10};
        System.out.println(solve(A, 11));

        A = new int[]{2, 2, 3, 4, 4, 5, 6, 7, 10};
        System.out.println(solve(A, 8));
    }

    private static int solve(int[] A, int B) {
        long count = 0;

        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            long x = A[i];
            long y = A[j];

            long sum = x + y;
            if (sum == B) {

                long xCount = 0;
                while (i < A.length && A[i] == x) {
                    i++;
                    xCount++;
                }

                long yCount = 0;
                while (j >= 0 && A[j] == y) {
                    j--;
                    yCount++;
                }

                if (x == y) {
                    count += (((xCount) * (xCount - 1)) / 2);
                } else {
                    count += (xCount * yCount);
                }
            } else if (sum < B) {
                i++;
            } else {
                j--;
            }
        }

        return (int) (count % 1000000007);
    }
}
