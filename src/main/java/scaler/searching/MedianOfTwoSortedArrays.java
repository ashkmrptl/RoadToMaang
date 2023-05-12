package scaler.searching;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1, 4, 5};
        int[] B = new int[]{2, 3};

        System.out.println(findMedian(A, B));

        A = new int[] {1, 3};
        B = new int[] {2};

        System.out.println(findMedian(A, B));
    }

    private static double findMedian(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n > m)
            return findMedian(B, A); // Swapping to make A smaller

        int start = 0;
        int end = n;
        int midInMergedArray = (n + m + 1) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;

            int leftAsize = mid;
            int leftBsize = midInMergedArray - mid;

            int leftA = (leftAsize > 0) ? A[leftAsize - 1] : Integer.MIN_VALUE; // checking overflow of indices
            int leftB = (leftBsize > 0) ? B[leftBsize - 1] : Integer.MIN_VALUE;
            int rightA = (leftAsize < n) ? A[leftAsize] : Integer.MAX_VALUE;
            int rightB = (leftBsize < m) ? B[leftBsize] : Integer.MAX_VALUE;

            // if correct partition is done
            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                } else {
                    return Math.max(leftA, leftB);
                }
            } else if (leftA > rightB) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return 0.0;
    }
}

