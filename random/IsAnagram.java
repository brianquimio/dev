package random;

import java.util.HashMap;

public class IsAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        if(s.equals(t)) {
            return true;
        }

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        for(char c : sArr) {
            if(!h.containsKey(c)) {
                h.put(c, 1);
            }
            else {
                h.put(c, h.get(c) + 1);
            }
        }

        System.out.println(h.toString());

        for (char c : tArr) {
            if(!h.containsKey(c)) {
                return false;
            }
            else {
                h.put(c, h.get(c) - 1);
            }
        }

        System.out.println(h.toString());

        for(char c : h.keySet()) {
            if(h.get(c) != 0) {
                return false;
            }
        }


        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("ab", "ba"));

    }

}
