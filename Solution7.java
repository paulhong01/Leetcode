// Leetcode 7: Reverse Integer
import java.util.*;

public class Solution7 {
    public static void main(String[] args) {
        // int x = 123;
        int x = -123;

        Solution7 sol = new Solution7();
        int res = sol.reverse(x);
        System.out.println(res);
    }

    public int reverse(int x) {
        // TC:O(log(x)), TC:O(1)
        System.out.println(Integer.MIN_VALUE);
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE/10 || (result == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (result < Integer.MIN_VALUE/10 || (result == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            result = result * 10 + pop;
        }
        return result;
    }
}