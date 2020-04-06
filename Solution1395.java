// Leetcode 1395: Count Number of Teams
import java.util.*;

class Solution {
    public int numTeams(int[] rating) {
        // Method 1: TC:O(N^3), SC:O(1)
        // int ret = 0, N = rating.length;
        // for (int i = 0; i < N; i++) {
        //     for (int j = i+1; j < N; j++) {
        //         for (int k = j + 1; k < N; k++) {
        //             if (rating[k] > rating[j] && rating[j] > rating[i]) {
        //                 ret++;
        //             }
        //             if (rating[i] > rating[j] && rating[j] > rating[k]) {
        //                 ret++;
        //             }
        //         }
        //     }
        // }
        // return ret;
        
        // Method 2: TC:(N^2)
        int ret = 0;
        int len = rating.length;
        for (int j = 0; j < len; j++) {
            int leftSmaller = 0, rightLarger = 0;
            int leftLarger = 0, rightSmaller = 0;
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftSmaller++;
                } else if (rating[i] > rating[j]) {
                    leftLarger++;
                }
            }
            for (int k = j + 1; k < len; k++) {
                if (rating[j] < rating[k]) {
                    rightLarger++;
                } else if (rating[j] > rating[k]) {
                    rightSmaller++;
                }
            }
            ret += leftSmaller * rightLarger + leftLarger * rightSmaller;
        }

        return ret;
    }
}