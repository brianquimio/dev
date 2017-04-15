package ctci.ArraysAndStrings;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ArraysAndStrings1_4 {

    //replace spaces with '%20'
    public static String oneDotFour (String s) {
        if (s == null || s.length() <= 0)
            throw new IllegalArgumentException("String can't be null or empty");

        StringBuilder sb = new StringBuilder();

        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Test
    public void testOneDotFour() throws Exception {
        String result = oneDotFour("Hi Brian");
        assertThat(result, is("Hi%20Brian"));

        result = oneDotFour("Hi Brian ");
        assertThat(result, is("Hi%20Brian%20"));
    }
}