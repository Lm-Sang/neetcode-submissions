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
        if (root == null || (root.left == null && root.right == null)) return true;

        if (root.left == null && root.right.val > root.val) return isValidBST(root.right);
        else if (root.right == null && root.left.val > root.val) return isValidBST(root.left);
        else if (root.left.val < root.val && root.right.val > root.val){
            return (isValidBST(root.left) && isValidBST(root.right));
        }
        else return false;

    }

}
