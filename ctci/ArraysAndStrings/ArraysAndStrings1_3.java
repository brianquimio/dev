package ctci.ArraysAndStrings;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;

public class ArraysAndStrings1_3 {

    //Permutations
    public static boolean oneDotThree (String a, String b) {
        if (a == null || b == null || a.length() <= 0 || b.length() <= 0)
            throw new IllegalArgumentException("Strings can't be null of empty");

        if (a.length() != b.length())
            return false;

        char [] aArr = a.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : aArr) {
            list.add(c);
        }

        for (int i=0; i<b.length(); i++) {
            if(!list.contains(b.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testOneDotThree() throws Exception {
        boolean result = oneDotThree("abcd", "dbca");
        assertThat(result, is(true));

        result = oneDotThree("zzzz", "zzza");
        assertThat(result, is(false));
    }
}