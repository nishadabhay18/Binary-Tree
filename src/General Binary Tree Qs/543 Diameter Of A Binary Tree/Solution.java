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
    // TC-> O(n*n) SC-> O(h)
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int myDia = levels(root.left) + levels(root.right);
        int leftDia = diameterOfBinaryTree(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        return Math.max(myDia, Math.max(leftDia, rightDia));
    }

    // TC-> O(n) SC-> O(h)
    static int maxDia;
    public int levels(TreeNode root){
        if(root == null) return 0;
        int leftLevels = levels(root.left);
        int rightLevels = levels(root.right);
        int myDia = leftLevels + rightLevels;
        maxDia = Math.max(myDia, maxDia);
        return 1 + Math.max(leftLevels, rightLevels);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        maxDia = 0;
        levels(root);
        return maxDia;
    }

    // TC-> O(n) SC-> O(h)
    public int levels(TreeNode root, int[] maxDia){
        if(root == null) return 0;
        int leftLevels = levels(root.left, maxDia);
        int rightLevels = levels(root.right, maxDia);
        int myDia = leftLevels + rightLevels;
        maxDia[0] = Math.max(myDia, maxDia[0]);
        return 1 + Math.max(leftLevels, rightLevels);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int[] maxDia = {0};
        levels(root, maxDia);
        return maxDia[0];
    }
}