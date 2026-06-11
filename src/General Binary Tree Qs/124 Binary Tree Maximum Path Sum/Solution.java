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
    // TC-> O(n) SC-> O(h)
    public int maxPathSum(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        helper(root, ans);
        return ans[0];
    }
    public int helper(TreeNode root, int[] ans){
        if(root == null) return 0;
        int left = helper(root.left, ans);
        int right = helper(root.right, ans);
        left = Math.max(0,left);
        right = Math.max(0,right);
        int pathSum = left + right + root.val;
        ans[0] = Math.max(ans[0], pathSum);
        return Math.max(left, right) + root.val;
    }
}