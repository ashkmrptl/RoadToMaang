package companies.agoda;

/**
 * 2734. Lexicographically Smallest String After Substring Operation
 * https://leetcode.com/problems/lexicographically-smallest-string-after-substring-operation/description/?envType=company&envId=agoda&favoriteSlug=agoda-thirty-days
 */
public class LexicographicallySmallestStringAfterSubStringOperation {
    public static void main(String[] args) {
        System.out.println(smallestString("cbabc"));
        System.out.println(smallestString("aa"));
        System.out.println(smallestString("acbbc"));
        System.out.println(smallestString("leetcode"));
    }

    private static String smallestString(String s) {
        int i = 0;
        int n = s.length();

        char[] arr = s.toCharArray();

        while (i < n && arr[i] == 'a') {
            i++;
        }

        if (i == n) {
            arr[i - 1] = 'z';
            return String.valueOf(arr);
        }

        //Keep replacing chars until next 'a'
        while (i < n && arr[i] != 'a') {
            arr[i] = (char) (arr[i] - 1);
            i++;
        }

        return new String(arr);
    }
}

