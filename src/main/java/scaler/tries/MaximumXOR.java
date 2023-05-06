package scaler.tries;

/**
 * Given an array of integers A, find and return the maximum result of A[i] XOR A[j], where i, j are the indexes of the array.
 */
public class MaximumXOR {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        System.out.println(solve(A));

        A = new int[]{5, 17, 100, 11};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int ans = 0;
        final Trie root = createTrie(A);

        for (int i = 0; i < A.length; i++) {
            int xor = 0;
            Trie current = root;

            for (int j = 31; j >= 0; j--) {
                if ((A[i] & (1 << j)) != 0) {//If jth digit is zero, look for one
                    if (current.zero != null) {
                        xor += (1 << j);//same as xor |= (1 << j)
                        current = current.zero;
                    } else {
                        current = current.one;
                    }
                } else {//If jth digit is one, look for zero
                    if (current.one != null) {
                        xor += (1 << j);//same as xor |= (1 << j)
                        current = current.one;
                    } else {
                        current = current.zero;
                    }
                }
                ans = Math.max(ans, xor);
            }
        }

        return ans;
    }

    private static Trie createTrie(int[] A) {
        final Trie root = new Trie(null);

        for (int i = 0; i < A.length; i++) {
            final String str = String.format("%32s", Integer.toBinaryString(A[i])).replaceAll(" ", "0");

            Trie current = root;

            final char[] array = str.toCharArray();
            for (int j = 0; j < array.length; j++) {
                if (array[j] == '0') {
                    if (current.zero == null) {
                        current.zero = new Trie(0);
                    }
                    current = current.zero;
                } else if (array[j] == '1') {
                    if (current.one == null) {
                        current.one = new Trie(1);
                    }
                    current = current.one;
                }
            }
        }

        return root;
    }

    private static class Trie {
        Integer digit;
        Trie zero;
        Trie one;

        public Trie(Integer digit) {
            this.digit = digit;
            zero = null;
            one = null;
        }
    }
}
