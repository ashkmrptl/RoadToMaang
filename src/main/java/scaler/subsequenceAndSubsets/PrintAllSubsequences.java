package scaler.subsequenceAndSubsets;

public class PrintAllSubsequences {
    public static void main(String[] args) {
        int[] A = new int[]{3, 4, 5};
        solve(A);

        A = new int[]{3, 4, 5, 6};
        solve(A);
    }

    private static void solve(int[] A) {
        for (int i = 0; i < Math.pow(2, A.length); i++) {
            StringBuilder subsequence = new StringBuilder();

            for (int j = 0; j < A.length; j++) {
                if (((i & (1 << j))) != 0) {
                    subsequence.append(A[j]);
                }
            }

            System.out.println(subsequence.toString());
        }
    }
}
