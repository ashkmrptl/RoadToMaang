package scaler.searching;


public class AllocateBooks {
    public static void main(String[] args) {
        int[] A = new int[]{12, 34, 67, 90};
        int B = 2;
        System.out.println(solve(A, B));

        A = new int[] {53, 77, 8, 28, 33, 98, 81, 35, 13, 65, 14, 63, 36, 25, 69};

        B = 12;
        System.out.println(solve(A, B));
    }

    private static int solve(int[] A, int B) {
        if(B > A.length) {
            return -1;
        }
        int l = Integer.MIN_VALUE;
        int r = 0;

        for (int i = 0; i < A.length; i++) {
            l = Math.max(l, A[i]);
            r += A[i];
        }
        int ans = -1;
        while (l <= r) {
            int mid = (l + r) / 2;

            if (check(A, B, mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean check(int[] A, int B, int mid) {
        int students = 1;
        int pages = 0;

        for (int i = 0; i < A.length; i++) {
            if (pages + A[i] <= mid) {
                pages += A[i];
            } else if (A[i] <= mid) {
                students++;
                pages = A[i];
            } else {
                return false;
            }
        }

        if (students > B) {
            return false;
        } else {
            return true;
        }
    }
}
