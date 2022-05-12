package TREE;

public class CheckForBalancedBinaryTree {
    static int getHeight(BTNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    static boolean isBalancedBT(BTNode root) {
        if (root == null) return true;
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return (Math.abs(lh - rh) <= 1 && isBalancedBT(root.left) && isBalancedBT(root.right));
    }

    //returns -1 if unbalanced else returns the height of the tree
    static int is_Balanced_BT(BTNode root) {
        if (root == null) return 0;
        int lh = is_Balanced_BT(root.left);
        if (lh == -1) return -1;
        int rh = is_Balanced_BT(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }


    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);
        System.out.println(is_Balanced_BT(root));
        System.out.println(isBalancedBT(root));
    }
}
