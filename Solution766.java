// Leetcode 766: Toeplitz Matrix
import java.util.*;

public class Solution766{
    public static void main(String args[]){
        //int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        int[][] matrix = {{1,2},{2,2}};
        Solution766 s = new Solution766();
        boolean result = s.isToeplitzMatrix(matrix);
        if (result)
            System.out.println("True");
        else
            System.out.println("False");
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        // TC:O(N), SC:O(1), where N = number of elements of matrix
        for (int i = 0; i < matrix.length-1; i++){
            for (int j = 0; j < matrix[i].length-1; j++){
                if (matrix[i][j] != matrix[i+1][j+1])
                    return false;
            }
        }

        return true;
    }
}