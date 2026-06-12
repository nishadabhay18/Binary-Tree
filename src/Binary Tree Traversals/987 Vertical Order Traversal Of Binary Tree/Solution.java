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
    // M-1 for same level elemets cant make it in sorted order
    // TreeMap making all keys of map in sorted order (ascending) & for soritng it takes logn time
    public static class Pair{
        TreeNode node;
        int lvl;
        Pair(TreeNode node, int lvl){
            this.node = node;
            this.lvl = lvl;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        TreeMap<Integer, List<Integer>> mp = new TreeMap<>();
        if(root != null) q.add(new Pair(root, 0));
        while(q.size() != 0){
            Pair p = q.remove();
            TreeNode node = p.node;
            int lvl = p.lvl;
            mp.putIfAbsent(lvl, new ArrayList<>());
            mp.get(lvl).add(node.val);
            if(node.left != null) q.add(new Pair(node.left, lvl-1));
            if(node.right != null) q.add(new Pair(node.right, lvl+1));
        }
        for(List<Integer> list : mp.values()) {
            ans.add(list);
        }
        return ans;
    }

    // M-2 after making pq instead of list still it has some bugs according to description
    public static class Pair{
        TreeNode node;
        int lvl;
        Pair(TreeNode node, int lvl){
            this.node = node;
            this.lvl = lvl;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        TreeMap<Integer, PriorityQueue<Integer>> mp = new TreeMap<>();
        if(root != null) q.add(new Pair(root, 0));
        while(q.size() != 0){
            Pair p = q.remove();
            TreeNode node = p.node;
            int lvl = p.lvl;
            mp.putIfAbsent(lvl, new PriorityQueue<>());
            mp.get(lvl).add(node.val);
            if(node.left != null) q.add(new Pair(node.left, lvl-1));
            if(node.right != null) q.add(new Pair(node.right, lvl+1));
        }
        for(PriorityQueue<Integer> pq : mp.values()) {
            List<Integer> arr = new ArrayList<>();
            while(pq.size() != 0) arr.add(pq.poll());
            ans.add(arr);
        }
        return ans;
    }

    // M-3 final after making mp of mp it is done
    // TC-> O(nlogn) SC-> O(n)
    public static class Triplet{
        TreeNode node;
        int vertical;
        int lvl;
        Triplet(TreeNode node, int vertical, int lvl){
            this.node = node;
            this.vertical = vertical;
            this.lvl = lvl;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Triplet> q = new ArrayDeque<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        if(root != null) q.add(new Triplet(root, 0, 0));
        while(q.size() != 0){
            Triplet t = q.remove();
            TreeNode node = t.node;
            int vertical = t.vertical;
            int lvl = t.lvl;
            mp.putIfAbsent(vertical, new TreeMap<>());
            mp.get(vertical).putIfAbsent(lvl, new PriorityQueue<>());
            mp.get(vertical).get(lvl).add(node.val);
            if(node.left != null) q.add(new Triplet(node.left, vertical-1, lvl+1));
            if(node.right != null) q.add(new Triplet(node.right, vertical+1, lvl+1));
        }
        for(TreeMap<Integer, PriorityQueue<Integer>> value: mp.values()){
            List<Integer> arr = new ArrayList<>();
            for(PriorityQueue<Integer> pq : value.values()){
                while(pq.size() != 0) arr.add(pq.poll());
            }
            ans.add(arr);
        }
        return ans;
    }
}