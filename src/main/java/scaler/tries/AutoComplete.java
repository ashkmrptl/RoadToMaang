package scaler.tries;

import java.util.*;

/**
 * There is a dictionary A of N words, and ith word has a unique weight Wi.
 * Another string array B of size M contains the prefixes. For every prefix B[i], output at most 5 words from the dictionary A that start with the same prefix.
 * Output the words in decreasing order of their weight.
 * NOTE: If there is no word that starts with the given prefix output -1.
 */
public class AutoComplete {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output

        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();

        while (Q-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            String[] dictionary = new String[N];
            for (int i = 0; i < N; i++)
                dictionary[i] = sc.next();

            int[] weight = new int[N];
            for (int j = 0; j < N; j++)
                weight[j] = sc.nextInt();

            String[] search = new String[M];
            for (int k = 0; k < M; k++)
                search[k] = sc.next();

            Tries root = new Tries();
            insertIntoTries(root, dictionary, weight);
            searchOnTries(root, dictionary, search);
        }
    }

    private static void insertIntoTries(Tries root, String[] dictionary, int[] weight) {
        for (int i = 0; i < dictionary.length; i++) {
            Tries temp = root;
            String word = dictionary[i];
            for (int j = 0; j < word.length(); j++) {
                if (temp.hasNext(word.charAt(j)))
                    temp = temp.getNext(word.charAt(j));
                else
                    temp = temp.setNext(word.charAt(j));

                temp.setWeight(weight[i], i);
            }
        }

    }

    private static void searchOnTries(Tries root, String[] dictionary, String[] search) {
        for (int i = 0; i < search.length; i++) {
            Tries temp = root;
            boolean bIsFound = true;
            String prefix = search[i];
            for (int j = 0; j < prefix.length(); j++) {
                if (!temp.hasNext(prefix.charAt(j))) {
                    bIsFound = false;
                    System.out.println("-1 ");
                    break;
                }
                temp = temp.getNext(prefix.charAt(j));
            }

            if (bIsFound)
                temp.autoComplete(dictionary);
        }
    }

    private static class Tries {
        private final Map<Character, Tries> m_next;
        private final Map<Integer, Integer> m_weight;

        public Tries() {
            m_next = new HashMap<>();
            m_weight = new TreeMap<>(Collections.reverseOrder());
        }

        public boolean hasNext(Character data) {
            return m_next.containsKey(data);
        }

        public Tries getNext(Character data) {
            return m_next.get(data);
        }

        public Tries setNext(Character data) {
            Tries temp = new Tries();
            m_next.put(data, temp);
            return temp;
        }

        public void autoComplete(String[] dictionary) {
            int count = 1;
            Set<Integer> keys = m_weight.keySet();
            for (Integer key : keys) {
                System.out.print(dictionary[m_weight.get(key)] + " ");

                if (count < 5)
                    count++;
                else
                    break;
            }
            System.out.println();
        }

        public void setWeight(int key, int value) {
            m_weight.put(key, value);
        }
    }
}
