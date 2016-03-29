package random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AnagramBuckets {

    //input: list of strings
    //output: output set of words that are anagrams of one another

    public static ArrayList<ArrayList<String>> anagramBuckets(ArrayList<String> list) {
        HashMap<String, ArrayList<String>> buckets = new HashMap<>();
        for(String word : list) {
            char[] c = word.toCharArray();
            Arrays.sort(c);
            String sorted = String.valueOf(c);
            if(!buckets.containsKey(sorted)) {
                ArrayList<String> words = new ArrayList<>();
                words.add(word);
                buckets.put(sorted, words);
            }
            else {
                buckets.get(sorted).add(word);
            }
        }

        ArrayList<ArrayList<String>> a = new ArrayList<>();
        for (String key: buckets.keySet()) {
            a.add(buckets.get(key));
        }

        System.out.println(a.toString());
        return a;
    }

    public static void main(String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add("aaab");
        a.add("abaa");
        a.add("dogs");
        a.add("cats");
        a.add("sgdo");
        a.add("baaa");

        anagramBuckets(a);

    }

}
