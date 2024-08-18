package companies.microsoft;

public class SerializeAndDeserializeBST {

    public static void main(String[] args) {
        final Codec ser = new Codec();
        final Codec deser = new Codec();

        TreeNode root = new TreeNode(2, new TreeNode(1), null);

        String tree = ser.serialize(root);
        TreeNode ans = deser.deserialize(tree);
    }


    private static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            final StringBuilder sb = new StringBuilder();
            preorder(root, sb);

            return sb.toString();
        }

        private void preorder(TreeNode node, StringBuilder sb) {
            if (node == null) {
                return;
            }

            sb.append(node.val).append(" ");
            preorder(node.left, sb);
            preorder(node.right, sb);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("")) {
                return null;
            }

            final String[] array = data.split(" ");

            return buildFromPreorder(array, 0, array.length - 1);
        }

        private TreeNode buildFromPreorder(String[] array, int start, int end) {
            if (start > end) {
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(array[start]));

            int index;
            for (index = start; index <= end; index++) {
                if (Integer.parseInt(array[index]) > root.val) {
                    break;
                }
            }

            TreeNode left = buildFromPreorder(array, start + 1, index - 1);
            TreeNode right = buildFromPreorder(array, index, end);

            root.left = left;
            root.right = right;

            return root;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
