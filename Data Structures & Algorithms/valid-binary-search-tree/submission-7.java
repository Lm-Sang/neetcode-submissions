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

class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if (!checkLeft(root.left, root.val)) {
            return false;
        }
        if (!checkRight(root.right, root.val)) {
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean checkLeft(TreeNode root, int leftVal) {
        if (root == null) {
            return true;
        }
        if (root.val >= leftVal) {
            return false;
        }
        return checkLeft(root.left, leftVal)
            && checkLeft(root.right, leftVal);
    }

    private boolean checkRight(TreeNode root, int rightVal) {
        if (root == null) {
            return true;
        }
        if (root.val <= rightVal) {
            return false;
        }
        return checkRight(root.left, rightVal)
            && checkRight(root.right, rightVal);
    }
}
