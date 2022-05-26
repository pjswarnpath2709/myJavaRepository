package BinarySeachTree;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapInJava {
    public static void main(String[] args) {
        // Initialization of a TreeMap
        // using Generics
        TreeMap<Integer, String> t
                = new TreeMap<Integer, String>();

        // Inserting the Elements
        t.put(10, "geeks");
        t.put(15, "ide");
        t.put(5, "courses");

        // Prints the TreeMap
        System.out.println(t);

        // Check for the key in the map
        System.out.println(t.containsKey(10));

        // Iterating over TreeMap
        for (Map.Entry<Integer, String> e : t.entrySet())
            System.out.println(e.getKey() + " " + e.getValue());


        // Initialization of a TreeMap
        // using Generics
        TreeMap<Integer, String> tm
                = new TreeMap<Integer, String>();

        // Inserting the Elements
        tm.put(10, "geeks");
        tm.put(15, "ide");
        tm.put(5, "courses");

        // returns the smallest key greater
        // than the passed key i.e., 15
        System.out.println(tm.higherKey(10));

        // returns the greatest smaller key
        // than the passed key i.e., 5
        System.out.println(tm.lowerKey(10));

        // greatest key <= passed key i.e., 10
        System.out.println(tm.floorKey(10));

        // greatest key >= passed key i.e., 10
        System.out.println(tm.ceilingKey(10));


        // Initialization of a TreeMap
        // using Generics
        TreeMap<Integer, String> tm2
                = new TreeMap<Integer, String>();

        // Inserting the Elements
        tm2.put(10, "geeks");
        tm2.put(15, "ide");
        tm2.put(5, "courses");

        // returns the key-value pair corresponding
        // to higher key and prints the associated value
        System.out.println(tm2.higherEntry(10).getValue());

        // returns the key-value pair corresponding
        // to lower key prints the associated value
        System.out.println(tm2.lowerEntry(10).getValue());

        // returns a key-value mapping associated
        // with the greatest key <= to the given key
        System.out.println(tm2.floorEntry(10).getValue());

        // returns a key-value mapping associated
        // with the least key >= to the given key
        System.out.println(tm2.ceilingEntry(10).getValue());
    }
}
