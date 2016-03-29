package random;


import java.util.ArrayList;

public class PascalRow {

    public static ArrayList<Integer> pascalRow (int k) {
        ArrayList<ArrayList<Integer>> M = new ArrayList<ArrayList<Integer>>(k+1);
        ArrayList<Integer> ret;

        ret = new ArrayList<Integer>();
        ret.add(1);
        M.add(ret);

        ret = new ArrayList<Integer>();
        ret.add(1);
        ret.add(1);
        M.add(ret);

        ArrayList<Integer> before;
        int i = 2;
        while(i <= k) {
            before = M.get(i-1);
            ret = new ArrayList<Integer>();
            ret.add(1);
            for(int j=0; j<before.size()-1; j++) {
                ret.add(before.get(j) + before.get(j+1));
            }
            ret.add(1);
            M.add(ret);
            i++;
        }

        return M.get(k);
    }

    public static void main(String[] args) {
        System.out.println(pascalRow(6));
    }


}
