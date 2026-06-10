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
    // TC-> O(n*h) h height of tree becomes n*n for skwed tree SC-> O(n) Recursion Stack Space
    public int levels(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(levels(root.left), levels(root.right));
    }
    // Here nthLevel can be postorder and inorder both bcoz eventually we want to print nodes when level and lvl both are equal
    public void nthLevel(TreeNode root, int level, int lvl, List<Integer> arr){
        if(root == null) return;
        if(level > lvl) return;
        if(level == lvl) arr.add(root.val);
        nthLevel(root.left, level+1, lvl, arr);
        nthLevel(root.right, level+1, lvl, arr);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        int lvl = levels(root);
        for(int i=1; i<=lvl; i++){
            List<Integer> arr = new ArrayList<>();
            nthLevel(root, 1, i, arr);
            ans.add(arr);
        }
        return ans;
    }

    // TC-> O(n) SC-> O(n) Queue Space
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        while(q.size() != 0){
            int levelSize = q.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=1; i<=levelSize; i++){
                TreeNode z = q.remove();
                arr.add(z.val);
                if(z.left != null) q.add(z.left);
                if(z.right != null) q.add(z.right);
            }
            ans.add(arr);
        }
        return ans;
    }
}