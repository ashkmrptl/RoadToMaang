package companies.walmart;

/**
 * 1910. Remove All Occurrences of a Substring
 * https://leetcode.com/problems/remove-all-occurrences-of-a-substring/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class RemoveAllOccurrencesOfAString {
    public static void main(String[] args) {
        System.out.println(removeOccurrances("daabcbaabcbc", "abc"));
    }

    private static String removeOccurrances(String s, String part) {
        final char[] arr = new char[s.length()];

        int index = 0;
        int partLength = part.length();

        for (int i = 0; i < s.length(); i++) {
            arr[index] = s.charAt(i);
            index++;

            if (index >= partLength) {
                boolean matched = true;

                for (int j = 0; j < partLength; j++) {
                    if (arr[index - partLength + j] != part.charAt(j)) {
                        matched = false;
                        break;
                    }
                }

                if (matched) {
                    index = index - partLength;
                }
            }
        }

        return new String(arr, 0, index);
    }

    public static String removeOccurrences_1(String s, String part) {
        if (part.length() > s.length()) {
            return s;
        }

        String temp = s;
        while (true) {
            int length = temp.length();
            temp = searchAndRemove(temp, part);
            if (length == temp.length()) {
                return temp;
            }
        }
    }

    private static String searchAndRemove(String s, String part) {
        int i = 0;

        while (i < s.length() && i + part.length() <= s.length()) {
            int start = i;
            int end = i + part.length() - 1;

            boolean matched = true;

            int partStart = 0;
            while (start <= end) {
                if (s.charAt(start) != part.charAt(partStart)) {
                    matched = false;
                    break;
                }
                start++;
                partStart++;
            }

            if (matched) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < s.length(); k++) {
                    if (k >= i && k <= i + part.length() - 1) {
                        continue;
                    }
                    sb.append(s.charAt(k));
                }
                return sb.toString();
            }

            i++;
        }

        return s;
    }

}
