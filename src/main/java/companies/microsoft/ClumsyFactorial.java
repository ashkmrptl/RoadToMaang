package companies.microsoft;

public class ClumsyFactorial {
    public static void main(String[] args) {
        //System.out.println(clumsy(4));
        System.out.println(clumsy(10));
    }

    private static int clumsy(int n) {
        int ans = 0;
        int sign = 1;

        for (int i = n; i >= 0; i -= 4) {
            long temp = i;
            if (i - 1 > 0) {
                temp *= (i - 1);
            }
            if (i - 2 > 0) {
                temp /= (i - 2);
            }

            ans += sign * temp;
            if (i - 3 > 0) {
                ans += (i - 3);
            }
            sign = -1;
        }

        return ans;
    }
}
