package random;

import java.util.ArrayList;
import java.util.HashMap;

public class PascalsTriangle {

    //given coordinate (x,y) return number in pascals triangle
    //n C r = n! / r!(n-r)!
    //map row to coordinates
    public static HashMap<Integer, ArrayList<Integer>> m = new HashMap<>();
    public static int getNumber (int x, int y) {
        if(m.get(x) == null) {
            computeTriangle(x);
        }
        return m.get(x).get(y);
    }

    public static void computeTriangle(int row) {
        ArrayList<Integer> row0 = new ArrayList<>();
        row0.add(1);
        m.put(0, row0);
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(1);
        m.put(1, row1);

        ArrayList<Integer> temp, rowOnTop;
        for (int i=2; i<=row; i++) {
            temp = new ArrayList<>();
            rowOnTop = m.get(i-1);
            temp.add(1);
            for (int j=0; j<rowOnTop.size()-1; j++) {
                temp.add(rowOnTop.get(j) + rowOnTop.get(j+1));
            }
            temp.add(1);
            m.put(i, temp);
        }

    }



}
