/* Node is defined as
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}*/
class Tree {
    // TC-> O(n) SC-> O(n)
    public static class Pair{
        Node node;
        int lvl;
        Pair(Node node, int lvl){
            this.node = node;
            this.lvl = lvl;
        }
    }
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair> q = new ArrayDeque<>();
        HashMap<Integer, List<Integer>> mp = new HashMap<>();
        if(root != null) q.add(new Pair(root, 0));
        while(q.size() != 0){
            Pair p = q.remove();
            int lvl = p.lvl;
            Node node = p.node;
            while(node != null){
                mp.putIfAbsent(lvl, new ArrayList<>());
                mp.get(lvl).add(node.data);
                if(node.left != null) q.add(new Pair(node.left, lvl+1));
                node = node.right;
            }
        }
        for(List<Integer> value : mp.values()){
            ans.addAll(value);
        }
        return ans;
    }
}