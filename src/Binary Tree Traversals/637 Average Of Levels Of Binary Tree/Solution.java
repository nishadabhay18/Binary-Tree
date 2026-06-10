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
    // TC-> O(n) SC-> O(n) Queue Space
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root != null) q.add(root);
        while(q.size() != 0){
            int size = q.size();
            double sum = 0;
            for(int i=1; i<=size; i++){
                TreeNode node = q.remove();
                sum += node.val;
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            sum /= size;
            ans.add(sum);
        }
        return ans;
    }
}