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
    // TC-> O(n^2) SC-> O(h) traversing each node twice
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int diff = Math.abs(levels(root.left) - levels(root.right));
        if(diff > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // TC-> O(n) SC-> O(h)
    static boolean ans;
    public int levels(TreeNode root){
        if(root == null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        int diff = Math.abs(leftLevels - rightLevels);
        if(diff > 1) ans = false;
        return 1 + Math.max(leftLevels, rightLevels);
    }
    public boolean isBalanced(TreeNode root) {
        ans = true;
        levels(root);
        return ans;
    }
}