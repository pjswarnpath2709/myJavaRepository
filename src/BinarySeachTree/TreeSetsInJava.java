package BinarySeachTree;

import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetsInJava {
    public static void main(String[] args) {
        TreeSet<String> st = new TreeSet<>();
        st.add("gfg");
        st.add("courses");
        st.add("ide");
        System.out.println(st);
        System.out.println(st.contains("ide"));
        Iterator<String> it = st.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();


        TreeSet<Integer> s = new TreeSet<>();
        s.add(10);
        s.add(5);
        s.add(2);
        s.add(15);
        s.remove(5);
        for(Integer x: s){
            System.out.print(x+" ");
        }
        System.out.println();


        // Creating an empty TreeSet
        TreeSet<Integer> stm = new TreeSet<>();

        // Elements are added using add() method
        stm.add(10);
        stm.add(5);
        stm.add(2);
        stm.add(15);

        // Prints the largest value lower than 5
        // Here it is 2
        System.out.print(stm.lower(5)+" ");

        // Prints the smallest higher value than 5
        // Between 10 and 15 smallest is 10
        System.out.print(stm.higher(5)+" ");

        // Value <= 5
        System.out.print(stm.floor(5)+" ");

        // Value >= 5
        System.out.print(stm.ceiling(5)+" ");
    }
}
