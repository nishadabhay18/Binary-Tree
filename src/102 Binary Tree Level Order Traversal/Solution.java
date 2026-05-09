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
    // TC-> O(n), SC-> O(n)+O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        while(q.size() != 0){
            int size = q.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 1; i<=size; i++){
                TreeNode data = q.remove();
                ans.add(data.val);
                if(data.left != null) q.add(data.left);
                if(data.right != null) q.add(data.right);
            }
            res.add(ans);
        }
        return res;
    }
}
