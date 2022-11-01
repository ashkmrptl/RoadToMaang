package scaler.searching;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] A = new int[] {1, 2, 3, 4, 5};
        int B = 3;

        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int B) {
        int low = 1;
        int high = A[A.length - 1] - A[0];

        int ans = 0;

        while(low <= high) {
            int mid = (low + high) / 2;

            if (check(A, mid, B)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private static boolean check(int[] A, int distance, int B) {
        int cow = 1;
        int lastLocation = A[0];

        for (int i = 1; i < A.length; i++) {
            if(A[i] - lastLocation >= distance) {
                cow++;
                lastLocation = A[i];
                if(cow == B) {
                    return true;
                }
            }
        }
        return false;
    }
}
