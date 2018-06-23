// Kth Smallest Element in a Sorted Matrix
import java.util.*;

class Solution378{
    public static void main(String args[]){
        int matrix[][] = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        //int matrix[][] = {{1}};
        int k = 1;
        Solution378 s = new Solution378();
        int result = s.kthSmallest(matrix, k);
        System.out.printf("%d\n", result);
    }

    public int kthSmallest(int[][] matrix, int k){
        k--;
        int len = matrix.length;
        int row = k/len;
        int col = k - row*len;
        return matrix[row][col];
    }
}