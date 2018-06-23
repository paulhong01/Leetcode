import java.util.*;

public class Solution852{
    public static void main(String[] args) {
        int []A = {0, 2, 1, 0};
        Solution852 s = new Solution852();
        int result = s.peakIndexInMountainArray(A);
        System.out.printf("Result: %d \n", result);
        return;
    }

    public int peakIndexInMountainArray(int[] A) {
        int l = 0;
        int h = A.length -1 ;
        
        while (l <= h){
            int m = l + (h - l)/2;
            if (A[m] > A[m-1] && A[m] > A[m+1])
                return m;
            else if (A[m] > A[m-1] && A[m+1] > A[m]){
                l = m + 1;
            } else{
                h = m - 1;
            }
        }
        return -1;
    }
}