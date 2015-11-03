package random;


public class AlgorithmsMaxSum {

    /*
     * CS331 Exam 2
     * Two rules: (1) remove 1st element and don't add anything to score
     *            (2) add 1st and 2nd element to score and delete 1st, 2nd, and 3rd element
     * Find max sum. List may contain negative values
     */


    public static int[] list = {-3, -1, -2, -1, 1, 2, 3};
    public static int[] M = new int[list.length];
    public static void main (String[] args) {

        System.out.println(maxSum());
    }

    public static int maxSum () {
        for (int i=list.length-3; i>=0; i--){
            M[i] = Math.max(list[i]+list[i+1]+ M[i+2], M[i+1]);
        }

        return M[0];

    }


}
