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
    // RECURSIVE VERSION TC-> O(n) SC-> O(n) +O(n) Recursion Stack Space
    public void inorder(TreeNode root, List<Integer> ans){
        if (root== null) return;
        inorder(root.left,ans);
        inorder(root.right,ans);
        ans.add(root.val);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    // ITERATIVE VERSION TC-> O(n) SC-> O(n)+O(n) Stack Space
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack <TreeNode> st= new Stack<>();
        if (root!= null) st.push(root);
        while(st.size()>0){
            TreeNode front = st.pop();
            ans.add(front.val);
            if(front.left!=null) st.push(front.left);
            if(front.right!=null) st.push(front.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}
