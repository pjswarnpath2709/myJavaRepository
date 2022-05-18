package BinarySeachTree;

public class FloorOfBinarySearchTree {
    static BstNode floor_rec(BstNode root, int key) {
        if (root == null) {
            return root;
        }
        BstNode left = null, right = null;
        //now we will handle the cases right here
        if (root.data == key) {
            return root;
        }
        if (root.data > key) {
            left = floor_rec(root.left, key);
        } else {
            right = floor_rec(root.right, key);
        }
        if (left != null && right == null && left.data<key) {
            return left;
        }
        if (right != null && left == null && right.data<key) {
            return right;
        } else if (right != null && left != null) {
            return (right.data > left.data) ? right : left;
        }
        return root;
    }

    static BstNode floor_iter(BstNode root, int key) {
        BstNode res = null;
        while (root != null) {
            if (root.data == key) {
                return root;
            } else if (root.data > key) {
                root = root.left;
            } else {
                res = root;
                root = root.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        BstNode root = new BstNode(15);
        root.left = new BstNode(5);
        root.left.left = new BstNode(3);
        root.right = new BstNode(20);
        root.right.left = new BstNode(18);
        root.right.left.left = new BstNode(16);
        root.right.right = new BstNode(80);
        int x = 17;

        System.out.println("Floor_rec : " + floor_rec(root, 17).data);
        System.out.println("Floor_iter :" + floor_iter(root, 17).data);
    }
}
