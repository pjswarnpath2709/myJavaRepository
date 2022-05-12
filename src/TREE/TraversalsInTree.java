package TREE;


public class TraversalsInTree {
    static void inorder(BTNode root) {
        if (root.right == null && root.left == null) {
            System.out.print(root.data + " ");
            return;
        }
        inorder(root.left);
        System.out.printf(root.data + " ");
        inorder(root.right);
    }
    static void postorder(BTNode root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static void preorder(BTNode root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);
        //inorder traversal of the binary tree
        inorder(root);
        System.out.println(" ");
        preorder(root);
        System.out.println(" ");
        postorder(root);
    }
}
