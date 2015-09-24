package ctci.test;

import ctci.src.DataStructures.ArraysAndStrings;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArraysAndStringsTest {

    @Test
    public void testOneDotOne() throws Exception {
        String s = "abcdefg";
        boolean expected = true;
        boolean result = ArraysAndStrings.oneDotOne(s);
        assertEquals(expected, result);

        s = "abcdefga";
        expected = false;
        result = ArraysAndStrings.oneDotOne(s);
        assertEquals(expected, result);
    }

    @Test
    public void testOneDotThree() throws Exception {
        String s1 = "abcd";
        String s2 = "dbca";
        boolean expected = true;
        boolean result = ArraysAndStrings.oneDotThree(s1, s2);
        assertEquals(expected, result);

        s1 = "zzzz";
        s2 = "zzza";
        expected = false;
        result = ArraysAndStrings.oneDotThree(s1, s2);
        assertEquals(expected,result);
    }

    @Test
    public void testOneDotFour() throws Exception {
        String s = "Hi Brian";
        String expected = "Hi%20Brian";
        String result = ArraysAndStrings.oneDotFour(s);
        assertEquals(expected, result);

        s = "Hi Brian ";
        expected = "Hi%20Brian%20";
        result = ArraysAndStrings.oneDotFour(s);
        assertEquals(expected, result);
    }

    @Test
    public void testOneDotFive() throws Exception {

    }
}