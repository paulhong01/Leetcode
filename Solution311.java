// Leetcode 311: Sparse Matrix Multiplication
import java.util.*;

class Solution311 {
    public int[][] multiply(int[][] A, int[][] B) {
        int M1 = A.length, N1 = A[0].length;
        int M2 = B.length, N2 = B[0].length;
        int M = M1, N = N2;
        int[][] ret = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int temp = 0;
                for (int k = 0; k < N1; k++) {
                    temp += B[k][j]*A[i][k];
                }
                ret[i][j] = temp;
            }
        }
        return ret;
    }
}