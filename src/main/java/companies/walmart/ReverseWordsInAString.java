package companies.walmart;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(reverseWords(s));

        s = "  hello world  ";
        System.out.println(reverseWords(s));

        s = "a good   example";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {
        s = s.trim();
        //Reverse the entire String
        s = reverse(0, s.length() - 1, s);

        //Reverse the words
        final String[] words = s.split(" ");

        final StringBuilder ans = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < 1) {
                continue;
            }
            ans.append(reverse(0, words[i].length() - 1, words[i]));
            if (i < words.length - 1) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    private static String reverse(int start, int end, String s) {
        char[] arr = s.toCharArray();

        for (int i = start, j = end; i <= (start + end) / 2; i++, j--) {
            char left = arr[i];
            arr[i] = arr[j];
            arr[j] = left;
        }

        return new String(arr);
    }
}
