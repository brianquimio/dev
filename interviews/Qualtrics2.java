package interviews;

import java.util.*;

import com.sun.deploy.util.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class Qualtrics2 {

    /*
        ArrayList vs LinkedList
        Internal HashMap implementation
     */

    //return new array with first occurrence of target removed
    public static String[] removeOccurrence (String[] strs, String target){
        String[] ret = new String[strs.length-1];
        int retIndex = 0;
        boolean notFound = true;
        for(int i=0; i<strs.length; i++) {
            if(retIndex == strs.length - 1 && !strs[i].equals(target)) {
                return strs;
            }
            else if(notFound && strs[i].equals(target)) {
                notFound = false;
            }
            else {
                ret[retIndex] = strs[i];
                retIndex++;
            }
        }

        return ret;
    }

    @Test
    public void test1() throws Exception {
        String[] expected = {"apple", "pear", "orange"};
        String[] s = {"apple", "orange", "pear", "orange"};
        String[] actual = removeOccurrence(s, "orange");
        assertEquals(expected, actual);

        String[] actual2 = removeOccurrence(s, "tomato");
        assertEquals(s, actual2);

        String[] s3 = {"apple", "orange", "pear"};
        String[] expected3 = {"apple", "orange"};
        String[] actual3 = removeOccurrence(s3, "pear");
        assertEquals(expected3, actual3);

    }

    public class Path {
        String path;
        LinkedList<String> l = new LinkedList<>();
        public Path (String path) {
            this.path = path;
            cd(path);
        }

        public void cd(String path) {
            String[] dir = path.split("/");
            if(dir[0].equals("")) {
                l = new LinkedList<String>();
            }
            for(String d : dir) {
                if(d.equals(".")) {
                    continue;
                }
                else if (d.equals("..")) {
                    l.removeLast();
                }
                else {
                    l.add(d + "/");
                }
            }
        }

        public String getAbsolutePath() {
            return StringUtils.join(l, "");
        }
    }

    @Test
    public void test2() throws Exception {
        Path p = new Path("/a/./b/c/d/../../e"); // a/b/e/
        assertEquals(p.getAbsolutePath(), "/a/b/e/");
        p.cd("x/./y/../z/");
        assertEquals(p.getAbsolutePath(), "/a/b/e/x/z/");
        p.cd("/d/e/f/");
        assertEquals(p.getAbsolutePath(), "/d/e/f/");

    }

    //intersection of two arrays; contains duplicates
    public static ArrayList<Integer> findIntersection (Integer[] a, Integer[] b) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        HashSet<Integer> aSet = new HashSet<Integer>(Arrays.asList(a));
        HashSet<Integer> bSet = new HashSet<Integer>(Arrays.asList(b));

        for(int n : aSet) {
            aSet.add(n);
        }

        for(int n : bSet) {
            if(aSet.contains(n)) {
                ret.add(n);
            }
        }

        return ret;
    }

    @Test
    public void test3() throws Exception {
        Integer[] a = {1,4,3,1};
        Integer[] b = {1,2,5,3,3};
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        ArrayList<Integer> result = findIntersection(a, b);

        assertEquals(result, expected);

    }

    //maze if path exists from top to bottom
    public static boolean pathExistsHelper(int[][] grid, int row, int col, boolean[][] visited) {
        if(row < 0 || col < 0 || row > grid.length-1 || col > grid[0].length-1) {
            return false;
        }

        if(row == grid.length-1 && grid[row][col] == 1) {
            return true;
        }

        if(visited[row][col]) {
            return false;
        }

        visited[row][col] = true;
        return pathExistsHelper(grid, row+1, col, visited) || pathExistsHelper(grid, row, col-1, visited)
                || pathExistsHelper(grid, row, col+1, visited);
    }

    public static boolean pathExists(int[][] grid, boolean[][] visited) {
        for(int i=0; i<grid[0].length; i++) {
            if(pathExistsHelper(grid, 0, grid[0][i], visited)) {
                return true;
            }
        }

        return false;
    }

    @Test
    public void test4() throws Exception {
        int[][] grid = {{1,0,0,0}, {1,1,1,1}, {0,0,0,1}, {0,0,0,1}};
        boolean[][] visited = {{false, false, false, false}, {false, false, false, false},
                {false, false, false, false}, {false, false, false, false}};
        boolean expected = true;
        boolean actual = pathExists(grid, visited);
        assertEquals(expected, actual);

        int[][] grid2 = {{1,0,0,0}, {1,1,1,1}, {0,1,1,0}, {0,0,0,1}};
        expected = false;
        actual = pathExists(grid2, visited);
        assertEquals(expected, actual);
    }


    /*
        Why use BST over HashMap
        Adjacency Matrix
     */

    //find max sum of pyramid
    public static int maxSumPyramid(int[][] nums) {
        if(nums.length == 1) {          //   2
            return nums[0][0];          //  1 3
        }                               // 5 9 7
                                        // 4 6 8 0
        int row= nums.length;           //4  6  8  0
        int[] bottom = nums[row-1];     // 11 17 15
        int[] next;                     //   18 20
        int[] maxVals = {};             //     22
        while(row != 1) {
            maxVals = new int[row-1];
            next = nums[row-2];
            for(int i=0; i<maxVals.length; i++) {
                int left = bottom[i];
                int right = bottom[i+1];
                int val = next[i];
                maxVals[i] = Math.max(val + left, val + right);
            }
            bottom = maxVals;
            row--;

        }

        return maxVals[0];
    }


    @Test
    public void test5() throws Exception {
        int[][] nums = {{2}, {1,3}, {5,9,7}, {4,6,8,0}};
        int expected = 22;
        int actual = maxSumPyramid(nums);
        assertEquals(expected, actual);

        int[][] nums2 = {{2}, {1,3}};
        expected = 5;
        actual = maxSumPyramid(nums2);
        assertEquals(expected, actual);

        int[][] nums3 = {{2}, {1,3}, {5,9,7}};
        expected = 14;
        actual = maxSumPyramid(nums3);
        assertEquals(expected, actual);
    }






}
