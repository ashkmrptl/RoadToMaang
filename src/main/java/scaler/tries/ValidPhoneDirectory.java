package scaler.tries;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given a phone directory in the form of string array A containing N numeric strings.
 * If any phone number is prefix of another phone number then phone directory is invalid else it is valid.
 * You need to check whether the given phone directory is valid or not if it is valid then return 1 else return 0.
 */
public class ValidPhoneDirectory {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("1234");
        list.add("2342");
        list.add("567");

        System.out.println(solve(list));
    }

    private static int solve(ArrayList<String> A) {
        Node root = new Node();

        int n = A.size();
        for (int i = 0; i < n; i++) {
            if (!isPrefixCheck(root, A.get(i))) {
                return 0;
            }
        }
        return 1;
    }

    private static boolean isPrefixCheck(Node root, String str) {
        Node temp = root;
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (!temp.map.containsKey(ch)) {
                temp.map.put(ch, new Node());
            } else {
                //contains char
                if (temp.flag) {
                    return false;
                }
            }
            temp.visited = true;
            temp = temp.map.get(ch);

        }
        if (temp.flag || temp.visited) {
            return false;
        }
        temp.flag = true;

        return true;
    }

    static class Node {
        boolean flag = false;
        boolean visited = false;
        HashMap<Character, Node> map = new HashMap<>();
    }
}
