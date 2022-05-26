package BinarySeachTree;

import java.util.HashSet;

public class pairSumInBST {
    static HashSet<Integer> st = new HashSet<>();
    static boolean hasPairSum(BstNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (hasPairSum(root.left, sum)) {
            return true;
        }
        if (st.contains(sum - root.data)) {
            return true;
        } else {
            st.add(root.data);
        }
        return hasPairSum(root.right, sum);
    }

    public static void main(String[] args) {
        BstNode root = new BstNode(10);
        root.left = new BstNode(8);
        root.right = new BstNode(20);
        root.left.left = new BstNode(4);
        root.left.right = new BstNode(9);
        root.right.left = new BstNode(11);
        root.right.right = new BstNode(30);
        root.right.right.left = new BstNode(25);
        int sum=33;
        HashSet<Integer> s=new HashSet<>();
        System.out.print(hasPairSum(root,sum));
    }
}
