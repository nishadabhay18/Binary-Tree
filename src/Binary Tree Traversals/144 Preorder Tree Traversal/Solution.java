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
    // RECURSIVE METHOD TC-> O(n) SC-> O(n)+O(n) Recursion Stack Space
    public void preorder(TreeNode root, List<Integer> ans){
        if (root== null) return;
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root, ans);
    }

    // ITERATIVE VERSION TC-> O(n) SC-> O(n)+O(n) Only Stack Space
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack <TreeNode> st= new Stack<>();
        if (root!= null) st.push(root);
        while(st.size()>0){
            TreeNode front = st.pop();
            ans.add(front.val);
            if(front.right!=null) st.push(front.right);
            if(front.left!=null) st.push(front.left);
        }
        return ans;
    }
}