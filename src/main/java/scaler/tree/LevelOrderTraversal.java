package scaler.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        final TreeNode five = new TreeNode(5);
        final TreeNode six = new TreeNode(6);
        final TreeNode seven = new TreeNode(7);
        final TreeNode eight = new TreeNode(8);
        final TreeNode nine = new TreeNode(9);
        final TreeNode ten = new TreeNode(10);
        final TreeNode eleven = new TreeNode(11);
        final TreeNode twelve = new TreeNode(12);
        final TreeNode thirteen = new TreeNode(13);
        final TreeNode fourteen = new TreeNode(14);
        final TreeNode fifteen = new TreeNode(15);

        five.left = six;
        five.right = seven;
        six.left = eight;
        six.right = nine;
        nine.right = twelve;
        twelve.left = fourteen;
        seven.left = ten;
        seven.right = eleven;
        eleven.right = thirteen;
        thirteen.right = fifteen;

        ArrayList<ArrayList<Integer>> ans = solve(five);

        for (ArrayList<Integer> list : ans) {
            for (Integer e : list) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<Integer> innerList = new ArrayList<>();
        final ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        final Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        queue.add(null);

        while (queue.size() > 1) {
            final TreeNode node = queue.poll();
            if (node == null) {
                list.add(innerList);
                queue.add(null);
                innerList = new ArrayList<>();
                continue;
            }

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
            innerList.add(node.val);
        }

        list.add(innerList);

        return list;
    }
}
