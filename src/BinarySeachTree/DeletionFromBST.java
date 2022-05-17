package BinarySeachTree;

public class DeletionFromBST {

    static BstNode getSuccesor(BstNode root) {
        BstNode curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    static BstNode deleteNode(BstNode root, int key) {
        if (root == null)
            return root;
        else {
            if (root.data < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.data > key) {
                root.left = deleteNode(root.left, key);
            } else {

                //case 1: when there exists no left child
                if (root.left == null) {
                    return root.right;
                }
                //case 2: when the right child is empty
                else if (root.right == null) {
                    return root.left;
                } else {
                    BstNode succ = getSuccesor(root);
                    root.data = succ.data;
                    root.right = deleteNode(root.right, succ.data);
                }
            }
            return root;
        }
    }
    public static void inorder(BstNode root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BstNode root=new BstNode(10);
        root.left=new BstNode(5);
        root.right=new BstNode(15);
        root.right.left=new BstNode(12);
        root.right.right=new BstNode(18);
        int x=15;

        root=deleteNode(root,x);
        inorder(root);
    }
}
