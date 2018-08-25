//Leetcode 42: Trapping Rain Water
import java.util.*;

public class Solution42 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        Solution42 sol = new Solution42();
        int res = sol.trap(height);
        System.out.println(res);
    }

    public int trap(int[] height) {
        // Method 1: Brute Force, TC:O(n^2), SC:O(1)
       /*  int result = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = 0, right = 0;
            for (int j = i; j >= 0; j--) {
                left = Integer.max(left, height[j]);
            }

            for (int j = i; j < height.length; j++) {
                right = Integer.max(right, height[j]);
            }
            result += Integer.min(left, right) - height[i];
        }

        return result; */

        // Method 2: Dynamic programming, TC:O(n), SC:O(n)
        if (height.length == 0) {
            return 0;
        }

        int size = height.length;
        int[] left = new int[size];
        left[0] = height[0];
        for (int i = 1; i < size; i++) {
            left[i] = Integer.max(left[i - 1], height[i]);
        }

        int[] right = new int[size];
        right[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right[i] = Integer.max(right[i + 1], height[i]);
        }

        int result = 0;
        for (int i = 1; i < size - 1; i++) {
            result += Integer.min(left[i], right[i]) - height[i];
        }

        return result;
    }
} 