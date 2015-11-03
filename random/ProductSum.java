package random;

public class ProductSum {
    /*
     *  Find max product sum where number can only be multiplied by at most one neighbor
     */

    public static int[] list = {1,2,3,1,2,4,1};
    public static int[] M = new int[list.length+2];
    public static void main (String[] args) {
        M[0] = list[0];
        M[1] = list[1];

        System.out.println(productSum());
    }

    public static int productSum () {
        for(int i=2; i<list.length; i++) {
            M[i] = Math.max(list[i] + M[i-1], list[i]*list[i-1] + M[i-2]);
        }
        return M[list.length-1];
    }
}
