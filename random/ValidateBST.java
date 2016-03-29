package random;


import java.util.ArrayList;

public class ValidateBST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> ret = copyToArr(root, a);

        for (int i = 1; i < ret.size(); i++) {
            if (ret.get(i - 1) >= ret.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> copyToArr(TreeNode root, ArrayList<Integer> l) {
        if (root == null) {
            return null;
        }

        copyToArr(root.left, l);
        l.add(root.val);
        copyToArr(root.right, l);

        return l;

    }
}
