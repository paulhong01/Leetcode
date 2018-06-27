// Kth Smallest Element in a Sorted Matrix
import java.util.*;

class Solution378{
    public static void main(String args[]){
        int matrix[][] = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        //int matrix[][] = {{1}};
        //int matrix[][] = {{1,2},{3,4}};
        int k = 8;
        Solution378 s = new Solution378();
        int result = s.kthSmallest(matrix, k);
        System.out.printf("%d\n", result);
    }

    public int kthSmallest(int[][] matrix, int k){
        int size = matrix.length;
        int front = matrix[0][0], back = matrix[size-1][size-1];
        while (front < back){
            int mid = front + (back - front)/2;
            int count = 0, j = 0;
            for (int i = 0; i < size; i++){
                j = 0;
                while (j < size && matrix[i][j] <= mid)  {
                    j++;
                }
                count += (j);
            }
            if (count < k){
                front = mid + 1;
            } else{
                back = mid;
            }
        }

        return front;
    }
}