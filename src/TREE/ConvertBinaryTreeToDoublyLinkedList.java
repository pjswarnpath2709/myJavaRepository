package TREE;

public class ConvertBinaryTreeToDoublyLinkedList {

    static BTNode prev = null;

    public static BTNode BTToDLL(BTNode root) {

        /*
        we will do in order traversal and keep a prev pointor which can tell our previous node

        dll structure will be like
        left --> prev
        right -->next

        now the crucial part is that if the node's left is null then the node will be the head node
        the leftmost node will be the head
        hence we will traverse in the inorder
        */

        if (root == null) return root;

        //call for the left subtree
        BTNode head = BTToDLL(root.left);

        //current node processing starts
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        //processing ends

        //call for the right subtree
        BTToDLL(root.right);
        return head;
    }

    public static void printlist(BTNode head) {
        BTNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(5);
        root.right = new BTNode(20);
        root.right.left = new BTNode(30);
        root.right.right = new BTNode(35);

        BTNode head = BTToDLL(root);
        printlist(head);
    }
}
