// Leetcode 50: Pow(x, n)
import java.util.*;

class Solution50 {
    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        Solution50 sol = new Solution50();
        double res = sol.myPow(x, n);
        System.out.println(res);
    }

    public double myPow(double x, int n) {
        // SC:O(1), SC:O(n)
//         long N = n;
//         if (n < 0) {
//             x = 1/x;
//             N = -N;
//         }
        
//         double result = 1;
//         for (int i = 0; i < N; i++) {
//             result *= x;
//         }
//         return result;
        
        // SC:O(1), SC:O(logn)
        long N = n;
        if (N < 0) {
            x = 1/x;
            N = -N;
        }
        
        double ans = 1;
        double cur_product = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i%2) == 1) {
                ans = ans*cur_product;
            }
            cur_product = cur_product*cur_product;
        }
        return ans;
    }
}