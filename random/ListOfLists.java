package random;

import java.util.ArrayList;

public class ListOfLists {

    //giving infinite number of list of lists, return first occurrence of specified string
    public static int find(ArrayList<?> list, String string, int i) {
        if (i > list.size()) {
            return -1;
        }
        else if (list.get(i) instanceof ArrayList) {
//            for(int i=0; i<list.get(i).size(); i++) {
//                if(list.get(i).get(i) instanceof String)
//            }
        }
        else if (list.get(i) instanceof String) {
            if(list.get(i) == string) {
                return i;
            }
            else {
                return find(list, string, i+1);
            }
        }

        return -1;
    }

}
