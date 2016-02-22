package random;

//implement fibonacci recursively and iteratively
// 0 1 1 2 3
import java.util.ArrayList;

public class Fibonacci {

    public static int[] M = new int[20];
    //memoized
    public static int mem(int n) {
        int val = 0;
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else if (M[n] != 0) {
            return M[n];
        }
        else {
            val = M[n-1] + M[n-2];
            M[n] = val;
            return val;
        }
    }

    //recursively
    public static int recur (int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return recur(n - 1) + recur(n - 2);
        }
    }

    public static int iter (int n) {
        int first = 0;
        int second = 1;
        int val = 1;
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        else {
            for (int i = 2; i < n; i++) {
                first = second;
                second = val;
                val = first + second;
            }
            return val;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println(mem(10));
        System.out.println(recur(10));
        System.out.println(iter(10));

    }

}
