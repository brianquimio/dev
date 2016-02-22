package random;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class distinctNum {

    public static List<Integer> findIntersect(List<ArrayList<Integer>> groups) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int set=0; set<groups.size(); set++) {
            List<Integer> list = groups.get(set);          //forgot this
            for(int num=0; num<list.size(); num++) {
                int val = list.get(num);                    //forgot this
                if(!map.containsKey(val)) {
                    map.put(val, 1);
                }
                else {
                    int count = map.get(val);
                    count++;    //forgot this
                    map.put(val, count);
                }
            }
        }

        int groupSize = groups.size();
        List<Integer> answer = new ArrayList<Integer>();
        for(int key : map.keySet()) {
            int occurrences = map.get(key);
            if(occurrences == groupSize) {
                answer.add(key);
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        ArrayList<Integer> l = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        ArrayList<Integer> l3 = new ArrayList<>();
        List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        l.add(1);
        l.add(7);

        l2.add(5);
        l2.add(8);
        l2.add(1);

        l3.add(5);
        l3.add(1);
        l3.add(2);

        a.add(l);
        a.add(l2);
        a.add(l3);

        System.out.println(findIntersect(a));

    }

}
