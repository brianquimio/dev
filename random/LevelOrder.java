package random;

import java.util.*;

public class LevelOrder {

    public class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }


        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode node;
        while(!q.isEmpty()) {
            node = q.remove();
            if(node.left != null) next.add(node.left);
            if(node.right != null) next.add(node.right);

            level.add(node.val);
            if(q.isEmpty()) {
                q = next;
                next = new LinkedList<TreeNode>();
                ret.add(level);
                level = new ArrayList<Integer>();
            }

        }

        return ret;

    }
}
