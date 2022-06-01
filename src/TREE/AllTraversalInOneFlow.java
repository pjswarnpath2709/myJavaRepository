package TREE;

import java.util.ArrayList;
import java.util.Stack;

public class AllTraversalInOneFlow {
    static class Pair {
        BTNode node;
        Integer OrderNumber;

        Pair(BTNode node, Integer OrderNumber) {
            this.node = node;
            this.OrderNumber = OrderNumber;
        }
    }

    static void allTraversals(
            BTNode root,
            ArrayList<Integer> pre,
            ArrayList<Integer> in,
            ArrayList<Integer> post
    ) {
        if(root==null){
            return;
        }
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair p = st.peek();
            if(p.OrderNumber==1){
                pre.add(p.node.data);
                p.OrderNumber++;
                if(p.node.left!=null){
                    st.push(new Pair(p.node.left,1));
                }
            }else if(p.OrderNumber==2){
                in.add(p.node.data);
                p.OrderNumber++;
                if(p.node.right!=null){
                    st.push(new Pair(p.node.right,1));
                }
            }else{
                post.add(p.node.data);
                st.pop();
            }

        }
    }
    static void printArrayList(ArrayList<Integer> arr){
        for(Integer ele : arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);

            ArrayList<Integer> pre,in,post;
            pre = new ArrayList<>();
            post=new ArrayList<>();
            in =new ArrayList<>();

            allTraversals(root,pre,in,post);
            printArrayList(pre);
            printArrayList(in);
            printArrayList(post);

    }
}
