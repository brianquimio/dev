package random;


import org.junit.Test;
import static org.junit.Assert.*;

public class PowerOf2 {

    public boolean iterative(int num) {
        assert num > 0;

        if (num == 1) {
            return true;
        }

        if (num % 2 == 1) {
            return false;
        }

        while(num > 1) {
            if(num % 2 == 1) {
                return false;
            }
            num /= 2;
        }

        return true;
    }

    public boolean recursive (int num) {
        if (num == 1) {
            return true;
        }

        if (num % 2 == 1) {
            return false;
        }

        return recursive(num / 2);
    }


    @Test
    public void test() throws Exception {
        boolean expected = true;
        boolean result = iterative(128);
        assertEquals(result,expected);

        result = iterative(1);
        assertEquals(result, expected);

        expected = false;
        result = iterative(96);
        assertEquals(result, expected);

        result = iterative(98);
        assertEquals(result, expected);
    }

    @Test
    public void test2() throws Exception {
        boolean expected = true;
        boolean result = recursive(128);
        assertEquals(result,expected);

        result = iterative(1);
        assertEquals(result, expected);

        expected = false;
        result = recursive(96);
        assertEquals(result, expected);

        result = recursive(98);
        assertEquals(result, expected);
    }
}
