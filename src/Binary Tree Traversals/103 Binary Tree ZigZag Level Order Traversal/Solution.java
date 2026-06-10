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
     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         List<List<Integer>> ans = new ArrayList<>();
         int lvl = levels(root);
         for(int i=1; i<=lvl; i++){
             List<Integer> arr = new ArrayList<>();
             if(i % 2 != 0) nthLevel1(root, 1, i, arr);
             else nthLevel2(root, 1, i, arr);
             ans.add(arr);
         }
         return ans;
     }
     public void nthLevel1(TreeNode root, int level, int lvl, List<Integer> arr){
         if(root == null) return;
         if(level > lvl) return;
         if(level == lvl) arr.add(root.val);
         nthLevel1(root.left, level+1, lvl, arr);
         nthLevel1(root.right, level+1, lvl, arr);
     }
     public void nthLevel2(TreeNode root, int level, int lvl, List<Integer> arr){
         if(root == null) return;
         if(level > lvl) return;
         if(level == lvl) arr.add(root.val);
         nthLevel2(root.right, level+1, lvl, arr);
         nthLevel2(root.left, level+1, lvl, arr);
     }

    // TC-> O(n) SC-> O(n) Queue Space
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        boolean direction = true;
        while(q.size() != 0){
            int size = q.size();
            List<Integer> arr = new ArrayList<>();
            for(int i=1; i<=size; i++){
                TreeNode node = q.remove();
                if(direction) arr.add(node.val);
                else arr.add(0, node.val); // add from starting
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            ans.add(arr);
            direction = !direction;
        }
        return ans;
    }
}