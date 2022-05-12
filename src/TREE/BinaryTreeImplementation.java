package TREE;

class BTNode {
    int data;
    BTNode left;
    BTNode right;

    BTNode(int key) {
        this.data = key;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTreeImplementation {



    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);


    }
}
