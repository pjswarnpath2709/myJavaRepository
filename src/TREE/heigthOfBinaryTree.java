package TREE;

public class heigthOfBinaryTree {

    static int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);

        System.out.println(getHeight(root)+" ");

    }
}
