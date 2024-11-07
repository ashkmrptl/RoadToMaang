package scaler.strings;

//Reverse words of the given string
public class ReverseWords {
    public static void main(String[] args) {
        System.out.println(solve("Let's take LeetCode contest"));

        System.out.println(solve("Mr Ding"));
    }

    private static String solve(String str) {
        // Trimming to removing trailing spaces.
        str = str.trim();

        //Reverse the entire string to bring the words in required space
        str = reverse(str, 0, str.length() - 1);

        //Reverse the words to get back them in original form
        int i = 0;
        int j = 0;

        while (j < str.length()) {
            while (j < str.length() && str.charAt(j) != ' ') {
                j++;
            }
            str = reverse(str, i, j - 1);
            j++;
            i = j;
        }

        return str;
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
