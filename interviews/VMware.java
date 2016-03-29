package interviews;

import org.junit.Test;
import static org.junit.Assert.*;

public class VMware {

    /*
        Given needle, return index of first occurence in haystack
        Otherwise return -1
     */
    public static int substring (String needle, String haystack) {

        int result = -1;
        char first = needle.charAt(0);
        for(int i=0; i<=haystack.length()-needle.length(); i++) {
            if (first == haystack.charAt(i)) {
                result = i;
                int temp = i;
                for (int j=0; j<needle.length(); j++){
                    if(needle.charAt(j) != haystack.charAt(temp)) {
                        break;
                    }
                    temp++;
                }
                if(temp - i == needle.length()) {
                    return result;
                }
                result =  -1;
            }
        }

        return result;

    }

    @Test
    public void testSubstring () throws Exception {

        int expected = 6;
        int result = substring("abc", "xyz123abc");
        assertEquals(expected, result);

        expected = -1;
        result = substring("abc", "xyzab123");
        assertEquals(expected, result);

        expected = -1;
        result = substring("abc", "xyz123ab");
        assertEquals(expected, result);

    }

    //TODO: web crawler question


}
