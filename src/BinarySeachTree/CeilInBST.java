package BinarySeachTree;

public class CeilInBST {
    static BstNode ceil_rec(BstNode root, int key) {
        if (root == null) {
            return root;
        }
        BstNode left = null, right = null;
        if(root.data==key){
            return root;
        }
        if (root.data < key) {
            right = ceil_rec(root.right, key);
        } else {
            left = ceil_rec(root.left, key);
        }
        if (left != null && right == null && left.data>key) {
            return left;
        } else if (right != null && left == null && right.data>key) {
            return right;
        } else if (left != null && right != null) {
            return (right.data < left.data) ? right : left;
        }else{
            return root;
        }
    }
    static BstNode ceil_iter(BstNode root,int key){
        BstNode res=null;
        while(root!=null){
            if(root.data==key){
                return root;
            }else if(root.data<key){
                root=root.right;
            }else{
                res=root;
                root=root.left;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        BstNode root=new BstNode(15);
        root.left=new BstNode(5);
        root.left.left=new BstNode(3);
        root.right=new BstNode(20);
        root.right.left=new BstNode(18);
        root.right.left.left=new BstNode(16);
        root.right.right=new BstNode(80);
        int x=17;

        System.out.println("Ceil_rec : "+(ceil_rec(root,17).data));
        System.out.println("Ceil_iter : "+(ceil_iter(root,17).data));

    }
}
