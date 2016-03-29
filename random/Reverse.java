package random;

import java.util.ArrayList;
import java.util.List;

public class Reverse {


    public static String reverse(String s) {

        int mid = s.length() / 2;
        char[] c = s.toCharArray();
        int end = s.length()-1;
        char temp;
        for (int i=0; i<mid; i++) {
            temp = c[i];
            c[i] = c[end];
            c[end] = temp;
            end--;
        }

        return String.valueOf(c) ;

    }

    public static void main (String[] args) {
        System.out.println(reverse("abcdefghij"));
    }
}
