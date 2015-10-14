package interviews;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Brian on 10/5/2015.
 */
public class Citrix2 {

    public static void main(String[] args){
        testUniformDist(600);
        System.out.println();

        TreeNode root = new TreeNode(0);
        buildTree(root);
        System.out.println(maxHeight(root));
    }

    public static void testUniformDist (int numRolls) {
        int[] arr = new int[6];
        int n;
        for(int i=0; i<numRolls; i++){
            n = rollDice();
            arr[n-1]++;
        }

        int x = 1;
        for(int i : arr) {
            System.out.println(x + ": " + i);
            x++;
        }
    }

    /*using coin flipping to simulate rolling a dice*/
    public static int byteToNum (String b) {
        char[] arr = b.toCharArray();
        int exp = arr.length-1;
        int num = 0;
        for (int i=0; i<arr.length; i++) {
            if (arr[i] == '1') {
                num += Math.pow(2, exp);
            }
            exp--;
        }
        return num;
    }

    public static String getByte () {
        String n = "";
        double rand;
        for (int i = 0; i < 3; i++) {
            rand = Math.random();
            if (rand > .5) {
                n += "1";
            }
            else {
                n += "0";
            }
        }

        return n;
    }

    public static int rollDice() {
        String b;
        do {
            b = getByte();
        } while (b.equals("111") || b.equals("000"));

        return byteToNum(b);
    }

    /*find max height of binary tree and explain recursion */
    public static class TreeNode {

        TreeNode left;
        TreeNode right;
        int data;
        TreeNode(int data) {
            this.data = data;
        }

        public TreeNode getLeft (TreeNode node) {
            return node.left;
        }

        public TreeNode getRight (TreeNode node){
            return node.right;
        }

        public void setLeft (TreeNode left) {
            this.left = left;
        }

        public void setRight (TreeNode right) {
            this.right = right;
        }

    }

    public static void buildTree (TreeNode root) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        root.setLeft(one);
        root.setRight(two);
        one.setLeft(three);
        one.setRight(five);
        two.setRight(six);
        three.setLeft(four);
        five.setRight(seven);
        seven.setRight(eight);
    }



    public static int maxHeight(TreeNode node) {
        if(node == null) {
            return 0;
        }
        else {
            return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
        }
    }

    /*
       Java Questions:
        -Overload vs Override
        -Final vs. Finalize vs. Finally
        -HashMap vs. HashTable
        -Java extends vs. implements & Multiple Inheritance
     */
}
