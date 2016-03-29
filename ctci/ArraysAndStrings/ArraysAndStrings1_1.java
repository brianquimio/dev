package ctci.ArraysAndStrings;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ArraysAndStrings1_1 {

    //Strings has all unique characters
    public static boolean oneDotOne (String s) {
        if (s == null || s.length() <= 0)
            throw new IllegalArgumentException("String can't be null or empty");

        boolean result;
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!list.contains(c)) {
                list.add(c);
            }
        }

        return list.size() == s.length();
    }


    @Test
    public void testOneDotOne() throws Exception {
        String s = "abcdefg";
        boolean expected = true;
        boolean result = oneDotOne(s);
        assertEquals(expected, result);

        s = "abcdefga";
        expected = false;
        result = oneDotOne(s);
        assertEquals(expected, result);
    }


}
