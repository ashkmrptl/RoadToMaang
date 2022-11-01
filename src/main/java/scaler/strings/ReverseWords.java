package scaler.strings;

//Reverse words of the given string
public class ReverseWords {
    public static void main(String[] args) {
        String A = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";

        System.out.println(solve(A));
    }

    private static String solve(String A) {
        // Trimming to removing trailing spaces.
        A = A.trim();

        //Reverse the entire string to bring the words in required space
        A = reverse(A, 0, A.length() - 1);

        //Reverse the words to get back them in original form
        int i = 0;
        int j = 0;

        while (j < A.length()) {
            while (j < A.length() && A.charAt(j) != ' ') {
                j++;
            }
            A = reverse(A, i, j - 1);
            j++;
            i = j;
        }

        return A;
    }

    private static String reverse(String s, int start, int end) {
        char[] A = s.toCharArray();

        while (start < end) {
            char temp = A[start];
            A[start] = A[end];
            A[end] = temp;
            start++;
            end--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            sb.append(A[i]);
        }

        return sb.toString();
    }

}
