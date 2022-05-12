package MyStack;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParanthesis extends IOM {
    public static void main(String[] args) {
        String s = get_String();
        HashMap<Character, Character> hm = new HashMap<>();
        hm.put('[', ']');
        hm.put('{', '}');
        hm.put('(', ')');
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else if (hm.containsKey(st.peek()) && s.charAt(i) == hm.get(st.peek())) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            }
        }
        if (st.isEmpty()) {
            println("yes");
        } else {
            println("no");
        }
    }
}
