public class implementationOfBinaryTree {
    public static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val= val;
        }
    }
    public static void display(Node root){
        if(root== null) return; // It is actually a preorder display
        System.out.print(root.val+" ");
        display(root.left);
        display(root.right);
    }

    public static int sumOfNodes(Node root){
        if (root == null) return 0;
        return 1+ sumOfNodes(root.left)+ sumOfNodes(root.right);
    }

    public static int maxNode(Node root){
        if(root == null) return Integer.MIN_VALUE;// Return the very smallest value so that it can be neglected as compared to others.
        return Math.max(root.val , Math.max(maxNode(root.left), maxNode(root.right)));
    }

    public static int minNode(Node root){
        if(root== null) return Integer.MAX_VALUE;// Return the very largest value so that it can be neglected a compared to others.
        return Math.min(root.val, Math.min(minNode(root.left), minNode(root.right)));
    }

    public static int sizeOfBinary(Node root){
        if(root == null) return 0;
        return 1 + sizeOfBinary(root.left) +sizeOfBinary(root.right);
    }

    public static int levelsOfBinray(Node root){
        if(root == null) return 0;
        return 1+ Math.max(levelsOfBinray(root.left) , levelsOfBinray(root.right));
    }

    public static int heightsOfBinary(Node root){
        if (root == null ) return 0;
        return Math.max(heightsOfBinary(root.left), heightsOfBinary(root.right));
    }
    public static void main(String []arg){
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        Node g = new Node(7);
        a.left=b; a.right=c;
        b.left=d; b.right=e;
        c.left=f; c.right=g;

        System.out.println(e.val);
        System.out.println(a.left.right.val);
        e.val= 10;
        System.out.println(e.val);
        System.out.println(a.left.right.val);
        display(a);
        System.out.println();
        System.out.println(sumOfNodes(a));
        System.out.println(maxNode(a));
        System.out.println(minNode(a));
        System.out.println(sizeOfBinary(a));
        System.out.println(levelsOfBinray(a));
        System.out.println(heightsOfBinary(a));
    }
}

