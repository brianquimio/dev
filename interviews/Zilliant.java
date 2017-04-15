package interviews;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/*
 * Input a list of ints and a "golden" number
 * Output true if the list contains a pair of ints whose sum equals the golden number
 */
public class Zilliant {


    @Test
    public void isGoldenTest() throws Exception {

        List<Integer> emptyList = new ArrayList<Integer>();
        assertThat(isGolden(emptyList, 2), is(false));
        assertThat(isGolden(Arrays.asList(1, 1, 2, 3, 5, 8, 13, 21, 34), 17), is(false));
        assertThat(isGolden(Arrays.asList(1, 2, 3, 4, 5), 5), is(true));
        assertThat(isGolden(Arrays.asList(1, 1, 2), 2), is(true));
    }

    public static boolean isGolden (List<Integer> list, int golden) {
        if (list.size() < 2 || golden < 0) {
            //throw new IllegalArgumentException("List must have at least 2 elements and golden number cannot be negative");
            return false;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int num : list) {
            if(num < golden) {
                hashMap.put(num, golden);
            }
        }

        int other;
        for (int val : hashMap.keySet()) {
            other = golden - val;
            if (hashMap.containsKey(other)) {
                System.out.println("[FOUND] Golden #" + golden + ": (" + other + ", " + val + ")" );
                return true;
            }
        }

        System.out.println("No pairs found!");
        return false;

    }

}
