package companies.walmart;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1, 3};
        int[] B = new int[]{2};

        System.out.println(findMedianSortedArrays(A, B));

        A = new int[]{1, 2};
        B = new int[]{3, 4};

        System.out.println(findMedianSortedArrays(A, B));
    }

    private static Double findMedianSortedArrays(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n > m)
            return findMedianSortedArrays(B, A); // Swapping to make A smaller

        int start = 0;
        int end = n;
        int midInMergedArray = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;

            int leftASize = mid;
            int leftBSize = midInMergedArray - mid;

            // checking overflow of indices
            int leftA = (leftASize > 0) ? A[leftASize - 1] : Integer.MIN_VALUE;
            int leftB = (leftBSize > 0) ? B[leftBSize - 1] : Integer.MIN_VALUE;
            int rightA = (leftASize < n) ? A[leftASize] : Integer.MAX_VALUE;
            int rightB = (leftBSize < m) ? B[leftBSize] : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0) {
                    return ((double) Math.max(leftA, leftB) + (double) Math.min(rightA, rightB)) / 2.0D;
                } else {
                    return (double) Math.max(leftA, leftB);
                }
            } else if (leftA > rightB) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return 0.0;
    }
}
