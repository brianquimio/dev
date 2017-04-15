package interviews;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
        int result = substring("abc", "xyz123abc");
        assertThat(result, is(6));

        result = substring("abc", "xyzab123");
        assertThat(result, is(-1));

        result = substring("abc", "xyz123ab");
        assertThat(result, is(-1));
    }

    //TODO: web crawler question
}
