/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private static final String NULL = "N";
    private static final String SEP = ",";
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root, sb);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        sb.append(node.val).append(SEP);
        dfsSerialize(node.left, sb);
        dfsSerialize(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(SEP);
        int[] index = {0};
        return dfsDeserialize(values, index);
    }

    private TreeNode dfsDeserialize(String[] values, int[] index) {
        if (values[index[0]].equals(NULL)) {
            index[0]++;
            return null;
        }
        TreeNode node = new TreeNode(
            Integer.parseInt(values[index[0]++])
        );
        node.left = dfsDeserialize(values, index);
        node.right = dfsDeserialize(values, index);

        return node;
    }
}
