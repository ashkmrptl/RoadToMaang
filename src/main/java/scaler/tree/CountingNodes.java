package scaler.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem Description
 * Given the root of a tree A with each node having a certain value, find the count of nodes with more value than all its ancestor.
 * <p>
 * Problem Constraints
 * 1 <= Number of Nodes <= 200000
 * 1 <= Value of Nodes <= 2000000000
 * <p>
 * Input Format
 * The first and only argument of input is a tree node.
 * <p>
 * Output Format
 * Return a single integer denoting the count of nodes that have more value than all of its ancestors.
 * <p>
 * Example Input
 * Input 1:
 * 3
 * Input 2:
 * 4
 * / \
 * 5   2
 * / \
 * 3   6
 * <p>
 * Example Output
 * Output 1:
 * 1
 * Output 2:
 * 3
 * <p>
 * Example Explanation
 * Explanation 1:
 * There's only one node in the tree that is the valid node.
 * Explanation 2:
 * The valid nodes are 4, 5 and 6.
 */
public class CountingNodes {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    private static int count = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(solve(root));
    }

    private static int solve(TreeNode A) {
        /*List<Integer> ancestors = new ArrayList<>();
        preorder(A, ancestors);

        return count;*/
        return dfs(A, 0);
    }

    private static int dfs(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        int ans = dfs(node.left, Math.max(node.val, max)) + dfs(node.right, Math.max(node.val, max));
        if (node.val > max) {
            ans = ans + 1;
        }

        return ans;
    }

    private static void preorder(TreeNode node, List<Integer> ancestors) {
        if (ancestors.isEmpty() && node != null) {
            count++;
        } else if (node != null) {
            int value = node.val;
            boolean isGreatest = true;

            for (int i = 0; i < ancestors.size(); i++) {
                if (ancestors.get(i) >= value) {
                    isGreatest = false;
                    break;
                }
            }
            if (isGreatest) {
                count++;
            }
        }
        if (node == null) {
            return;
        }

        ancestors.add(node.val);
        preorder(node.left, ancestors);
        if (node.left != null) {
            ancestors.remove(ancestors.size() - 1);
        }

        preorder(node.right, ancestors);
        if (node.right != null) {
            ancestors.remove(ancestors.size() - 1);
        }
    }
}
