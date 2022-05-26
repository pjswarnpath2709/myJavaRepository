package BinarySeachTree;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FixTwoNodesInBST {
    static BstNode prev = null;
    static BstNode first = null;
    static BstNode second = null;

    static public void fixBST(BstNode root) {
        if (root != null) {
            fixBST(root.left);

            if (prev != null && root.data < prev.data) {
                if (first == null) {
                    first = prev;
                }
                second = root;
            }
            prev = root;
            fixBST(root.right);
        }
    }

    static void inorder(BstNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BstNode root = new BstNode(18);
        root.left = new BstNode(60);
        root.right = new BstNode(70);
        root.left.left = new BstNode(4);
        root.right.left = new BstNode(8);
        root.right.right = new BstNode(80);

        inorder(root);
        System.out.println();
        fixBST(root);
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
        inorder(root);
    }
}
