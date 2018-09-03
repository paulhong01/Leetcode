// Leetcode 11: Container With Most Water
import java.util.*;

public class Solution11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};

        Solution11 sol = new Solution11();
        int res = sol.maxArea(height);
        System.out.println(res);
    }

    public int maxArea(int[] height) {
        // Method 1: Brute Force, TC:O(n^2), SC:O(1)
        /* if (height.length <= 1) return 0;
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int temp = Math.min(height[i], height[j]) * (j - i);
                if (temp > result)  result = temp;
            }
        }
        return result; */

        // Method 2: Two pointers, TC:O(n), SC:O(1)
        int result = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int temp = Math.min(height[l], height[r]) * (r - l);
            if (temp > result)  result = temp;
            if (height[l] > height[r])  r--;
            else    l++;
        }
        return result;
    }
}