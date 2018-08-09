// Leetcode 70: Climbing Stairs
import java.util.*;

public class Solution70 {
    public static void main(String[] args) {
        int n = 2;

        Solution70 sol = new Solution70();
        int res = sol.climbStairs(n);
        System.out.println(res);
    }

    public int climbStairs(int n) {
        // Dynamic Programming, TC:O(n), SC:O(1)
        int cur = (n <= 2)?n:2;
        int step1 = 1, step2 = 2;
        for(int i = 2; i < n; i++) {
            cur = step2 + step1;
            step1 = step2;
            step2 = cur;
        }
        return cur;
    }
} 