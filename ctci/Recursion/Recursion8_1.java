package ctci.Recursion;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class Recursion8_1 {

    //8.1
    public static int countWays (int n) {
        int[] M = new int[n+1];
        Arrays.fill(M, -1);
        return countWays(n, M);

    }

    public static int countWays (int n, int[] M) {
        if(n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        }
        else if (M[n] > - 1) {
            return M[n];
        }
        else {
            M[n] = countWays(n-3, M) + countWays(n-2, M) + countWays(n-1, M);
            return M[n];
        }
    }

    @Test
    public void test() throws Exception {
        System.out.println(countWays(20));

        assertThat(countWays(3), is(4));
        assertThat(countWays(2), is(2));
    }
}
