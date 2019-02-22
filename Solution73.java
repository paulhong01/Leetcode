// Leetcode 73: Set Matrix Zeroes
import java.util.*;

class Solution73 {
    
    public void setZeroes(int[][] matrix) {
        // Method 1: SC:O(m+n), TC:O(m*n)
        // checkcol = [false true false]
        // checkrow = [false true false]
        
//         int m = matrix.length;
//         int n = matrix[0].length;
//         boolean[] checkcol = new boolean[n];
//         boolean[] checkrow = new boolean[m];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (matrix[i][j] == 0) {
//                     checkcol[j] = true;
//                     checkrow[i] = true;
//                 }
//             }
//         }
        
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (checkcol[j] || checkrow[i]) {
//                     matrix[i][j] = 0;
//                 }
//             }
//         }
//         return;
        
        // Method 2: SC:O(1), TC:(m*n)
        boolean iscol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                iscol = true;
            }
            
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        // check first row
        if (matrix[0][0] == 0) {
            for (int j = 1; j < n; j++) {
                matrix[0][j] = 0;
            }
        } 
        
        // check first col
        if (iscol) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }
}