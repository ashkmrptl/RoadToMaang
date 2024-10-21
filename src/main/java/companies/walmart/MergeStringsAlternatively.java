package companies.walmart;

/**
 * 1768. Merge Strings Alternately
 * https://leetcode.com/problems/merge-strings-alternately/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class MergeStringsAlternatively {
    public static void main(String[] args) {
        System.out.println(mergeAlternatively("ab", "pqrs"));
        System.out.println(mergeAlternatively("abcd", "pq"));
    }

    private static String mergeAlternatively(String word1, String word2) {
        int i = 0;
        int j = 0;

        final StringBuilder sb = new StringBuilder();

        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i++)).append(word2.charAt(j++));
        }

        if (i < word1.length()) {
            while (i < word1.length()) {
                sb.append(word1.charAt(i++));
            }
        }

        if (j < word2.length()) {
            while (j < word2.length()) {
                sb.append(word2.charAt(j++));
            }
        }

        return sb.toString();
    }
}
