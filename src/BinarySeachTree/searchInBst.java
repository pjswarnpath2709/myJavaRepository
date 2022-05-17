package BinarySeachTree;

public class searchInBst {

    static boolean searchBST(BstNode root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }
        if (root.data < value) {
            return searchBST(root.right, value);
        } else {
            return searchBST(root.left, value);
        }
    }

    static boolean searchIteravtive(BstNode root, int key) {
        while (root != null) {
            if (root.data == key) {
                return true;
            } else if (root.data > key) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BstNode root=new BstNode(15);
        root.left=new BstNode(5);
        root.left.left=new BstNode(3);
        root.right=new BstNode(20);
        root.right.left=new BstNode(18);
        root.right.left.left=new BstNode(16);
        root.right.right=new BstNode(80);
        int x=16;

        if(searchIteravtive(root,x))
            System.out.println("Found");
        else
            System.out.println("Not Found");
        if(searchBST(root,x))
            System.out.println("Found");
        else
            System.out.println("Not Found");
    }
}
