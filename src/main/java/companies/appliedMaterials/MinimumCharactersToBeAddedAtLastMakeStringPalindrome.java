package companies.appliedMaterials;

public class MinimumCharactersToBeAddedAtLastMakeStringPalindrome {
    public static void main(String[] args) {
        //System.out.println(minChars("abc"));

        //System.out.println(minChars("axx"));

        System.out.println(minChars("aacd"));
    }

    //Following doesn't work
    private static int minChars(String str) {
        int i = 0;
        int j = str.length() - 1;

        int lastIndex = 0;
        while (i <= j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                j = str.length() - 1;
                lastIndex++;
                i = lastIndex;
            }
        }

        return lastIndex;

        /*int added = str.length() - 1 - lastIndex;
        return added;*/
    }
}
