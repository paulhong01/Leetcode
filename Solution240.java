// Leetcode 240: Search a 2D Matrix II
import java.util.*;

public class Solution240 {
    public static void main(String[] args) {
        int[][] matrix = {{1,   4,  7, 11, 15}, {2,   5,  8, 12, 19}, {3,   6,  9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 20;

        Solution240 sol = new Solution240();
        boolean res = sol.searchMatrix(matrix, target);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // TC:O(m + n), SC:O(1)
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = matrix.length, col = matrix[0].length;
        int currow = 0, curcol = col - 1;
        while (currow < row && curcol >= 0) {
            if (matrix[currow][curcol] == target) {
                return true;
            } else if (matrix[currow][curcol] > target) {
                curcol--;
            } else {
                currow++;
            }
        }
        return false;
    }
}