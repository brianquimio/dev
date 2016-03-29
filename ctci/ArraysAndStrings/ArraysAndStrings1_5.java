package ctci.ArraysAndStrings;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArraysAndStrings1_5 {

    //counts repeated characters e.g. 'aabcccccaaa' ==> a2b1c5a3
    //TODO: Not Finished yet
    public static String oneDotFive (String s) {

        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        int count = 1;
        char behind, c, front;
        for (int i=1; i<arr.length-1; i++) {
            behind = arr[i-1];
            c = arr[i];
            front = arr[i+1];

            //aab abc bcc ==> a2b1

            if (behind != c) {
                sb.append(behind);
            }

            if (c == front) {
                count++;
            } else if (c != front) {
                sb.append(count);
            }
        }

        if (sb.toString().length() >= s.length()) {
            return s;
        }

        System.out.println(s + " ==> " + sb.toString());
        return sb.toString();
    }

    @Test
    public void testOneDotFive() throws Exception {

    }


}
