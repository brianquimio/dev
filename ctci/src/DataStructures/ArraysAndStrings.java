package ctci.src.DataStructures;

import java.util.*;

public class ArraysAndStrings {

    //Strings has all unique characters
    public static boolean oneDotOne (String s) {
        if (s == null || s.length() <= 0)
            throw new IllegalArgumentException("String can't be null or empty");

        boolean result;
        ArrayList<Character> list = new ArrayList<Character>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(!list.contains(c)) {
                list.add(c);
            }
        }

        return list.size() == s.length();
    }

    //Permutations
    public static boolean oneDotThree (String a, String b) {
        if (a == null || b == null || a.length() <= 0 || b.length() <= 0)
            throw new IllegalArgumentException("Strings can't be null of empty");

        if (a.length() != b.length())
            return false;

        char [] aArr = a.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : aArr) {
            list.add(c);
        }

        for (int i=0; i<b.length(); i++) {
            if(!list.contains(b.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    //replace spaces with '%20'
    public static String oneDotFour (String s) {
        if (s == null || s.length() <= 0)
            throw new IllegalArgumentException("String can't be null or empty");

        StringBuilder sb = new StringBuilder();

        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    //counts repeated characters e.g. 'aabcccccaaa' ==> a2b1c5a3
    //TODO: Not Finished yet
    public static String oneDotFive (String s) {

        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();

        int count = 1;
        char behind, c, front;
        for (int i=1; i<arr.length-1; i++) {
            behind = arr[i-1];
            c = arr[i];
            front = arr[i+1];

            //aab abc bcc ==> a2b1

            if (behind != c) {
                sb.append(behind);
            }

            if (c == front) {
                count++;
            } else if (c != front) {
                sb.append(count);
            }
        }

        if (sb.toString().length() >= s.length()) {
            return s;
        }

        System.out.println(s + " ==> " + sb.toString());
        return sb.toString();
    }




}

