package TREE;

public class MaximumInBinaryTree {

    static int getMax(BTNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int ans = Math.max(getMax(root.left), getMax(root.right));
        return Math.max(root.data, ans);

    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);
        System.out.println(getMax(root));
    }
}
