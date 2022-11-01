package scaler.modularArithmatic;

/**
 * Given a number N in the format of array of digits. Find n % p.
 * <p>
 * 1 <= p <= 10^9
 * 1<= size <= 10^5
 */
public class ModuloOfNDigitsAsArray {
    public static void main(String[] args) {
        int B = 4;
        System.out.println("Mod is : " + mod("2134527", B));
        B = 93;
        System.out.println("Mod is : " + mod("878", B));

        String string = "6562800446546751053033681283622332585949169375825307419010747907087102529693988502714663897293527240363734284937813181135000995192664742291904645171438423695200374401117403";
        B = 36173;
        System.out.println("Mod is : " + mod(string, B));

        string = "6562800446546";
        B = 36173;
        System.out.println("Mod is : " + mod(string, B));
    }

    private static int mod(String A, int B) {
        long res = 0;

        for (int i = 0; i < A.length(); i++) {
            // subtracting with char '0' as the ASCII of zero is 48 and ASCII of num starts from 1->49, 2->50, 3->51 and so on
            res = ((res * 10) + (Integer.parseInt(String.valueOf(A.charAt(i))))) % B;
        }

        return (int)res;
    }
}
