package companies.walmart;

public class ReverseWordsInAStringIII {
    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));

        System.out.println(reverseWords("Mr Ding"));
    }

    private static String reverseWords(String s) {
        //Reverse each words in place
        int l = 0;
        int r = 0;

        while (r < s.length()) {
            while (r < s.length() && s.charAt(r) != ' ') {
                r++;
            }

            s = reverse(s, l, r - 1);

            l = r + 1;
            r = l;
        }

        return s;
    }

    private static String reverse(String s, int l, int r) {
        char[] arr = s.toCharArray();

        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        return new String(arr);
    }
}
