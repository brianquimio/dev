package fundamentals;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BinarySearch {

    public static int binarySearch(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int mid;
        while(low <= high) {
            mid = (low+high)/2;
            if(a[mid] < x) {
                low = mid+1;
            }
            else if (a[mid] > x) {
                high = mid-1;
            }
            else {
                return mid;
            }
        }

        return -1;

    }

    @Test
    public void test() throws Exception {
        int[] a = {1,3,4,5,7,9};
        int result = binarySearch(a, 3);
        assertThat(result, is(1));
    }
}
