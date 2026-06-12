/*
Definition for Node
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    // TC-> O(n) SC-> O(n)
    public boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        if(!isLeaf(root)) ans.add(root.data);
        addLeftNodes(root, ans);
        addLeafNodes(root, ans);
        addRightNodes(root, ans);
        return ans;
    }
    public void addLeftNodes(Node root, ArrayList<Integer> ans){
        Node curr = root.left;
        while(curr != null){
            if(!isLeaf(curr)) ans.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }
    public void addLeafNodes(Node root, ArrayList<Integer> ans){
        if(root == null) return;
        if(isLeaf(root)) ans.add(root.data);
        addLeafNodes(root.left, ans);
        addLeafNodes(root.right, ans);
    }
    public void addRightNodes(Node root, ArrayList<Integer> ans){
        ArrayList<Integer> arr = new ArrayList<>();
        Node curr = root.right;
        while(curr != null){
            if(!isLeaf(curr)) arr.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        Collections.reverse(arr);
        ans.addAll(arr);
    }
}