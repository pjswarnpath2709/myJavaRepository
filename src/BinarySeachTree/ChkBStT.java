package BinarySeachTree;

public class ChkBStT {
    private static boolean chkbst(BstNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        boolean t1 = (root.data <= max && root.data >= min);
        boolean tleft = chkbst(root.left, min, root.data);
        boolean tright = chkbst(root.right, root.data, max);
        return t1 && tleft && tright;
    }

    static boolean chkBST(BstNode root) {
        return chkbst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        BstNode root = new BstNode(4);
        root.left = new BstNode(2);
        root.right = new BstNode(5);
        root.left.left = new BstNode(1);
        root.left.right = new BstNode(3);

        if (chkBST(root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
