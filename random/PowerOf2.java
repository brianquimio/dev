package random;


import org.junit.Test;

import static org.hamcrest.core.Is.is;
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
        assertThat(iterative(128), is(true));
        assertThat(iterative(1), is(true));
        assertThat(iterative(96), is(false));
        assertThat(iterative(98), is(false));
    }

    @Test
    public void test2() throws Exception {
        assertThat(recursive(128), is(true));
        assertThat(recursive(1), is(true));
        assertThat(recursive(96), is(false));
        assertThat(recursive(98), is(false));
    }
}
