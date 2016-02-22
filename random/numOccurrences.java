package random;

import java.util.ArrayList;
import java.util.HashMap;

public class numOccurrences {


    public static HashMap<Integer, Integer> count (ArrayList<Integer> list) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int v : list) {
            if(!hm.containsKey(v)) {
                hm.put(v, 1);
            }
            else {
                int num = hm.get(v);
                num++;
                hm.put(v, num);
            }
        }

        return hm;

    }

    public static void main(String[] args) {

        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(6);
        a.add(9);
        a.add(2);
        a.add(1);

        System.out.println(count(a));

    }


}

