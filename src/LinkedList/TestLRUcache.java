package LinkedList;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.util.*;

class DDnode {
    int key;
    int value;
    DDnode pre;
    DDnode next;

    public DDnode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {
    private HashMap<Integer, DDnode> map;
    private int capacity, count;
    private DDnode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DDnode(0, 0);
        tail = new DDnode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteDDnode(DDnode DDnode) {
        DDnode.pre.next = DDnode.next;
        DDnode.next.pre = DDnode.pre;
    }

    public void addToHead(DDnode DDnode) {
        DDnode.next = head.next;
        DDnode.next.pre = DDnode;
        DDnode.pre = head;
        head.next = DDnode;
    }

    public int get(int key) {
        if (map.get(key) != null) {
            DDnode DDnode = map.get(key);
            int result = DDnode.value;
            deleteDDnode(DDnode);
            addToHead(DDnode);
            System.out.println("Got the value : " +
                    result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" +
                " for the key: " + key);
        return -1;
    }

    public void set(int key, int value) {
        System.out.println("Going to set the (key, " +
                "value) : (" + key + ", " + value + ")");
        if (map.get(key) != null) {
            DDnode DDnode = map.get(key);
            DDnode.value = value;
            deleteDDnode(DDnode);
            addToHead(DDnode);
        } else {
            DDnode DDnode = new DDnode(key, value);
            map.put(key, DDnode);
            if (count < capacity) {
                count++;
                addToHead(DDnode);
            } else {
                map.remove(tail.pre.key);
                deleteDDnode(tail.pre);
                addToHead(DDnode);
            }
        }
    }
}

public class TestLRUcache {
    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value 
        // 10 in the cache. 
        cache.set(1, 10);

        // it will store a key (2) with value 20 in the cache. 
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10 

        // removing key 2 and store a key (3) with value 30 in the cache. 
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found) 

        // removing key 1 and store a key (4) with value 40 in the cache. 
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found) 
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30 
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40 
    }
}

/*

 10
 10 20 10 30 40 50 30 40 60 30


*/