package BinarySeachTree;

public class InsertInBST {

    static BstNode Insert_Reccursive(BstNode root, int key) {
        if (root == null) {
            return new BstNode(key);
        }
        if (root.data > key) {
            root.left = Insert_Reccursive(root.left, key);
        } else if (root.data < key) {
            root.right = Insert_Reccursive(root.right, key);
        }
        return root;
    }

    static BstNode Insert_Iterative(BstNode root, int key) {
        if (root == null) {
            return new BstNode(key);
        }
        BstNode root_to_return = root;
        boolean left = true;
        BstNode prev = root;
        while (root != null) {
            prev = root;
            if (root.data < key) {
                root = root.right;
                left = false;
            }
            if (root.data > key) {
                root = root.left;
                left = true;
            }
        }
        if (left) {
            prev.left = new BstNode(key);
        } else {
            prev.right = new BstNode(key);
        }
        return root_to_return;
    }
}
