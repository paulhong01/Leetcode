// Leetcode 48: Rotate Image
import java.util.*;

public class Solution48 {
    public static void main(String[] args) {
        // int[][] matrix = {{1,2,3},
        //                   {4,5,6},
        //                   {7,8,9}};
        int[][] matrix = {
                         { 5, 1, 9,11},
                         { 2, 4, 8,10},
                         {13, 3, 6, 7},
                         {15,14,12,16}
                         };

        Solution48 sol = new Solution48();
        sol.rotate(matrix);
        for(int[] row: matrix) {
            for (int c: row) {
                System.out.printf("%d ", c);
            }
            System.out.println();
        }
    }

    public void rotate(int[][] matrix) {
        // TC:O(n^2), SC:O(1)
        int n = matrix.length;
        int gap = n - 1;
        int size = n * n + 1;

        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                int count = 0;
                int idx = i*n + j;
                int value = matrix[i][j];
                while (count < 4) {
                    int nextidx = (idx + gap * (idx + 1)) % size;
                    int row = nextidx/n, col = nextidx%n;
                    int temp = matrix[row][col];
                    matrix[row][col] = value;
                    value = temp;
                    idx = nextidx;
                    count++;
                }
            }
        }
    }
}