package TREE;

public class CreateBianryTreeUsingInorderAndPostOrder {

    static void inorderPrint(BTNode root) {
        if (root != null) {
            inorderPrint(root.left);
            System.out.print(root.data + " ");
            inorderPrint(root.right);
        }
    }

    static int preIndex = 0;

    static BTNode createTree(int in[], int pre[], int is, int ie) {
        if (is > ie) {
            return null;
        }
        BTNode root = new BTNode(pre[preIndex++]);
        int inIndex = is;
        for (int i = is; i <= ie; i++) {
            if (root.data == in[i]) {
                inIndex = i;
                break;
            }
        }

        root.left = createTree(in, pre, is, inIndex - 1);
        root.right = createTree(in, pre, inIndex + 1, ie);
        return root;
    }

    public static void main(String[] args) {
        int in[] = {20, 10, 40, 30, 50};
        int pre[] = {10, 20, 30, 40, 50};
        int n = in.length;
        BTNode root = createTree(in, pre, 0, n - 1);

        inorderPrint(root);
    }
}
