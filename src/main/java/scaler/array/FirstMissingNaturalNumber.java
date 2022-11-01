package scaler.array;

public class FirstMissingNaturalNumber {
    public static void main(String[] args) {
        int[] A = new int[]{-3, 8, 1, 3, 2, 6};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int n = A.length;
        int i = 0;

        while (i < n) {
            if (A[i] >= 1 && A[i] <= n) {
                if (A[i] != i + 1 && A[A[i] - 1] != A[i]) {
                    int temp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = temp;
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }

        return n + 1;
    }
}
