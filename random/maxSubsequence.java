package random;

public class maxSubsequence {

    public static void main(String[] args) {

        int[] a = {-2, -3, -1, -4, -2};
        maxSubSeq(a);
    }

    public static void maxSubSeq (int[] arr) {

        int sum = arr[0];
        int max = arr[0];
        int start = 0;
        int end = 0;
        int temp = 0;

        for(int i=1; i<arr.length; i++) {
            if(sum > 0)
                sum = sum + arr[i];
            else {
                sum = arr[i];
                temp = i;
            }

            if (sum > max) {
                start = temp;
                end = i;
                max = sum;
            }
        }

        System.out.println(start + " to " + end);
        System.out.println(max);
    }


}
