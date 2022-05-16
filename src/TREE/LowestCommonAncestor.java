package TREE;

import java.util.ArrayList;

public class LowestCommonAncestor {

    static boolean findPath(BTNode root, int n, ArrayList<BTNode> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean t1 = findPath(root.left, n, path);
        boolean t2 = findPath(root.right, n, path);

        if (t1 || t2) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

    static BTNode lca(BTNode root, int n1, int n2) {
        ArrayList<BTNode> path1, path2;
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            return null;
        }

        for (int i = 0; i < path1.size() - 1 && i < path2.size() - 1; i++) {
            if (path1.get(i + 1) != path2.get(i + 1)) {
                return path1.get(i);
            }
        }

        return null;
    }

    /*

this assumes that both the node is definitely present in the binary tree ,
if any of the one is missing then it will return a wrong answer


4 cases need to be considered in this efficient method

case a) when the current node  is null simply return *NULL*

case b) when the current node is the node of n1 or n2 , then simply returns the
*ADDRESS OF CURRENT NODE* only

case c) when the current node has lca present on either of its subtree
then simply returns that *LCA* only

case d) when both the subtree contains a lca then current node is the real lca
hence we got the answer and return the *CURRENT NODE* as the answer

*/
    static BTNode lcaEfficient(BTNode root, int n1, int n2) {

        if (root == null) {
            return null;
        }
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        BTNode lca1 = lcaEfficient(root.left, n1, n2);
        BTNode lca2 = lcaEfficient(root.right, n1, n2);

        if (lca1 != null && lca2 != null) {
            return root;
        }
        if (lca1 != null) {
            return lca1;
        } else {
            return lca2;
        }
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(20);
        root.right = new BTNode(30);
        root.right.left = new BTNode(40);
        root.right.right = new BTNode(50);
        int n1 = 20, n2 = 50;

        BTNode ans = lca(root, n1, n2);
        BTNode ans2 = lcaEfficient(root, n1, n2);
        assert ans != null;
        System.out.println("LCA normal version : " + ans.data);
        assert ans2 != null;
        System.out.println("LCA efficient version : " + ans2.data);

    }
}
