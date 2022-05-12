package TREE;

public class LeftViewOfbinaryTree {

    static int maxlevel = 0;

    static void printleft(BTNode root, int level) {
        if (root == null) {
            return;
        }
        if (maxlevel < level) {
            System.out.print(root.data + " ");
            maxlevel = level;
        }
        printleft(root.left, level + 1);
        printleft(root.right, level + 1);
    }

    static void printLeftView(BTNode root) {
        printleft(root, 1);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        printLeftView(root);
    }
}
