package ctci.TreesAndGraphs;

public class Trees4_5 {

    public class Node {
        public Node left;
        public Node right;
        public int data;
    }

    //verify binary search tree
    int index = 0;
    public void treeToArray(Node root, int[] data) {
        if (root == null) {
            return;
        }
        treeToArray(root.left, data);
        data[index] = root.data;
        treeToArray(root.right, data);
    }

    public boolean checkBST(int[] data) {
        for(int i=1; i<data.length; i++) {
            if(data[i] >= data[i-1]) {
                return false;
            }
        }

        return true;
    }


}
