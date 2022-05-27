package BinarySeachTree;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSumOfBST {

    static void verticalSum(BstNode root, int distance, TreeMap<Integer, Integer> mp) {
        if (root == null) {
            return;
        }
        verticalSum(root.left, distance - 1, mp);
        int currSum = (mp.get(distance) == null) ? 0 : mp.get(distance);
        mp.put(distance, currSum + root.data);
        verticalSum(root.right, distance + 1, mp);
    }
    static void vSum(BstNode root) {
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        verticalSum(root,0,mp);
        for(Map.Entry<Integer,Integer> sum :mp.entrySet()){
            System.out.print(sum.getValue()+" ");
        }
    }

    public static void main(String[] args) {
        BstNode root = new BstNode(10);
        root.left = new BstNode(20);
        root.right = new BstNode(50);
        root.left.left = new BstNode(30);
        root.left.right = new BstNode(40);
        vSum(root);
    }
}
