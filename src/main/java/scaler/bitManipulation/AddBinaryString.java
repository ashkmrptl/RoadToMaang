package scaler.bitManipulation;

/**
 * Given two binary strings, return their sum (also a binary string).
 * Example:
 * <p>
 * a = "100"
 * <p>
 * b = "11"
 * Return a + b = "111".
 */
public class AddBinaryString {
    public static void main(String[] args) {
        String a = "000";
        String b = "000";

        System.out.println(add(a, b));
        System.out.println("----------------------------------");

        a = "10001100010111000101100010100110001001101010000010011010";
        b = "101111000100100100111110010010101110101001100100101001111010011000000110";
        System.out.println(add(a, b));

        a = "1010110111001101101000";
        b = "1000011011000000111100110";
        System.out.println(solve(a, b));
    }

    private static String solve(String A, String  B) {
        StringBuilder ans = new StringBuilder();
        int sum = 0;
        int i = A.length() - 1;
        int j = B.length() - 1;

        while(i >= 0 || j >= 0 || sum == 1) {
            sum += (i >= 0) ? A.charAt(i) - '0' : '0';
            sum += (j >= 0) ? B.charAt(j) - '0' : '0';

            ans.append(sum % 2);

            sum = sum / 2;
            i--;
            j--;
        }

        return ans.toString().length() == 0 ? "0" : ans.reverse().toString();
    }

    private static String add(String a, String b) {
        /*if (a.charAt(0) == '0' && b.charAt(0) == '0') {
            return "0";
        }*/
        StringBuilder result = new StringBuilder();

        int s = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1) {

            s += ((i >= 0) ? a.charAt(i) - '0' : 0);
            s += ((j >= 0) ? b.charAt(j) - '0' : 0);

            result.append((char) (s % 2 + '0'));

            s /= 2;

            i--;
            j--;
        }

        int start = result.length() - 1;

        while (start >= 0 && result.charAt(start) == '0') {
            start--;
        }

        if (start != result.length() - 1) {
            result.delete(start + 1, result.length());
        }

        String ans = result.reverse().toString();

        return ans.isBlank() ? "0" : ans;
    }
}
