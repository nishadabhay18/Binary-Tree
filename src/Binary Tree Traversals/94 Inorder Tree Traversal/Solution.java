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
    // RECURSIVE VERSION TC-> O(n) SC-> O(n)+O(n) Recursion Stack Space
    public void inorder(TreeNode root, List<Integer> ans){
        if (root== null) return;
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    // ITERATIVE VERSION TC-> O(n) SC-> O(n)+O(n) Stack Space
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans= new ArrayList<>();
        Stack <TreeNode> st = new Stack<>();
        TreeNode temp = root;
        while(true){
            if(temp!=null){
                st.push(temp);
                temp=temp.left;
            }else{
                if(st.size()==0) break;
                TreeNode top= st.pop();
                ans.add(top.val);
                temp=top.right;
            }
        }
        return ans;
    }

    // MORRIS TRAVERSAL TC-> O(n) SC-> O(1)
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        TreeNode curr= root;
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred =curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }
                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }
                else{
                    pred.right=null;
                    ans.add(curr.val);
                    curr=curr.right;
                }
            }else{
                ans.add(curr.val);
                curr=curr.right;
            }
        }
        return ans;
    }
}