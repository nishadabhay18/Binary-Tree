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
    // TC-> O(n)+O(n)=O(n) SC-> O(n)
    public boolean isSymmetric(TreeNode root){
        invertTree(root.right);
        if(isSameTree(root.left, root.right)) return true;
        return false;
    }
    public void invertTree(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
    }
    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        if(!isSameTree(root1.left, root2.left)) return false;
        if(!isSameTree(root1.right, root2.right)) return false;
        return true;
    }
}