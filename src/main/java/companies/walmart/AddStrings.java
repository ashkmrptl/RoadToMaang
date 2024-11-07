package companies.walmart;

/**
 * 415. Add Strings
 * https://leetcode.com/problems/add-strings/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class AddStrings {
    public static void main(String[] args) {
        System.out.println(addStrings("11", "123"));
        System.out.println(addStrings("456", "77"));
        System.out.println(addStrings("0", "0"));
    }

    private static String addStrings(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();

        int i = m - 1;
        int j = n - 1;

        final StringBuilder sb = new StringBuilder();

        int rem = 0;
        while (i >= 0 && j >= 0) {
            int a = Integer.parseInt(num1.charAt(i) + "");
            int b = Integer.parseInt(num2.charAt(j) + "");

            int sum = a + b + rem;
            int mod = sum % 10;
            rem = sum / 10;

            sb.insert(0, mod);
            i--;
            j--;
        }

        while (i >= 0) {
            int a = Integer.parseInt(num1.charAt(i) + "");

            int sum = a + rem;
            int mod = sum % 10;
            rem = sum / 10;

            sb.insert(0, mod);
            i--;
        }

        while (j >= 0) {
            int a = Integer.parseInt(num2.charAt(j) + "");

            int sum = a + rem;
            int mod = sum % 10;
            rem = sum / 10;

            sb.insert(0, mod);
            j--;
        }

        if (rem != 0) {
            sb.insert(0, rem);
        }

        return sb.toString();
    }
}
