package companies.walmart;

/**
 * 696. Count Binary Substrings
 * https://leetcode.com/problems/count-binary-substrings/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */

public class CountBinarySubstrings {
    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("10101"));
    }

    public static int countBinarySubstrings(String s) {
        int i = 0;
        int j = 1;
        int count = 0;

        while (j <= s.length() - 1) {
            if (s.charAt(i) != s.charAt(j)) {
                int l = i;
                int r = j;
                if (s.charAt(l) == '0') {//Scan for zeros on left and ones on right
                    while (l >= 0 && (r <= s.length() - 1) && s.charAt(l) == '0' && s.charAt(r) == '1') {
                        count++;
                        l--;
                        r++;
                    }
                } else {//Scan for ones on left and zeros on right
                    while (l >= 0 && (r <= s.length() - 1) && s.charAt(l) == '1' && s.charAt(r) == '0') {
                        count++;
                        l--;
                        r++;
                    }
                }
            }
            i++;
            j++;
        }

        return count;
    }
}
