// Leetcode 832: Flipping an Image
import java.util.*;

public class Solution832{
    public static void main(String args[]){
        int[][] A = {{1,1,0},{1,0,1},{0,0,0}};
        Solution832 s = new Solution832();
        int[][] result = s.flipAndInvertImage(A);
        for(int[] i: result){
            for (int j: i){
                System.out.printf("%d ", j);
            }
            System.out.println("");
        }
    }

    public int[][] flipAndInvertImage(int[][] A) {
        // TC:O(N), SC:O(1), where N is the totoal number of elements of A
        for (int i = 0; i < A.length; i++){
                for (int j = 0; j < Math.ceil(A[i].length/2.0); j++){
                int temp = A[i][j];
                A[i][j] = A[i][A[i].length-1-j]==1?0:1;
                A[i][A[i].length-1-j] = temp==1?0:1;
            }
        }
        return A;   
    }
}