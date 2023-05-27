package companies.cisco;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "42";
        System.out.println(myAtoi(s));

        s = "    -42";
        System.out.println(myAtoi(s));

        s = "4193 with words";
        System.out.println(myAtoi(s));

        s = "3.1234";
        System.out.println(myAtoi(s));

        s = "3.1234 hey stupid";
        System.out.println(myAtoi(s));

        s = "you really are stupid 324";
        System.out.println(myAtoi(s));
    }

    private static int myAtoi(String s) {
        if (s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        }
        int n = s.length();

        int i = 0;

        //Handle leading space characters
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        boolean positive = s.charAt(i) == '+';
        boolean negative = s.charAt(i) == '-';
        if (positive || negative) {
            i++;
        }

        double num = 0;
        while(i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            num = num*10 + (s.charAt(i)-'0');
            i++;
        }

        num = negative ? -num : num;
        num = (num > Integer.MAX_VALUE) ? Integer.MAX_VALUE : num;
        num = (num < Integer.MIN_VALUE) ? Integer.MIN_VALUE : num;
        return (int) num;
    }
}
